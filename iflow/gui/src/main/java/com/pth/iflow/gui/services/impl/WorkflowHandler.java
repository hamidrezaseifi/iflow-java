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

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowAction;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiWorkflowTypeStep;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  private static final Logger      logger = LoggerFactory.getLogger(WorkflowHandler.class);

  private final IWorkflowAccess    workflowAccess;

  private final GuiSessionUserInfo sessionUserInfo;

  private final IUploadFileManager uploadFileManager;

  private final IMessagesHelper    messagesHelper;

  public WorkflowHandler(@Autowired final IWorkflowAccess workflowAccess, @Autowired final GuiSessionUserInfo sessionUserInfo,
      @Autowired final IUploadFileManager uploadFileManager, @Autowired final IMessagesHelper messagesHelper) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
    this.uploadFileManager = uploadFileManager;
    this.messagesHelper = messagesHelper;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read workflow {}", workflowId);

    final GuiWorkflow wirkflow = this.workflowAccess.readWorkflow(workflowId, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(wirkflow);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowSaveRequest createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    createRequest.setCommand(EWorkflowProcessCommand.CREATE);
    if (createRequest.getWorkflow().getCurrentStepId() == null || createRequest.getWorkflow().getCurrentStepId() <= 0) {

    }

    final List<GuiWorkflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());
    final List<GuiWorkflow> preparedList = this.prepareWorkflowList(list);

    if (StringUtils.isEmpty(createRequest.getSessionKey())) {
      return preparedList;
    }

    final Object oFileList = session.getAttribute(createRequest.getSessionKey());
    if ((oFileList == null) || ((oFileList instanceof List) == false)) {
      final GuiCustomizedException uiCustomizedException = new GuiCustomizedException("Uploaded files not found!", "",
          EModule.GUI.getModuleName());

      throw uiCustomizedException;
    }

    final List<UploadFileSavingData> tempFiles = (List<UploadFileSavingData>) oFileList;

    final List<GuiWorkflow> finalList = new ArrayList<>();
    if (preparedList != null && tempFiles.isEmpty() == false) {
      for (final GuiWorkflow workflow : preparedList) {
        final List<FileSavingData> archiveSavingFileInfoList = new ArrayList<>();
        for (final UploadFileSavingData tempFile : tempFiles) {

          final FileSavingData archiveSavingFileInfo = tempFile.toFileSavingData();
          archiveSavingFileInfo.setWorkflowId(workflow.getId());
          archiveSavingFileInfo.setActionId(0L);
          archiveSavingFileInfo.setFilePath(archiveSavingFileInfo.generateSavingFilePathPreffix());
          archiveSavingFileInfo.setTempFilePath(tempFile.getFilePath());

          archiveSavingFileInfoList.add(archiveSavingFileInfo);
        }
        final List<FileSavingData> savedArchiveFiles = this.uploadFileManager.copyFromTempToArchive(archiveSavingFileInfoList);
        for (final FileSavingData savedArchiveFile : savedArchiveFiles) {

          workflow.addNewFile(savedArchiveFile.generateSavingFilePathPreffix(), this.sessionUserInfo.getUser().getId(),
              savedArchiveFile.getTitle(), savedArchiveFile.getFileExtention(), "");
        }

        final GuiWorkflow finalWorkflow = this.saveWorkflow(workflow, session);

        finalList.add(finalWorkflow);
      }
    }

    this.uploadFileManager.deleteFromTemp(UploadFileSavingData.toFileSavingDataList(tempFiles));

    return finalList;
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow");

    if (workflow.getHasActiveAction()) {
      workflow.getActiveAction().setCurrentStepId(workflow.getCurrentStepId());
    }

    final GuiWorkflowSaveRequest request = GuiWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.SAVE);

    final GuiWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public GuiWorkflow assignWorkflow(final Long workflowId)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Assign workflow");

    final GuiWorkflow workflow = this.readWorkflow(workflowId);

    final GuiWorkflowSaveRequest request = GuiWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ASSIGN);
    request.setAssignUser(this.sessionUserInfo.getUser().getId());

    final GuiWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);

  }

  @Override
  public GuiWorkflow doneWorkflow(final GuiWorkflowSaveRequest saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow done");

    saveRequest.setCommand(EWorkflowProcessCommand.DONE);

    final GuiWorkflow result = this.workflowAccess.saveWorkflow(saveRequest, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public GuiWorkflow archiveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {
    logger.debug("Make workflow archive");

    final GuiWorkflowSaveRequest request = GuiWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final GuiWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final Long companyId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read all workflow from company");

    return this.workflowAccess.readWorkflowTypeList(companyId, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Search workflow from company");
    final List<GuiWorkflow> list = this.workflowAccess.searchWorkflow(workflowSearchFilter, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);
  }

  @Override
  public GuiWorkflowFile readWorkflowFile(final Long workflowId, final Long fileId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    GuiWorkflow workflow = null;
    if (this.sessionUserInfo.hasCachedWorkflowId(workflowId)) {
      workflow = this.sessionUserInfo.getCachedWorkflow(workflowId);
    } else {
      workflow = this.readWorkflow(workflowId);
    }

    final GuiWorkflowFile workflowFile = workflow.getFileById(fileId);

    return workflowFile;
  }

  private List<GuiWorkflow> prepareWorkflowList(final List<GuiWorkflow> pureWorkflowList)
      throws IFlowMessageConversionFailureException {

    final List<GuiWorkflow> workflowList = new ArrayList<>();

    if (pureWorkflowList != null) {
      for (final GuiWorkflow workflow : pureWorkflowList) {
        workflowList.add(this.prepareWorkflow(workflow));
      }
    }

    return workflowList;
  }

  private Map<Long, GuiWorkflowTypeStep> getIdMapedSteps(final GuiWorkflowType workflowType) {

    final Map<Long, GuiWorkflowTypeStep> list = workflowType.getSteps().stream().collect(Collectors.toMap(s -> s.getId(), s -> s));

    return list;
  }

  private GuiWorkflowTypeStep findStepByIdInWOrkflowType(final Long stepId, final GuiWorkflowType workflowType) {

    final Map<Long, GuiWorkflowTypeStep> steps = this.getIdMapedSteps(workflowType);

    return steps.containsKey(stepId) ? steps.get(stepId) : null;
  }

  private GuiWorkflow prepareWorkflow(final GuiWorkflow workflow) throws IFlowMessageConversionFailureException {

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeById(workflow.getWorkflowTypeId()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserById(workflow.getCreatedBy()));
    workflow.setControllerUser(this.sessionUserInfo.getUserById(workflow.getController()));
    workflow.setCurrentUserId(this.sessionUserInfo.getUser().getId());
    workflow.setCurrentStep(this.findStepByIdInWOrkflowType(workflow.getCurrentStepId(), workflow.getWorkflowType()));

    for (final GuiWorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.sessionUserInfo.getUserById(action.getAssignTo()));
      action.setCurrentStep(this.findStepByIdInWOrkflowType(action.getCurrentStepId(), workflow.getWorkflowType()));
    }

    this.prepareWorkflowActions(workflow);

    this.sessionUserInfo.addCachedWorkflow(workflow);

    return workflow;
  }

  private GuiWorkflow prepareWorkflowActions(final GuiWorkflow workflow) throws IFlowMessageConversionFailureException {

    for (final GuiWorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.sessionUserInfo.getUserById(action.getAssignTo()));

      action.setCurrentStep(this.findStep(workflow, action.getCurrentStepId()));

      action.setAssignToUserName(
          action.getAssignToUser() == null ? this.messagesHelper.get("common.not-assigned") : action.getAssignToUser().getFullName());

    }

    return workflow;
  }

  private GuiWorkflowTypeStep findStep(final GuiWorkflow workflow, final Long stepId) {
    if (stepId == null) {
      return null;
    }
    GuiWorkflowTypeStep foundStep = null;
    for (final GuiWorkflowTypeStep step : workflow.getWorkflowType().getSteps()) {
      if (step.getId() == stepId) {
        foundStep = step;
        break;
      }
    }
    return foundStep;
  }

}
