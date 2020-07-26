package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowMessage;

public interface IWorkflowMessageDataService {

  public List<WorkflowMessage> getListForUser(final String userIdentity, int status, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> getListForWorkflow(final String workflowIdentity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public WorkflowMessage save(final WorkflowMessage message, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status,
      Authentication authentication) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void updateUserAndWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String userIdentity,
      final EWorkflowMessageStatus status, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
