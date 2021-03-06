package com.pth.iflow.common.enums;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

/**
 * A enumeration of names for MDM used modules
 *
 * @author bjoern frohberg
 */
public enum EWorkflowProcessCommand implements IEnumNameValidator {
  NONE("None"),
  CREATE("Create"),
  SAVE("Save"),
  DONE("Done"),
  ARCHIVE("Archive"),
  ASSIGN("Assign");

  private String enumName;

  EWorkflowProcessCommand(final String enumName) {
    this.enumName = enumName;
  }

  @Override
  public String getIdentity() {
    return this.enumName;
  }

  public static EWorkflowProcessCommand valueFromName(final String nameString) {
    for (final EWorkflowProcessCommand item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for EWorkflowProcessCommand.");
  }

}
