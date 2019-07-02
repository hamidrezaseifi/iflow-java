package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@Service
public class WorkflowTypeStepService implements IWorkflowTypeStepService {

  private final IWorkflowTypeStepDao workflowStepDao;

  public WorkflowTypeStepService(@Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.workflowStepDao = workflowStepDao;
  }
  
  @Override
  public WorkflowTypeStep getById(final Long id) {

    return this.workflowStepDao.getById(id);
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId) {

    return this.workflowStepDao.getListByWorkflowTypeId(workflowId);
  }

  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList) {
    
    return this.workflowStepDao.getListByIdList(idList);
  }

}
