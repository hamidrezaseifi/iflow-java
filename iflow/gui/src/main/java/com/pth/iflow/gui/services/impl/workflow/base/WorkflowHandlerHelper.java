package com.pth.iflow.gui.services.impl.workflow.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;

public abstract class WorkflowHandlerHelper<W extends IWorkflow> {

  private static final boolean MANAGE_UPLOADFILES_IS_DISABLED = true;

  protected List<W> prepareUploadedFiles(final IWorkflowSaveRequest<W> createRequest, final HttpSession session, final List<W> workflowList)
      throws IOException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<W> preparedList = this.prepareWorkflowList(workflowList);

    if (StringUtils.isEmpty(createRequest.getSessionKey()) || MANAGE_UPLOADFILES_IS_DISABLED) {
      return preparedList;
    }

    final Object oFileList = session.getAttribute(createRequest.getSessionKey());
    if ((oFileList == null) || ((oFileList instanceof List) == false)) {
      throw new GuiCustomizedException("Uploaded files not found!");

    }

    final List<UploadFileSavingData> tempFiles = (List<UploadFileSavingData>) oFileList;

    final List<W>                    finalList = new ArrayList<>();
    if (preparedList != null && tempFiles.isEmpty() == false) {
      for (final W workflow : preparedList) {
        final List<FileSavingData> archiveSavingFileInfoList = new ArrayList<>();
        for (final UploadFileSavingData tempFile : tempFiles) {

          final FileSavingData archiveSavingFileInfo = tempFile.toFileSavingData();
          archiveSavingFileInfo.setWorkflowIdentity(workflow.getIdentity());

          // archiveSavingFileInfo.setActionIdentity(workflow.getHasActiveAction() ? workflow.getActiveAction().getIdentity() : "no-action");

          archiveSavingFileInfo.setFilePath(archiveSavingFileInfo.generateSavingFilePathPreffix());
          archiveSavingFileInfo.setTempFilePath(tempFile.getFilePath());

          archiveSavingFileInfoList.add(archiveSavingFileInfo);
        }
        final List<FileSavingData> savedArchiveFiles = this.getUploadFileManager().copyFromTempToArchive(archiveSavingFileInfoList);
        for (final FileSavingData savedArchiveFile : savedArchiveFiles) {

          workflow.addNewFile(savedArchiveFile.generateSavingFilePathPreffix(), this.getSessionUserInfo().getUser().getIdentity(),
              savedArchiveFile.getTitle(), savedArchiveFile.getFileExtention(), "");
        }

        final W finalWorkflow = this.innerSaveWorkflow(workflow, session);

        finalList.add(finalWorkflow);
      }
    }

    this.getUploadFileManager().deleteFromTemp(UploadFileSavingData.toFileSavingDataList(tempFiles));

    return finalList;
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

  protected abstract W innerSaveWorkflow(final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

}
