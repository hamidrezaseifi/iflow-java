package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentGroupDao {

  public DepartmentGroup create(DepartmentGroup model) throws IFlowStorageException;

  public DepartmentGroup update(DepartmentGroup model) throws IFlowStorageException;

  public DepartmentGroup getById(Long id) throws IFlowStorageException;

  public List<DepartmentGroup> getListByDepartmentId(final Long departmentId);

  public List<DepartmentGroup> getListByIdList(List<Long> idList) throws IFlowStorageException;

  List<Long> getAllUserIdListByDepartmentGroupId(final Long id) throws IFlowStorageException;

}
