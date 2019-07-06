package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;

public interface IDepartmentService {

  Department save(Department model);

  Department getById(final Long id);

  List<Department> getListByIdList(final List<Long> idList);

  List<Department> getListByIdCompanyId(final Long id);

  List<DepartmentGroup> getDepartmentGroups(final Long id);
}
