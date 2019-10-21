package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public interface IDepartmentService {

  ICoreIdentityModel save(Department model);

  Department getByIdentity(final String identity);

  List<Department> getListByIdentityList(final Collection<String> idList);

  List<Department> getListByIdCompanyIdentity(final String identity);

  List<DepartmentGroup> getDepartmentGroups(final String identity);

  List<User> getAllUserListByDepartmentIdentity(final String identity);

}
