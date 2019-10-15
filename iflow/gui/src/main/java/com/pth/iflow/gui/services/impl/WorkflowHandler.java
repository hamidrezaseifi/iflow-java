package com.pth.iflow.gui.services.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowHandler.class);

  private final IWorkflowAccess workflowAccess;

  private final SessionUserInfo sessionUserInfo;

  private final IUploadFileManager uploadFileManager;

  private final IMessagesHelper messagesHelper;

  public WorkflowHandler(@Autowired final IWorkflowAccess workflowAccess,
                         @Autowired final SessionUserInfo sessionUserInfo,
                         @Autowired final IUploadFileManager uploadFileManager,
                         @Autowired final IMessagesHelper messagesHelper) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
    this.uploadFileManager = uploadFileManager;
    this.messagesHelper = messagesHelper;
  }

  @Override
  public Workflow readWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read workflow {}", workflowIdentity);

    final Workflow wirkflow = this.workflowAccess.readWorkflow(workflowIdentity, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(wirkflow);
  }

  @Override
  public List<Workflow> createWorkflow(final WorkflowSaveRequest createRequest, final HttpSession session) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    createRequest.setCommand(EWorkflowProcessCommand.CREATE);
    if (IdentityModel.isIdentityNew(createRequest.getWorkflow().getCurrentStepIdentity())) {

    }

    this.workflowAccess.validateWorkflow(createRequest, this.sessionUserInfo.getToken());

    final List<Workflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());
    final List<Workflow> preparedList = this.prepareWorkflowList(list);

    if (StringUtils.isEmpty(createRequest.getSessionKey())) {
      return preparedList;
    }

    final Object oFileList = session.getAttribute(createRequest.getSessionKey());
    if ((oFileList == null) || ((oFileList instanceof List) == false)) {
      final GuiCustomizedException uiCustomizedException = new GuiCustomizedException("Uploaded files not found!",
                                                                                      "",
                                                                                      EModule.GUI.getModuleName(),
                                                                                      null);

      throw uiCustomizedException;
    }

    final List<UploadFileSavingData> tempFiles = (List<UploadFileSavingData>) oFileList;

    final List<Workflow> finalList = new ArrayList<>();
    if (preparedList != null && tempFiles.isEmpty() == false) {
      for (final Workflow workflow : preparedList) {
        final List<FileSavingData> archiveSavingFileInfoList = new ArrayList<>();
        for (final UploadFileSavingData tempFile : tempFiles) {

          final FileSavingData archiveSavingFileInfo = tempFile.toFileSavingData();
          archiveSavingFileInfo.setWorkflowIdentity(workflow.getIdentity());
          archiveSavingFileInfo
                               .setActionIdentity(workflow.getHasActiveAction() ? workflow.getActiveAction().getIdentity() : "no-action");;
          archiveSavingFileInfo.setFilePath(archiveSavingFileInfo.generateSavingFilePathPreffix());
          archiveSavingFileInfo.setTempFilePath(tempFile.getFilePath());

          archiveSavingFileInfoList.add(archiveSavingFileInfo);
        }
        final List<FileSavingData> savedArchiveFiles = this.uploadFileManager.copyFromTempToArchive(archiveSavingFileInfoList);
        for (final FileSavingData savedArchiveFile : savedArchiveFiles) {

          workflow.addNewFile(savedArchiveFile.generateSavingFilePathPreffix(),
                              this.sessionUserInfo.getUser().getIdentity(),
                              savedArchiveFile.getTitle(),
                              savedArchiveFile.getFileExtention(),
                              "");
        }

        final Workflow finalWorkflow = this.saveWorkflow(workflow, session);

        finalList.add(finalWorkflow);
      }
    }

    this.uploadFileManager.deleteFromTemp(UploadFileSavingData.toFileSavingDataList(tempFiles));

    return finalList;
  }

  @Override
  public Workflow saveWorkflow(final Workflow workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow");

    if (workflow.getHasActiveAction()) {
      workflow.getActiveAction().setCurrentStepIdentity(workflow.getCurrentStepIdentity());
    }

    final WorkflowSaveRequest request = WorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.SAVE);

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final Workflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public Workflow assignWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Assign workflow");

    final Workflow workflow = this.readWorkflow(workflowIdentity);

    final WorkflowSaveRequest request = WorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ASSIGN);
    request.setAssignUser(this.sessionUserInfo.getUser().getIdentity());

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final Workflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);

  }

  @Override
  public Workflow doneWorkflow(final WorkflowSaveRequest saveRequest, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow done");

    saveRequest.setCommand(EWorkflowProcessCommand.DONE);

    this.workflowAccess.validateWorkflow(saveRequest, this.sessionUserInfo.getToken());

    final Workflow result = this.workflowAccess.saveWorkflow(saveRequest, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public Workflow archiveWorkflow(final Workflow workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow archive");

    final WorkflowSaveRequest request = WorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final Workflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public List<WorkflowType> readWorkflowTypeList(final String companyIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read all workflow from company");

    return this.workflowAccess.readWorkflowTypeList(companyIdentity, this.sessionUserInfo.getToken());
  }

  @Override
  public List<Workflow> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Search workflow from company");
    final List<Workflow> list = this.workflowAccess.searchWorkflow(workflowSearchFilter, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);
  }

  @Override
  public WorkflowFile readWorkflowFile(final String workflowIdentity, final String fileIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    Workflow workflow = null;
    if (this.sessionUserInfo.hasCachedWorkflowIdentity(workflowIdentity)) {
      workflow = this.sessionUserInfo.getCachedWorkflow(workflowIdentity);
    }
    else {
      workflow = this.readWorkflow(workflowIdentity);
    }

    final WorkflowFile workflowFile = workflow.getFileByIdentity(fileIdentity);

    return workflowFile;
  }

  private List<Workflow> prepareWorkflowList(final List<Workflow> pureWorkflowList) throws IFlowMessageConversionFailureException {

    final List<Workflow> workflowList = new ArrayList<>();

    if (pureWorkflowList != null) {
      for (final Workflow workflow : pureWorkflowList) {
        workflowList.add(this.prepareWorkflow(workflow));
      }
    }

    return workflowList;
  }

  private Map<String, WorkflowTypeStep> getIdMapedSteps(final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> list = workflowType.getSteps()
                                                           .stream()
                                                           .collect(Collectors.toMap(s -> s.getIdentity(), s -> s));

    return list;
  }

  private WorkflowTypeStep findStepByIdInWOrkflowType(final String stepId, final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> steps = this.getIdMapedSteps(workflowType);

    return steps.containsKey(stepId) ? steps.get(stepId) : null;
  }

  private Workflow prepareWorkflow(final Workflow workflow) throws IFlowMessageConversionFailureException {

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeById(workflow.getWorkflowTypeIdentity()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserByIdentity(workflow.getCreatedByIdentity()));
    workflow.setControllerUser(this.sessionUserInfo.getUserByIdentity(workflow.getControllerIdentity()));
    workflow.setCurrentUserIdentity(this.sessionUserInfo.getUser().getIdentity());
    workflow.setCurrentStep(this.findStepByIdInWOrkflowType(workflow.getCurrentStepIdentity(), workflow.getWorkflowType()));

    for (final WorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.sessionUserInfo.getUserByIdentity(action.getAssignToIdentity()));
      action.setCurrentStep(this.findStepByIdInWOrkflowType(action.getCurrentStepIdentity(), workflow.getWorkflowType()));
    }

    this.prepareWorkflowActions(workflow);

    this.sessionUserInfo.addCachedWorkflow(workflow);

    return workflow;
  }

  private Workflow prepareWorkflowActions(final Workflow workflow) throws IFlowMessageConversionFailureException {

    for (final WorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.sessionUserInfo.getUserByIdentity(action.getAssignToIdentity()));

      action.setCurrentStep(this.findStep(workflow, action.getCurrentStepIdentity()));

      // this.messagesHelper.get("common.not-assigned")

    }

    return workflow;
  }

  private WorkflowTypeStep findStep(final Workflow workflow, final String stepId) {
    if (stepId == null) {
      return null;
    }
    WorkflowTypeStep foundStep = null;
    for (final WorkflowTypeStep step : workflow.getWorkflowType().getSteps()) {
      if (step.getIdentity() == stepId) {
        foundStep = step;
        break;
      }
    }
    return foundStep;
  }

}
