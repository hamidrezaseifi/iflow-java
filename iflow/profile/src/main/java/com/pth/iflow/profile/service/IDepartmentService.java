package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;

public interface IDepartmentService {

  Department getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<Department> getListByCompanyId(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<User> getAllUserListByDepartmentId(final Long id) throws ProfileCustomizedException, MalformedURLException;
}