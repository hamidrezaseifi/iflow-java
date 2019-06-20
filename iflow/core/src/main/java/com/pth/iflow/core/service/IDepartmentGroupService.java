package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.DepartmentGroup;

public interface IDepartmentGroupService {
  
  public DepartmentGroup getById(final Long id);
  
  public List<DepartmentGroup> getListByDepartmentId(final Long departmentId);
  
  public List<DepartmentGroup> getListByIdList(final List<Long> idList);
  
}
