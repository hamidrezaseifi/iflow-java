package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public interface IProfileCachDataDataService {

  public void resetCachDataForUser(final String companyIdentity, final String userIdentity, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForUserList(final String companyIdentity, final Set<String> userIdentityList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForWorkflow(final String companyIdentity, final String workflowIdentity, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
