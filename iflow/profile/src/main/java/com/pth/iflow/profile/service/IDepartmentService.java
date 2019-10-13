package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;

public interface IDepartmentService {

  Department getById(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<Department> getListByCompanyId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getAllUserListByDepartmentId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
