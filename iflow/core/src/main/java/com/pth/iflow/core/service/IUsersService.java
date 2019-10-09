package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;

public interface IUsersService {

  User save(User model);

  User getUserById(final Long id);

  User getUserByEmail(final String email);

  Set<UserGroup> getUserGroups(final Long id);

  Set<Department> getUserDepartments(final Long id);

  Set<DepartmentGroup> getUserDepartmentGroups(final Long id);

  Set<User> getUserDeputies(final Long id);

  Set<User> getCompanyUsers(final Long companyId);

}
