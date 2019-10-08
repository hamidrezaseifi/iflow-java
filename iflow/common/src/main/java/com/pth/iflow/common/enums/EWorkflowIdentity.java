package com.pth.iflow.common.enums;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EWorkflowIdentity implements IEnumNameValidator {
  NOT_SET("notset");

  private String enumName;

  EWorkflowIdentity(final String enumName) {
    this.enumName = enumName;
  }

  @Override
  public String getName() {
    return this.enumName;
  }

  public static EWorkflowIdentity valueFromName(final String nameString) {
    for (final EWorkflowIdentity item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for EWorkflowIdentity.");
  }

}
