package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.Set;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public interface IGuiCachDataDataService {

  public void resetCachDataForUser(String companyIdentity, String userIdentity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForUserList(String companyIdentity, Set<String> userIdentityList, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForWorkflow(String companyIdentity, String workflowIdentity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
