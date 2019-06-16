package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;

public interface IDepartmentService {

  public Department getById(final Long id);

  public List<Department> getListByIdList(final List<Long> idList);

  public List<Department> getListByIdCompanyId(final Long id);

  public List<DepartmentGroup> getDepartmentGroups(final Long id);
}
