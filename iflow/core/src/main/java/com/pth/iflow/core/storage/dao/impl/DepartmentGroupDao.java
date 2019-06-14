package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class DepartmentGroupDao implements IDepartmentGroupDao {

  @Override
  public DepartmentGroup getById(final Long id) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<DepartmentGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

}
