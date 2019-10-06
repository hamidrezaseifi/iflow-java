package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;

public interface IDepartmentDataService {

  public List<User> getUserListByDepartmentId(final Long departmentId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<User> getUserListByDepartmentGroupId(final Long departmentGroupId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
