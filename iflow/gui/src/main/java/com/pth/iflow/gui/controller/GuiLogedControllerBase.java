package com.pth.iflow.gui.controller;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
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

  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response, final HttpServletRequest request) throws Exception {

    if (this.sessionUserInfo == null || !this.sessionUserInfo.isValid()) {
      response.sendRedirect(GuiSecurityConfigurations.LOGIN_URL);

    }

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

  protected WorkflowTypeStep getWorkflowStepTypeByIdentity(final String workflowTypIdentity, final String workflowTypStepIdentity) throws IFlowMessageConversionFailureException {

    return this.sessionUserInfo.getWorkflowStepTypeByIdentity(workflowTypIdentity, workflowTypStepIdentity);
  }

  protected Collection<WorkflowType> getAllWorkflowTypes() throws IFlowMessageConversionFailureException {

    return this.sessionUserInfo.getAllWorkflowTypes();
  }

  protected WorkflowType getWorkflowTypeByIdentity(final String workflowTypIdentity) throws IFlowMessageConversionFailureException {

    return this.sessionUserInfo.getWorkflowTypeByIdentity(workflowTypIdentity);
  }

  protected String getLoggedToken() {

    return this.sessionUserInfo.getToken();
  }

  protected String getLoggedSessionId() {

    return this.sessionUserInfo.getSessionId();
  }

  public IWorkflowMessageHanlder getWorkflowMessageHanlder() {
    return workflowMessageHanlder;
  }

  public List<WorkflowMessage> readUserMessages() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    return workflowMessageHanlder.readUserMessages();
  }

  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    workflowMessageHanlder.callUserMessageReset();
  }

}
