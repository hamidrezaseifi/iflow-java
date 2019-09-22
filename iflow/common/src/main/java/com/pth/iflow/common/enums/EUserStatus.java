package com.pth.iflow.common.enums;

import com.pth.iflow.common.enums.base.IValueList;

public enum EUserStatus implements IValueList {
  ACTIVE(1),
  DISABLED(10),
  DELETED(20);

  private final Integer id;

  private EUserStatus(final Integer id) {
    this.id = id;
  }

  @Override
  public Integer getValue() {
    return this.id;
  }

}
