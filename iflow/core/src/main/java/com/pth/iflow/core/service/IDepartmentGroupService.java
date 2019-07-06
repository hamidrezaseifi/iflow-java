package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.DepartmentGroup;

public interface IDepartmentGroupService {

  DepartmentGroup save(DepartmentGroup model);

  DepartmentGroup getById(final Long id);

  List<DepartmentGroup> getListByDepartmentId(final Long departmentId);

  List<DepartmentGroup> getListByIdList(final List<Long> idList);

}
