package com.pth.iflow.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum ECompanyType implements IEnumNameValidator {
  CUSTOME("None"),
  EINZELUNTERNEHMEN("Einzelunternehmen"),
  GBR("GbR"),
  OHG("OHG"),
  KG("KG"),
  GMBH("GmbH"),
  UG("UG");

  private String enumName;

  ECompanyType(final String enumName) {

    this.enumName = enumName;
  }

  @Override
  @JsonValue
  public String getIdentity() {

    return this.enumName;
  }

  @JsonCreator
  public static ECompanyType valueFromName(final String nameString) {

    for (final ECompanyType item : values()) {
      if (item.enumName.equals(nameString)) {
        return item;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value('" + nameString + "') for ECompanyType.");
  }

}
