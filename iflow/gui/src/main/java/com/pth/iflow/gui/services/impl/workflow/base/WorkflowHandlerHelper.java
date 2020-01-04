package com.pth.iflow.gui.services.impl.workflow.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;

public abstract class WorkflowHandlerHelper<W extends IWorkflow> {

  // private static final boolean MANAGE_UPLOADFILES_IS_DISABLED = false;

  protected void prepareUploadedFiles(final IWorkflowSaveRequest<W> createRequest)
      throws IOException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<FileSavingData> archiveList = this.getUploadFileManager().moveFromTempToArchive(createRequest.getUploadedFiles());

    for (final FileSavingData savedArchiveFile : archiveList) {

      createRequest
          .getWorkflow()
          .addNewFile(savedArchiveFile.getFilePath(), this.getSessionUserInfo().getUser().getIdentity(),
              savedArchiveFile.getTitle(), savedArchiveFile.getFileExtention(), "");
    }

  }

  protected List<W> prepareWorkflowList(final List<W> pureWorkflowList) throws IFlowMessageConversionFailureException {

    final List<W> workflowList = new ArrayList<>();

    if (pureWorkflowList != null) {
      for (final W workflow : pureWorkflowList) {
        workflowList.add(this.prepareWorkflow(workflow));
      }
    }

    return workflowList;
  }

  protected Map<String, WorkflowTypeStep> getIdMapedSteps(final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> list = workflowType.getSteps().stream().collect(Collectors.toMap(s -> s.getIdentity(), s -> s));

    return list;
  }

  protected WorkflowTypeStep findStepByIdInWorkflowType(final String stepId, final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> steps = this.getIdMapedSteps(workflowType);

    if (steps.containsKey(stepId)) {
      return steps.get(stepId);
    }
    else {
      return null;
    }
  }

  protected W prepareWorkflow(final W workflow) throws IFlowMessageConversionFailureException {

    workflow.setWorkflowType(this.getSessionUserInfo().getWorkflowTypeByIdentity(workflow.getWorkflowTypeIdentity()));
    workflow.setCreatedByUser(this.getSessionUserInfo().getUserByIdentity(workflow.getCreatedByIdentity()));
    workflow.setControllerUser(this.getSessionUserInfo().getUserByIdentity(workflow.getControllerIdentity()));
    workflow.setCurrentUserIdentity(this.getSessionUserInfo().getUser().getIdentity());
    workflow.setCurrentStep(this.findStepByIdInWorkflowType(workflow.getCurrentStepIdentity(), workflow.getWorkflowType()));

    this.prepareWorkflowActions(workflow);

    this.getSessionUserInfo().addCachedWorkflow(workflow);

    return workflow;
  }

  protected W prepareWorkflowActions(final W workflow) throws IFlowMessageConversionFailureException {

    for (final WorkflowAction action : workflow.getActions()) {
      action.setAssignToUser(this.getSessionUserInfo().getUserByIdentity(action.getAssignToIdentity()));
      action.setCurrentStep(this.findStepByIdInWorkflowType(action.getCurrentStepIdentity(), workflow.getWorkflowType()));
    }

    return workflow;
  }

  protected abstract SessionUserInfo getSessionUserInfo();

  protected abstract IUploadFileManager getUploadFileManager();

  protected abstract W innerSaveWorkflow(final W workflow)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

}
