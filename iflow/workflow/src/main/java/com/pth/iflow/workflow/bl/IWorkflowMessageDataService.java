package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowMessage;

public interface IWorkflowMessageDataService {

  public List<WorkflowMessage> getListForUser(final Long userId, int status, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public WorkflowMessage save(final WorkflowMessage message, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}