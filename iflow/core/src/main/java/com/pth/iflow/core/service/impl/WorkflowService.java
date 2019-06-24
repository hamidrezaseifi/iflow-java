package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowStep;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowStepDao;

@Service
public class WorkflowService implements IWorkflowService {
  
  private final IWorkflowDao     workflowDao;
  private final IWorkflowStepDao workflowStepDao;
  
  WorkflowService(@Autowired final IWorkflowDao workflowDao, @Autowired final IWorkflowStepDao workflowStepDao) {
    this.workflowDao = workflowDao;
    this.workflowStepDao = workflowStepDao;
  }
  
  @Override
  public WorkflowType getById(final Long id) {
    return this.workflowDao.getById(id);
  }
  
  @Override
  public List<WorkflowStep> getStepsById(final Long id) {
    final WorkflowType workflow = getById(id);
    return this.workflowStepDao.getListByIdList(workflow.getSteps().stream().collect(Collectors.toList()));
  }
  
  @Override
  public List<WorkflowType> getListByIdCompanyId(final Long id) {
    return this.workflowDao.getListByCompanyId(id);
  }
  
  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList) {
    return this.workflowDao.getListByIdList(idList);
  }
  
}
