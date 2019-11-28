package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;

public interface IUsersService {

  User save(User model);

  User getUserByEmail(final String email);

  ProfileResponse getProfileResponseByEmail(final String email);

  List<UserGroup> getUserGroups(final String identity);

  List<Department> getUserDepartments(final String identity);

  List<DepartmentGroupEntity> getUserDepartmentGroups(final String identity);

  List<User> getUserDeputies(final String identity);

  List<User> getCompanyUsers(final String companyIdentity);

}
