package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;

public interface IWorkflowMessageAccess {

  public List<WorkflowMessage> readUserMessages(final String companyIdentity, final String userIdentity,
      final Authentication authentication)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getWorkflowMessageListByUser(final String userIdentity, final Authentication authentication)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getWorkflowMessageListByWorkflow(final String workflowIdentity, final Authentication authentication)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
