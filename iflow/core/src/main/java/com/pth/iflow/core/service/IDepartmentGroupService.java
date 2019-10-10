package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;

public interface IDepartmentGroupService {

  DepartmentGroup save(DepartmentGroup model);

  DepartmentGroup getById(final Long id);

  List<DepartmentGroup> getListByDepartmentId(final Long departmentId);

  List<DepartmentGroup> getListByIdList(final Set<Long> idList);

  List<DepartmentGroup> getListByIdentityList(final Set<String> idList);

  List<User> getAllUserListByDepartmentGroupId(final Long id);

}
