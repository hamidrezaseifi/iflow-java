package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeStepProcessService {

  public WorkflowTypeStep getByIdentity(String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowTypeStep> getListByWorkflowIdentity(final String workflowIdentity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowTypeStep> getListByIdentityList(final Set<String> identityList, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
