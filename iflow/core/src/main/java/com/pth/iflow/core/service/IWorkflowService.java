package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowStep;

public interface IWorkflowService {

  public Workflow getById(Long id);

  public List<Workflow> getListByIdCompanyId(final Long id);

  public List<WorkflowStep> getStepsById(final Long id);
  
  public List<Workflow> getListByIdList(final List<Long> idList);
}
