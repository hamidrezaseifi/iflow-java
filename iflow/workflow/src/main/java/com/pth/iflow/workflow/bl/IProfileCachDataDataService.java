package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public interface IProfileCachDataDataService {

  public void resetCachDataForUser(final Long companyId, final Long userId, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForUserList(final Long companyId, final Set<Long> userIdList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetCachDataForWorkflow(final Long companyId, final Long workflowId, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
