package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentDao {

  public Department create(Department model) throws IFlowStorageException;

  public Department update(Department model) throws IFlowStorageException;

  public Department getById(Long id) throws IFlowStorageException;

  public List<Department> getListByCompanyId(Long id) throws IFlowStorageException;

  public List<Department> getListByIdList(List<Long> idList) throws IFlowStorageException;

  public List<Long> getAllUserIdListByDepartmentId(final Long id) throws IFlowStorageException;

}
