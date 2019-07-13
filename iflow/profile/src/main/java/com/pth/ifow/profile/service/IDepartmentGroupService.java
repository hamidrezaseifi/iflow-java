package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;

public interface IDepartmentGroupService {

  DepartmentGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<User> getAllUserListByDepartmentGroupId(final Long id) throws ProfileCustomizedException, MalformedURLException;
}
