package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;

public interface IDepartmentService {

  Department getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<Department> getListByCompanyId(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<User> getAllUserListByDepartmentId(final Long id) throws ProfileCustomizedException, MalformedURLException;
}
