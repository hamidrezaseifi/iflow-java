package com.pth.iflow.gui.services.impl.workflow.invoice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.helper.IdentityModel;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.base.WorkflowHandlerHelper;

@Service
public class InvoiceWorkflowHandler extends WorkflowHandlerHelper<InvoiceWorkflow> implements IWorkflowHandler<InvoiceWorkflow,
    InvoiceWorkflowSaveRequest> {

  private static final Logger logger = LoggerFactory.getLogger(InvoiceWorkflowHandler.class);

  private final IWorkflowAccess<InvoiceWorkflow, InvoiceWorkflowSaveRequest> workflowAccess;

  private final SessionUserInfo sessionUserInfo;

  private final IUploadFileManager uploadFileManager;

  public InvoiceWorkflowHandler(@Autowired final IWorkflowAccess<InvoiceWorkflow, InvoiceWorkflowSaveRequest> workflowAccess,
      @Autowired final SessionUserInfo sessionUserInfo, @Autowired final IUploadFileManager uploadFileManager) {

    this.workflowAccess = workflowAccess;
    this.sessionUserInfo = sessionUserInfo;
    this.uploadFileManager = uploadFileManager;

  }

  @Override
  public InvoiceWorkflow readWorkflow(final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read workflow {}", workflowIdentity);

    final InvoiceWorkflow wirkflow = this.workflowAccess.readWorkflow(workflowIdentity, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(wirkflow);
  }

  @Override
  public List<InvoiceWorkflow> createWorkflow(final InvoiceWorkflowSaveRequest createRequest)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    logger.debug("Create workflow");

    createRequest.setCommand(EWorkflowProcessCommand.CREATE);
    if (IdentityModel.isIdentityNew(createRequest.getWorkflow().getCurrentStepIdentity())) {

    }

    createRequest.getWorkflow().setComments(createRequest.getComments());
    if (createRequest.getWorkflow().getHasActiveAction()) {
      createRequest.getWorkflow().getActiveAction().setComments(createRequest.getComments());
    }

    this.workflowAccess.validateWorkflow(createRequest, this.sessionUserInfo.getToken());

    this.prepareUploadedFiles(createRequest);

    final List<InvoiceWorkflow> list = this.workflowAccess.createWorkflow(createRequest, this.sessionUserInfo.getToken());

    return this.prepareWorkflowList(list);

    // return this.prepareUploadedFiles(createRequest, list);
  }

  @Override
  public InvoiceWorkflow saveWorkflow(final InvoiceWorkflowSaveRequest saveRequest)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    logger.debug("Save workflow");

    if (saveRequest.getWorkflow().getHasActiveAction()) {
      saveRequest.getWorkflow().getActiveAction().setCurrentStepIdentity(saveRequest.getWorkflow().getCurrentStepIdentity());
    }

    saveRequest.setCommand(EWorkflowProcessCommand.SAVE);
    if (saveRequest.getWorkflow().getHasActiveAction()) {
      saveRequest.getWorkflow().getActiveAction().setComments(saveRequest.getComments());
    }

    this.workflowAccess.validateWorkflow(saveRequest, this.sessionUserInfo.getToken());

    this.prepareUploadedFiles(saveRequest);

    final InvoiceWorkflow result = this.workflowAccess.saveWorkflow(saveRequest, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public InvoiceWorkflow assignWorkflow(final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    logger.debug("Assign workflow");

    final InvoiceWorkflow workflow = this.readWorkflow(workflowIdentity);

    final InvoiceWorkflowSaveRequest request = InvoiceWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ASSIGN);
    request.setAssignUser(this.sessionUserInfo.getUser().getIdentity());

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final InvoiceWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);

  }

  @Override
  public InvoiceWorkflow doneWorkflow(final InvoiceWorkflowSaveRequest saveRequest)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    logger.debug("Make workflow done");

    saveRequest.setCommand(EWorkflowProcessCommand.DONE);
    if (saveRequest.getWorkflow().getHasActiveAction()) {
      saveRequest.getWorkflow().getActiveAction().setComments(saveRequest.getComments());
    }

    this.workflowAccess.validateWorkflow(saveRequest, this.sessionUserInfo.getToken());

    this.prepareUploadedFiles(saveRequest);

    final InvoiceWorkflow result = this.workflowAccess.saveWorkflow(saveRequest, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public InvoiceWorkflow archiveWorkflow(final InvoiceWorkflow workflow)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    logger.debug("Make workflow archive");

    final InvoiceWorkflowSaveRequest request = InvoiceWorkflowSaveRequest.generateNewNoExpireDays(workflow);
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    this.workflowAccess.validateWorkflow(request, this.sessionUserInfo.getToken());

    final InvoiceWorkflow result = this.workflowAccess.saveWorkflow(request, this.sessionUserInfo.getToken());
    return this.prepareWorkflow(result);
  }

  @Override
  public WorkflowFile readWorkflowFile(final String workflowIdentity, final String fileIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    InvoiceWorkflow workflow = null;
    if (this.sessionUserInfo.hasCachedWorkflowIdentity(workflowIdentity)) {
      workflow = (InvoiceWorkflow) this.sessionUserInfo.getCachedWorkflow(workflowIdentity);
    }
    else {
      workflow = this.readWorkflow(workflowIdentity);
    }

    final WorkflowFile workflowFile = workflow.getFileByIdentity(fileIdentity);

    return workflowFile;
  }

  @Override
  protected SessionUserInfo getSessionUserInfo() {

    return this.sessionUserInfo;
  }

  @Override
  protected IUploadFileManager getUploadFileManager() {

    return this.uploadFileManager;
  }

}
