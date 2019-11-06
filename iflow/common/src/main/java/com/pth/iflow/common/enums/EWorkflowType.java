package com.pth.iflow.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

/**
 * A enumeration of names for MDM used modules
 *
 * @author bjoern frohberg
 */
public enum EWorkflowType implements IEnumNameValidator {
  NONE("None"),
  SINGLE_TASK_WORKFLOW_TYPE("singletaskworkflowtype"),
  THREE_TASK_WORKFLOW_TYPE("threetaskworkflowtype"),
  INVOICE_WORKFLOW_TYPE("invoiceworkflowtype");

  private String enumName;

  EWorkflowType(final String enumName) {
    this.enumName = enumName;
  }

  @Override
  @JsonValue
  public String getName() {
    return this.enumName;
  }

  @JsonCreator
  public static EWorkflowType valueFromName(final String nameString) {
    for (final EWorkflowType item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for EWorkflowType.");
  }

}
