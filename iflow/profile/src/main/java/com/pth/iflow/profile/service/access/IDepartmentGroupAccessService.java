package com.pth.iflow.profile.service.access;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;

public interface IDepartmentGroupAccessService {

  DepartmentGroup getByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getAllUserListByDepartmentGroupId(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  User getDepartmentGroupManager(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  User getDepartmentGroupDeputy(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
