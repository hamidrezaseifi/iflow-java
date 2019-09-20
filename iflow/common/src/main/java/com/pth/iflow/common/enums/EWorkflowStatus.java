package com.pth.iflow.common.enums;

import com.pth.iflow.common.enums.base.IValueList;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EWorkflowStatus implements IValueList {
  INITIALIZE(5),
  NOT_ASSIGNED(10),
  ASSIGNED(15),
  DONE(20),
  ARCHIVED(25),
  ERROR(30);

  private final int id;

  private EWorkflowStatus(final int id) {
    this.id = id;
  }

  public static EWorkflowStatus ofValue(final int value) {
    for (final EWorkflowStatus status : values()) {
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
