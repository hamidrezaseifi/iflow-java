package com.pth.iflow.common.enums;

import com.pth.iflow.common.enums.base.IValueList;

public enum EUserStatus implements IValueList {
  ACTIVE(1L),
  DISABLED(10L),
  DELETED(20L);

  private final Long   id;

  private EUserStatus(final Long id) {
    this.id = id;
  }

  @Override
  public Long getValue() {
    return id;
  }
  
  
}
