package com.pth.iflow.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EInvoiceWorkflowTypeItems implements IEnumNameValidator {

  INVOCIE_SENDER("invoice-sender"),

  INVOCIE_NUMBER("invoice-invoicenumber"),

  INVOCIE_DATE("invocie-date"),

  PARTNER_CODE("partner-code"),

  VENDOR_NUMBER("vendor-number"),

  VENDOR_NAME("vendor-name"),

  IS_DIRECT_DEBIT_PERMISSION("is-direct-debit-permission"),

  INVOICE_TYPE("invoice-type"),

  DISCOUNT_ENTERDATE("discount-enterdate"),

  DISCOUNT_DEADLINE("discount-deadline"),

  DISCOUNT_RATE("discount-rate"),

  DISCOUNT_DATE("discount-date"),

  PAYMENT_AMOUNT("invoice-paymentamount");

  EInvoiceWorkflowTypeItems(final String itemIdentity) {

    this.itemIdentity = itemIdentity;

  }

  private final String itemIdentity;

  @Override
  public String getIdentity() {

    return this.itemIdentity;
  }

  public static List<String> toIdentityList() {

    return Arrays.asList(values()).stream().map(e -> e.getIdentity()).collect(Collectors.toList());
  }

}
