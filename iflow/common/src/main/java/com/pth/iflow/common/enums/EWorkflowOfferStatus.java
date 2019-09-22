package com.pth.iflow.common.enums;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EWorkflowOfferStatus implements IEnumValueValidator {
  NO_STATUS(0),
  OFFERING(1),
  ASSIGNED(2),
  CLOSED(3);

  private final int id;

  private EWorkflowOfferStatus(final int id) {
    this.id = id;
  }

  public static EWorkflowOfferStatus ofValue(final int value) {
    for (final EWorkflowOfferStatus status : values()) {
      if (status.getValue().intValue() == value) {
        return status;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value '" + value + "' for enum EWorkflowOfferStatus");
  }

  @Override
  public Integer getValue() {
    return this.id;
  }

}
