package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowStepService;
import com.pth.iflow.core.storage.dao.IWorkflowStepDao;

@Service
public class WorkflowStepService implements IWorkflowStepService {
  
  private final IWorkflowStepDao workflowStepDao;
  
  WorkflowStepService(@Autowired final IWorkflowStepDao workflowStepDao) {
    this.workflowStepDao = workflowStepDao;
  }

  @Override
  public WorkflowTypeStep getById(final Long id) {
    
    return this.workflowStepDao.getById(id);
  }
  
  @Override
  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId) {
    
    return this.workflowStepDao.getListByWorkflowId(workflowId);
  }
  
  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList) {

    return this.workflowStepDao.getListByIdList(idList);
  }
  
}
