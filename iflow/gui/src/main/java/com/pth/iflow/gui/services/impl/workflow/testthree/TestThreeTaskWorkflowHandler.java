package com.pth.iflow.gui.services.impl.workflow.testthree;

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
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class TestThreeTaskWorkflowHandler implements IWorkflowHandler<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> {

  private static final Logger logger = LoggerFactory.getLogger(TestThreeTaskWorkflowHandler.class);

  private final IWorkflowAccess<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> workflowAccess;

  private final SessionUserInfo sessionUserInfo;

  private final IUploadFileManager uploadFileManager;

  public TestThreeTaskWorkflowHandler(@Autowired final IWorkflowAccess<TestThreeTaskWorkflow,
                                                                       TestThreeTaskWorkflowSaveRequest> workflowAccess,
                                      @Autowired final SessionUserInfo sessionUserInfo,
                                      @Autowired final IUploadFileManager uploadFileManager) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
    this.uploadFileManager = uploadFileManager;
  }

  @Override
  public TestThreeTaskWorkflow readWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read workflow {}", workflowIdentity);

    final TestThreeTaskWorkflow wirkflow = this.workflowAccess.readWorkflow(workflowIdentity, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(wirkflow);
  }

  @Override
  public List<TestThreeTaskWorkflow> createWorkflow(final TestThreeTaskWorkflowSaveRequest createRequest, final HttpSession session) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    createRequest.setCommand(EWorkflowProcessCommand.CREATE);
    if (IdentityModel.isIdentityNew(createRequest.getWorkflow().getCurrentStepIdentity())) {

    }

    this.workflowAccess.validateWorkflow(createRequest, this.sessionUserInfo.getToken());

    final List<TestThreeTaskWorkflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());
    final List<TestThreeTaskWorkflow> preparedList = this.prepareWorkflowList(list);

    if (StringUtils.isEmpty(createRequest.getSessionKey())) {
      return preparedList;
    }

    final Object oFileList = session.getAttribute(createRequest.getSessionKey());
    if ((oFileList == null) || ((oFileList instanceof List) == false)) {
      throw new GuiCustomizedException("Uploaded files not found!");

    }

    final List<UploadFileSavingData> tempFiles = (List<UploadFileSavingData>) oFileList;

    final List<TestThreeTaskWorkflow> finalList = new ArrayList<>();
    if (preparedList != null && tempFiles.isEmpty() == false) {
      for (final TestThreeTaskWorkflow workflow : preparedList) {
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

        final TestThreeTaskWorkflow finalWorkflow = this.saveWorkflow(workflow, session);

        finalList.add(finalWorkflow);
      }
    }

    this.uploadFileManager.deleteFromTemp(UploadFileSavingData.toFileSavingDataList(tempFiles));

    return finalList;
  }

  @Override
  public TestThreeTaskWorkflow saveWorkflow(final TestThreeTaskWorkflow workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow");

    if (workflow.getHasActiveAction()) {
      workflow.getActiveAction().setCurrentStepIdentity(workflow.getCurrentStepIdentity());
    }

    final TestThreeTaskWorkflowSaveRequest request = TestThreeTaskWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.SAVE);

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final TestThreeTaskWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public TestThreeTaskWorkflow assignWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Assign workflow");

    final TestThreeTaskWorkflow workflow = this.readWorkflow(workflowIdentity);

    final TestThreeTaskWorkflowSaveRequest request = TestThreeTaskWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ASSIGN);
    request.setAssignUser(this.sessionUserInfo.getUser().getIdentity());

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final TestThreeTaskWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);

  }

  @Override
  public TestThreeTaskWorkflow doneWorkflow(final TestThreeTaskWorkflowSaveRequest saveRequest, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow done");

    saveRequest.setCommand(EWorkflowProcessCommand.DONE);

    this.workflowAccess.validateWorkflow(saveRequest, this.sessionUserInfo.getToken());

    final TestThreeTaskWorkflow result = this.workflowAccess.saveWorkflow(saveRequest, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public TestThreeTaskWorkflow archiveWorkflow(final TestThreeTaskWorkflow workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow archive");

    final TestThreeTaskWorkflowSaveRequest request = TestThreeTaskWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final TestThreeTaskWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public List<TestThreeTaskWorkflow> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Search workflow from company");
    final List<TestThreeTaskWorkflow> list = this.workflowAccess.searchWorkflow(workflowSearchFilter, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);
  }

  @Override
  public WorkflowFile readWorkflowFile(final String workflowIdentity, final String fileIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    TestThreeTaskWorkflow workflow = null;
    if (this.sessionUserInfo.hasCachedWorkflowIdentity(workflowIdentity)) {
      workflow = (TestThreeTaskWorkflow) this.sessionUserInfo.getCachedWorkflow(workflowIdentity);
    }
    else {
      workflow = this.readWorkflow(workflowIdentity);
    }

    final WorkflowFile workflowFile = workflow.getFileByIdentity(fileIdentity);

    return workflowFile;
  }

  private List<TestThreeTaskWorkflow> prepareWorkflowList(final List<TestThreeTaskWorkflow> pureWorkflowList) throws IFlowMessageConversionFailureException {

    final List<TestThreeTaskWorkflow> workflowList = new ArrayList<>();

    if (pureWorkflowList != null) {
      for (final TestThreeTaskWorkflow workflow : pureWorkflowList) {
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

  private WorkflowTypeStep findStepByIdInWorkflowType(final String stepId, final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> steps = this.getIdMapedSteps(workflowType);

    if (steps.containsKey(stepId)) {
      return steps.get(stepId);
    }
    else {
      return null;
    }
  }

  private TestThreeTaskWorkflow prepareWorkflow(final TestThreeTaskWorkflow workflow) throws IFlowMessageConversionFailureException {

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeById(workflow.getWorkflowTypeIdentity()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserByIdentity(workflow.getCreatedByIdentity()));
    workflow.setControllerUser(this.sessionUserInfo.getUserByIdentity(workflow.getControllerIdentity()));
    workflow.setCurrentUserIdentity(this.sessionUserInfo.getUser().getIdentity());
    workflow.setCurrentStep(this.findStepByIdInWorkflowType(workflow.getCurrentStepIdentity(), workflow.getWorkflowType()));

    this.prepareWorkflowActions(workflow);

    this.sessionUserInfo.addCachedWorkflow(workflow);

    return workflow;
  }

  private TestThreeTaskWorkflow prepareWorkflowActions(final TestThreeTaskWorkflow workflow) throws IFlowMessageConversionFailureException {

    for (final WorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.sessionUserInfo.getUserByIdentity(action.getAssignToIdentity()));
      action.setCurrentStep(this.findStepByIdInWorkflowType(action.getCurrentStepIdentity(), workflow.getWorkflowType()));
    }

    return workflow;
  }

}
