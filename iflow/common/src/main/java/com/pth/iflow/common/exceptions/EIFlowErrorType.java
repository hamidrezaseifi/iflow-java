package com.pth.iflow.common.exceptions;

import com.pth.iflow.common.enums.IEnumValueValidator;

public enum EIFlowErrorType implements IEnumValueValidator {
  NONE(0),
  INVALID_USERNAMEPASSWORD(10),
  USER_NOTFOUND(20),
  COMPANY_NOTFOUND(30),
  INVALID_COMPANY(31),
  INVALID_TOKEN(40),
  NO_SESSION_FOUND(50),
  UNKNOWN_WORKFLOW_STATUS(60),
  UNKNOWN_WORKFLOW_TYPE_STEP(61),
  INVALID_WORKFLOW_STEP(62),
  UNKNOWN_WORKFLOW_ASSIGN(63),
  INVALID_WORKFLOW_DETAIL(65),
  INVALID_WORKFLOW_STATUS(70),
  UNKNOWN_WORKFLOW_STRATEGY(90),
  NO_WORKFLOW_ASSIGN_CREATE_STRATEGY(91),
  INVALID_WORKFLOW_ASSIGN_LIST(100),

  UNKNOWN(1000);

  private final Integer id;

  private EIFlowErrorType(final Integer id) {
    this.id = id;
  }

  @Override
  public Integer getValue() {
    return this.id;
  }

}
