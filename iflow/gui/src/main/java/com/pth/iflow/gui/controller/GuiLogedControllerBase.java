package com.pth.iflow.gui.controller;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Component
public class GuiLogedControllerBase {

  @Autowired
  private SessionUserInfo sessionUserInfo;

  @Autowired
  private IWorkflowMessageHanlder workflowMessageHanlder;

  protected String getCurrentRelativeUrl() {

    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  protected SessionUserInfo getSessionUserInfo() {

    return this.sessionUserInfo;
  }

  protected User getLoggedUser() {

    return this.sessionUserInfo.getUser();
  }

  protected Company getLoggedCompany() {

    return this.sessionUserInfo.getCompanyProfile().getCompany();
  }

  protected WorkflowTypeStep getWorkflowStepTypeByIdentity(final String workflowTypIdentity, final String workflowTypStepIdentity)
      throws IFlowMessageConversionFailureException {

    return this.sessionUserInfo.getWorkflowStepTypeByIdentity(workflowTypIdentity, workflowTypStepIdentity);
  }

  protected Collection<WorkflowType> getAllWorkflowTypes() throws IFlowMessageConversionFailureException {

    return this.sessionUserInfo.getAllWorkflowTypes();
  }

  protected WorkflowType getWorkflowTypeByEnumType(final EWorkflowType type) {

    try {
      return this.sessionUserInfo.getWorkflowTypeByEnumType(type);
    }
    catch (final IFlowMessageConversionFailureException e) {

    }
    return null;
  }

  protected WorkflowType getWorkflowTypeByIdentity(final String workflowTypIdentity) {

    try {
      return this.sessionUserInfo.getWorkflowTypeByIdentity(workflowTypIdentity);
    }
    catch (final IFlowMessageConversionFailureException e) {

    }
    return null;
  }

  protected String getLoggedToken() {

    return this.sessionUserInfo.getToken();
  }

  protected String getLoggedSessionId() {

    return this.sessionUserInfo.getSessionId();
  }

  public IWorkflowMessageHanlder getWorkflowMessageHanlder() {

    return this.workflowMessageHanlder;
  }

  public List<WorkflowMessage> readUserMessages()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.workflowMessageHanlder.readUserMessages();
  }

  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    this.workflowMessageHanlder.callUserMessageReset(false);
  }

  protected String getWorkflowBaseUrl(final String workflowTypeIdentity) throws IFlowMessageConversionFailureException {

    final WorkflowType type = this.getWorkflowTypeByIdentity(workflowTypeIdentity);

    String url = "";
    if (type.getTypeEnum() == EWorkflowType.INVOICE_WORKFLOW_TYPE) {
      url = GuiModule.INVOICEWORKFLOW_PAGE_BASE;
    }
    if (type.getTypeEnum() == EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE) {
      url = GuiModule.SINGLETASKWORKFLOW_PAGE_BASE;
    }
    if (type.getTypeEnum() == EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE) {
      url = GuiModule.TESTTHREETASKWORKFLOW_PAGE_BASE;
    }
    return url;
  }

}
