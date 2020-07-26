package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public interface IWorkflowTypeDataService {

  public WorkflowType getByIdentity(String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowType> getListByCompanyIdentity(final String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowTypeStep> getStepsByIdentity(final String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowType> getListByIdentityList(final Set<String> identityList, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
