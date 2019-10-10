package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public interface IDepartmentService {

  ICoreIdentityModel save(Department model);

  Department getById(final Long id);

  List<Department> getListByIdList(final Set<Long> idList);

  List<Department> getListByIdentityList(final Set<String> idList);

  List<Department> getListByIdCompanyId(final Long id);

  List<DepartmentGroup> getDepartmentGroups(final Long id);

  List<User> getAllUserListByDepartmentId(final Long id);

}
