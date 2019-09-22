package com.pth.iflow.core.model;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowOfferStatus;

public class WorkflowOffer extends DataModelBase {

  private Long                 id;

  private Long                 workflowId;

  private Long                 userId;

  private EWorkflowOfferStatus status;

  private Integer              version;

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public EWorkflowOfferStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EWorkflowOfferStatus status) {
    this.status = status;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

}
