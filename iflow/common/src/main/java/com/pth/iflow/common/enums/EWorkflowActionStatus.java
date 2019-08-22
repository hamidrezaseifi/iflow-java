package com.pth.iflow.common.enums;

import com.pth.iflow.common.enums.base.IValueList;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EWorkflowActionStatus implements IValueList {
  INITIALIZE(0),
  SAVED(5),
  DONE(10),
  ERROR(15);

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

    throw new IFlowInvalidEnumValueException("Invalid value '" + value + "' for enum EWorkflowStatus");
  }

  @Override
  public Long getValue() {
    return Long.valueOf(this.id);
  }

}
