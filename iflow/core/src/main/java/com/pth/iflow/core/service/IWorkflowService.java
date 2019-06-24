package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowStep;

public interface IWorkflowService {

  public WorkflowType getById(Long id);

  public List<WorkflowType> getListByIdCompanyId(final Long id);

  public List<WorkflowStep> getStepsById(final Long id);
  
  public List<WorkflowType> getListByIdList(final List<Long> idList);
}
