package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentGroupDao {

  public DepartmentGroup create(DepartmentGroup model) throws IFlowStorageException;

  public DepartmentGroup update(DepartmentGroup model) throws IFlowStorageException;

  public DepartmentGroup getById(Long id) throws IFlowStorageException;

  public DepartmentGroup getByIdentity(String identity) throws IFlowStorageException;

  public Set<DepartmentGroup> getListByDepartmentId(final Long departmentId);

  public Set<DepartmentGroup> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public Set<DepartmentGroup> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public Set<String> getAllUserIdentityListByDepartmentGroupId(final Long id) throws IFlowStorageException;

}
