package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public interface IDepartmentService {

  ICoreIdentityModel save(Department model);

  Department getByIdentity(final String identity);

  List<Department> getListByIdentityList(final Set<String> idList);

  List<Department> getListByIdCompanyId(final String identity);

  List<DepartmentGroup> getDepartmentGroups(final String identity);

  List<User> getAllUserListByDepartmentId(final String identity);

}
