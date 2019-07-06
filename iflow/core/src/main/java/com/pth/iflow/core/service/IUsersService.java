package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;

public interface IUsersService {

  User save(User model);

  User getUserById(final Long id);

  User getUserByEmail(final String email);

  List<UserGroup> getUserGroups(final Long id);

  List<Department> getUserDepartments(final Long id);

  List<DepartmentGroup> getUserDepartmentGroups(final Long id);

  List<User> getUserDeputies(final Long id);

}
