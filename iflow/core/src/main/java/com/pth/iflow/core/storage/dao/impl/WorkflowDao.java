package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class WorkflowDao implements IWorkflowDao {

  @Override
  public Workflow getById(final Long id) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

}
