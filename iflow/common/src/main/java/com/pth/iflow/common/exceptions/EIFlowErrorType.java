package com.pth.iflow.common.exceptions;

import com.pth.iflow.common.enums.base.IValueList;

public enum EIFlowErrorType implements IValueList {
  NONE(0L),
  INVALID_USERNAMEPASSWORD(10L),
  USER_NOTFOUND(20L),
  COMPANY_NOTFOUND(30L),
  INVALID_COMPANY(31L),
  INVALID_TOKEN(40L),
  NO_SESSION_FOUND(50L),
  UNKNOWN_WORKFLOW_STATUS(60L),
  UNKNOWN_WORKFLOW_STEP(61L),
  INVALID_WORKFLOW_STEP(62L),
  UNKNOWN_WORKFLOW_ASSIGN(63L),
  UNKNOWN_WORKFLOW_SAVE_STRATEGY(90L),
  UNKNOWN_WORKFLOW_CREATE_STRATEGY(91L),

  UNKNOWN(1000L);

  private final Long id;

  private EIFlowErrorType(final Long id) {
    this.id = id;
  }

  @Override
  public Long getValue() {
    return this.id;
  }

}
