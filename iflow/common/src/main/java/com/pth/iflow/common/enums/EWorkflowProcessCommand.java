package com.pth.iflow.common.enums;

/**
 * A enumeration of names for MDM used modules
 *
 * @author bjoern frohberg
 */
public enum EWorkflowProcessCommand implements IValidatorEnum {
  CREATE,
  SAVE,
  DONE,
  ARCHIVE,
  ASSIGN;

	@Override
	public String getName() {
		return this.name();
	}
 
}
