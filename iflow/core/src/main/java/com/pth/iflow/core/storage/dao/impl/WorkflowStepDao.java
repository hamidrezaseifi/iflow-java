package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.WorkflowStep;
import com.pth.iflow.core.storage.dao.IWorkflowStepDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class WorkflowStepDao implements IWorkflowStepDao {

  @Override
  public WorkflowStep getById(final Long id) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<WorkflowStep> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

}
