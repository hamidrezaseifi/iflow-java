package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeService {

  public WorkflowType getById(Long id);

  public List<WorkflowType> getListByIdCompanyId(final Long id);

  public List<WorkflowTypeStep> getStepsById(final Long id);
  
  public List<WorkflowType> getListByIdList(final List<Long> idList);
}
