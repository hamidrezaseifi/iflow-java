package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowAction;

public interface IWorkflowActionService {

  public WorkflowAction save(WorkflowAction model);

  public WorkflowAction getById(Long id);

  public List<WorkflowAction> getListByIdWorkflowId(final Long id);

}
