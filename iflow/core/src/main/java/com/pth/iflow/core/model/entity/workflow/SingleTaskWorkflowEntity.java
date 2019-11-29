package com.pth.iflow.core.model.entity.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.pth.iflow.common.enums.EWorkflowType;

@Entity
@Table(name = "singletask_workflow")
public class SingleTaskWorkflowEntity {

  @Id
  @Column(name = "workflow_id")
  private Long           workflowId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", insertable = true, updatable = true)
  @Fetch(FetchMode.JOIN)
  private WorkflowEntity workflow;

  public SingleTaskWorkflowEntity() {
    workflow = new WorkflowEntity();
    workflow.getWorkflowType().setIdentity(EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE.getIdentity());
  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
  }

  public boolean isNew() {

    return workflow.isNew();
  }

  public void verifyVersion(final SingleTaskWorkflowEntity exists) {
    workflow.verifyVersion(exists.getWorkflow());
  }

}
