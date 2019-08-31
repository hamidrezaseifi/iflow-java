package com.pth.iflow.common.enums;

import com.pth.iflow.common.enums.base.IValueList;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EWorkflowActionStatus implements IValueList {
  INITIALIZE(0),
  OPEN(5),
  SAVING_REQUEST(10),
  DONE_REQUEST(15),
  DONE(20),
  ERROR(30);

  private final int id;

  private EWorkflowActionStatus(final int id) {
    this.id = id;
  }

  public static EWorkflowActionStatus ofValue(final int value) {
    for (final EWorkflowActionStatus status : values()) {
      if (status.getValue().intValue() == value) {
        return status;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value '" + value + "' for enum EWorkflowActionStatus");
  }

  @Override
  public Long getValue() {
    return Long.valueOf(this.id);
  }

  public boolean isActive() {
    return (this.id < DONE.getValue());
  }

  public static boolean getIsActive(final Integer status) {
    return (status < DONE.getValue());
  }

}
