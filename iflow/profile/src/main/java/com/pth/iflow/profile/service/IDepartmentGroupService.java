package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;

public interface IDepartmentGroupService {

  DepartmentGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getAllUserListByDepartmentGroupId(final Long id) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
