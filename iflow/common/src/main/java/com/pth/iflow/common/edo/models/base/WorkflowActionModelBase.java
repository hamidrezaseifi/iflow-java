package com.pth.iflow.common.edo.models.base;

import com.pth.iflow.common.enums.EWorkflowActionStatus;

public abstract class WorkflowActionModelBase<E, M> extends ModelMapperBase<E, M> {

  public abstract Integer getStatusInt();

  public boolean getIsActive() {
    return EWorkflowActionStatus.getIsActive(this.getStatusInt());
  }
}
