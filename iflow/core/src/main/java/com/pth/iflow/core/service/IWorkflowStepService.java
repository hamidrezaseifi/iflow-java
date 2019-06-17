package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowStep;

public interface IWorkflowStepService {
  
  public WorkflowStep getById(Long id);
  
  public List<WorkflowStep> getListByIdList(final List<Long> idList);
}
