package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.WorkflowMessage;

public interface IWorkflowMessageService {

  public List<WorkflowMessage> getWorkflowMessageListByUser(final Long userId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getWorkflowMessageListByWorkflow(final Long workflowId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
