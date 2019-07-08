package com.pth.iflow.common.exceptions;

import com.pth.iflow.common.enums.base.IValueList;

public enum EIFlowErrorType implements IValueList {
  NONE(0L),
  INVALID_USERNAMEPASSWORD(10L),
  USER_NOTFOUND(20L),
  COMPANY_NOTFOUND(30L),
  INVALID_TOKEN(40L),
  NO_SESSION_FOUND(50L),
  UNKNOWN_WORKFLOW_STATUS(60L),

  UNKNOWN(1000L);

  private final Long id;

  private EIFlowErrorType(final Long id) {
    this.id = id;
  }

  @Override
  public Long getValue() {
    return id;
  }

}
