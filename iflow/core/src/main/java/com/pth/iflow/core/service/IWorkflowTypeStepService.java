package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeStepService {

  public WorkflowTypeStep getById(Long id);

  public List<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId);

  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList);
}
