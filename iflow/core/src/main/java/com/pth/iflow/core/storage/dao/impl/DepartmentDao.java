package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class DepartmentDao implements IDepartmentDao {

  @Override
  public Department getById(final Long id) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Department> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

}
