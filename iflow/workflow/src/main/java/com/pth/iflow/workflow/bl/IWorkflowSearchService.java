package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.workflow.Workflow;

public interface IWorkflowSearchService {

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<Workflow> readWorkflowListByIdentityList(final Set<String> identityList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
