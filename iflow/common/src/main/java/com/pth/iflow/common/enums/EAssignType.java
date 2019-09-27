package com.pth.iflow.common.enums;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

/**
 * A enumeration of names for MDM used modules
 *
 * @author bjoern frohberg
 */
public enum EAssignType implements IEnumNameValidator {
  NONE("None"),
  USER("User"),
  DEPARTMENT("Department");

  private String enumName;

  EAssignType(final String enumName) {
    this.enumName = enumName;
  }

  @Override
  public String getName() {
    return this.enumName;
  }

  public static EAssignType valueFromName(final String nameString) {
    for (final EAssignType item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for EAssignType.");
  }

}
