package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentGroupDao {
  
  public DepartmentGroup getById(Long id) throws IFlowStorageException;

  public List<DepartmentGroup> getListByDepartmentId(final Long departmentId);
  
  public List<DepartmentGroup> getListByIdList(List<Long> idList) throws IFlowStorageException;
  
}
