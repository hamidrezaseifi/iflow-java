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

@Entity
@Table(name = "testthreetask_workflow")
public class TestThreeTaskWorkflowEntity {

  @Id
  @Column(name = "workflow_id")
  private String workflowId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", insertable = true, updatable = true)
  @Fetch(FetchMode.JOIN)
  private WorkflowEntity workflow;

  public String getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final String workflowId) {
    this.workflowId = workflowId;
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
  }

}
