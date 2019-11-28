package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;

public interface IDepartmentGroupService {

  DepartmentGroupEntity save(DepartmentGroupEntity model);

  DepartmentGroupEntity getByIdentity(final String identity);

  List<DepartmentGroupEntity> getListByDepartmentIdentity(final String departmentIdentity);

  List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList);

  List<User> getAllUserListByDepartmentGroupId(final String identity);

}
