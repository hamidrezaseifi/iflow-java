package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowAction;

public interface IWorkflowActionService {

  public WorkflowAction save(WorkflowAction model);

  public WorkflowAction getById(Long id);

  public Set<WorkflowAction> getListByIdWorkflowId(final Long id);

}
