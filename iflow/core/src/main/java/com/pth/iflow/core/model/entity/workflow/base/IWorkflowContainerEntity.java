package com.pth.iflow.core.model.entity.workflow.base;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;

public interface IWorkflowContainerEntity {

  public Long getWorkflowId();

  public void setWorkflowId(final Long workflowId);

  public WorkflowEntity getWorkflow();

  public void setWorkflow(final WorkflowEntity workflow);

}
