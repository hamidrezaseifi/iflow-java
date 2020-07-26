package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;

public interface IDepartmentDataService {

  public List<User> getUserListByDepartmentIdentity(String departmentIdentity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
