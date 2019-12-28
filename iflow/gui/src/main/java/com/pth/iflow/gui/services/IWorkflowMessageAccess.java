package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;

public interface IWorkflowMessageAccess {

  public List<WorkflowMessage> readUserMessages(final String companyIdentity, final String userId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getWorkflowMessageListByUser(final String userIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getWorkflowMessageListByWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
