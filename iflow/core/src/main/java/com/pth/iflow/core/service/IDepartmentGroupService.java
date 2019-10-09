package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;

public interface IDepartmentGroupService {

  DepartmentGroup save(DepartmentGroup model);

  DepartmentGroup getById(final Long id);

  Set<DepartmentGroup> getListByDepartmentId(final Long departmentId);

  Set<DepartmentGroup> getListByIdList(final Set<Long> idList);

  Set<DepartmentGroup> getListByIdentityList(final Set<String> idList);

  Set<User> getAllUserListByDepartmentGroupId(final Long id);

}
