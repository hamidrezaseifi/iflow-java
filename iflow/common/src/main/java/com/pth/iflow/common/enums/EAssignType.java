package com.pth.iflow.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

/**
 * A enumeration of names for MDM used modules
 *
 * @author bjoern frohberg
 */
public enum EAssignType implements IEnumNameValidator {
  NONE("None"),
  USER("User"),
  DEPARTMENT("Department"),
  DEPARTMENTGROUP("DepartmentGroup");

  private String enumName;

  EAssignType(final String enumName) {
    this.enumName = enumName;
  }

  @Override
  @JsonValue
  public String getName() {
    return this.enumName;
  }

  @JsonCreator
  public static EAssignType valueFromName(final String nameString) {
    for (final EAssignType item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for EAssignType.");
  }

}
