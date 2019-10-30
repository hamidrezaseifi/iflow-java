package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowAction;

public interface IWorkflowActionService {

  public WorkflowAction save(WorkflowAction model);

  public WorkflowAction getByIdentity(String identity);

  public List<WorkflowAction> getListByIdWorkflowIdentity(final String identity);

}
