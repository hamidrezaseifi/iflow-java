package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentDao {

  public Department create(Department model) throws IFlowStorageException;

  public Department update(Department model) throws IFlowStorageException;

  public Department getById(Long id) throws IFlowStorageException;

  public Department getByIdentity(String identity) throws IFlowStorageException;

  public Set<Department> getListByCompanyId(Long id) throws IFlowStorageException;

  public Set<Department> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public Set<Department> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public Set<String> getAllUserIdentityListByDepartmentId(final Long id) throws IFlowStorageException;

}
