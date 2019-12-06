package com.pth.iflow.core.model.entity.workflow;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pth.iflow.core.model.entity.workflow.base.IWorkflowContainerEntity;

@Entity
@Table(name = "testthreetask_workflow")
public class TestThreeTaskWorkflowEntity implements IWorkflowContainerEntity {

  @Id
  @Column(name = "workflow_id")
  private Long           workflowId;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "workflowId")
  private WorkflowEntity workflow;

  public TestThreeTaskWorkflowEntity() {

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

  public void verifyVersion(final TestThreeTaskWorkflowEntity exists) {
    workflow.verifyVersion(exists.getWorkflow());
  }

  public void updateFromExists(final TestThreeTaskWorkflowEntity exists) {
    if (exists == null) {
      return;
    }

    this.workflow.updateFromExists(exists.workflow);

  }

}
