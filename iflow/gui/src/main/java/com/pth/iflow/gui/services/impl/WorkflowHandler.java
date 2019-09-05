package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowAction;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiWorkflowTypeStep;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowHandler.class);

  private final IWorkflowAccess workflowAccess;

  private final GuiSessionUserInfo sessionUserInfo;

  private final IUploadFileManager uploadFileManager;

  public WorkflowHandler(@Autowired final IWorkflowAccess workflowAccess,
                         @Autowired final GuiSessionUserInfo sessionUserInfo,
                         @Autowired final IUploadFileManager uploadFileManager) {
    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
    this.uploadFileManager = uploadFileManager;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException {

    logger.debug("Read workflow {}", workflowId);

    final GuiWorkflow wirkflow = this.workflowAccess.readWorkflow(workflowId, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(wirkflow);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest, final HttpSession session)
                                                                                                                   throws GuiCustomizedException,
                                                                                                                   MalformedURLException {
    logger.debug("Create workflow {}", createRequest.getWorkflow().getTitle());

    final Object oFileList = session.getAttribute(createRequest.getSessionKey());
    if ((oFileList == null) || ((oFileList instanceof List) == false)) {
      final GuiCustomizedException uiCustomizedException = new GuiCustomizedException("Uploaded files not found!",
                                                                                      "",
                                                                                      EModule.GUI.getModuleName());

      throw uiCustomizedException;
    }

    final List<UploadFileSavingData> tempFiles = (List<UploadFileSavingData>) oFileList;
    for (final UploadFileSavingData tempFile : tempFiles) {
      final GuiWorkflowFile wfile = new GuiWorkflowFile();
      wfile.setActiveFilePath(filePath);
      wfile.setActiveFileVersion(1);
      wfile.setComments("");
      wfile.setCreatedBy(createdBy);
      wfile.setFileVersions(fileVersions);
      wfile.setStatus(1);
      wfile.setTitle(tempFile.getTitle());

      createRequest.getWorkflow().addFile(wfile);
    }

    this.uploadFileManager.moveFromTempToArchive(tempFiles);

    createRequest.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE_REQUEST);

    final List<GuiWorkflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflow workflow, final HttpSession session) throws GuiCustomizedException,
                                                                                         MalformedURLException {
    logger.debug("Save workflow {}", workflow.getTitle());

    workflow.getActiveAction().setStatus(EWorkflowActionStatus.SAVING_REQUEST);
    workflow.getActiveAction().setNewStep(workflow.getCurrentStepId());

    return this.workflowAccess.saveWorkflow(workflow, this.sessionUserInfo.getToken());
  }

  @Override
  public GuiWorkflow doneWorkflow(final GuiWorkflow workflow, final HttpSession session) throws GuiCustomizedException,
                                                                                         MalformedURLException {
    logger.debug("Make workflow {} done", workflow.getTitle());

    workflow.getActiveAction().setStatus(EWorkflowActionStatus.DONE_REQUEST);
    workflow.getActiveAction().setNewStep(workflow.getCurrentStepId());
    return this.workflowAccess.saveWorkflow(workflow, this.sessionUserInfo.getToken());
  }

  @Override
  public GuiWorkflow archiveWorkflow(final GuiWorkflow workflow, final HttpSession session) throws GuiCustomizedException,
                                                                                            MalformedURLException {
    logger.debug("Make workflow {} archive", workflow.getTitle());

    workflow.setStatus(EWorkflowStatus.ARCHIVED);
    return this.workflowAccess.saveWorkflow(workflow, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final Long companyId) throws GuiCustomizedException, MalformedURLException {
    logger.debug("Read all workflow from company");

    return this.workflowAccess.readWorkflowTypeList(companyId, this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter)
                                                                                              throws GuiCustomizedException,
                                                                                              MalformedURLException {

    logger.debug("Search workflow from company");
    final List<GuiWorkflow> list = this.workflowAccess.searchWorkflow(workflowSearchFilter, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);
  }

  private List<GuiWorkflow> prepareWorkflowList(final List<GuiWorkflow> pureWorkflowList) {

    final List<GuiWorkflow> workflowList = new ArrayList<>();

    if (pureWorkflowList != null) {
      for (final GuiWorkflow workflow : pureWorkflowList) {
        workflowList.add(this.prepareWorkflow(workflow));
      }
    }

    return workflowList;
  }

  private GuiWorkflow prepareWorkflow(final GuiWorkflow workflow) {

    workflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeById(workflow.getWorkflowTypeId()));
    workflow.setAssignToUser(this.sessionUserInfo.getUserById(workflow.getAssignTo()));
    workflow.setCreatedByUser(this.sessionUserInfo.getUserById(workflow.getCreatedBy()));
    workflow.setControllerUser(this.sessionUserInfo.getUserById(workflow.getController()));

    this.prepareWorkflowActions(workflow);

    return workflow;
  }

  private GuiWorkflow prepareWorkflowActions(final GuiWorkflow workflow) {

    if (workflow.getIsOpen()) {

      if (!workflow.getHasActiveAction()) {
        final GuiWorkflowAction action = GuiWorkflowAction.createNewAction(workflow,
                                                                           this.sessionUserInfo.getUser().getId(),
                                                                           EWorkflowActionStatus.OPEN);
        action.setStatus(EWorkflowActionStatus.OPEN);
        workflow.addAction(action);
      }
    }

    for (final GuiWorkflowAction action : workflow.getActions()) {
      action.setCreatedByUser(this.sessionUserInfo.getUserById(action.getCreatedBy()));

      action.setOldStepObject(findStep(workflow, action.getOldStep()));
      action.setNewStepObject(findStep(workflow, action.getNewStep()));

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
