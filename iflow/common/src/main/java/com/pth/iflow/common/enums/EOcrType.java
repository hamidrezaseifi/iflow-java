package com.pth.iflow.common.enums;

public enum EOcrType implements IEnumValueValidator {
  NO_OCR(0),
  SEARCH_WORD(1),
  FIXED_POSITION(2);

  private final Integer id;

  private EOcrType(final Integer id) {

    this.id = id;
  }

  @Override
  public Integer getValue() {

    return this.id;
  }

}
