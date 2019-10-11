package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeStepDataService {

  public WorkflowTypeStep getByIdentity(String identity, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowTypeStep> getListByWorkflowIdentity(final String workflowIdentity, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowTypeStep> getListByIdentityList(final List<String> identityList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
