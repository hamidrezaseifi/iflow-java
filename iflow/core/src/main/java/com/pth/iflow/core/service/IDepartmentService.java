package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public interface IDepartmentService {

  ICoreIdentityModel save(Department model);

  Department getById(final Long id);

  Set<Department> getListByIdList(final Set<Long> idList);

  Set<Department> getListByIdentityList(final Set<String> idList);

  Set<Department> getListByIdCompanyId(final Long id);

  Set<DepartmentGroup> getDepartmentGroups(final Long id);

  Set<User> getAllUserListByDepartmentId(final Long id);

}
