package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;

public interface IDepartmentGroupService {

  DepartmentGroup save(DepartmentGroup model);

  DepartmentGroup getByIdentity(final String identity);

  List<DepartmentGroup> getListByDepartmentIdentity(final String departmentIdentity);

  List<DepartmentGroup> getListByIdentityList(final Collection<String> idList);

  List<User> getAllUserListByDepartmentGroupId(final String identity);

}
