package com.pth.iflow.common.enums;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EInvoiceType implements IEnumValueValidator {
  NO_TYPE(0),
  SUPPLIER(1), // Lieferant
  WORKER(2), // Handwerk
  PAYMENT(3); // Gutschrift

  private final int id;

  private EInvoiceType(final int id) {
    this.id = id;
  }

  public static EInvoiceType ofValue(final int value) {
    for (final EInvoiceType status : values()) {
      if (status.getValue().intValue() == value) {
        return status;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value '" + value + "' for enum EInvoiceType");
  }

  @Override
  public Integer getValue() {
    return this.id;
  }

}
