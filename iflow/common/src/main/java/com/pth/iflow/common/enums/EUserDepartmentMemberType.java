package com.pth.iflow.common.enums;

import java.util.HashMap;
import java.util.Map;

import com.pth.iflow.common.exceptions.IFlowInvalidEnumValueException;

public enum EUserDepartmentMemberType implements IEnumValueValidator {
  NO_ASSIGNED(0),
  MEMBER(5), // Lieferant
  DEPUTY(10), // Handwerk
  MANAGER(20); // Gutschrift

  private final int id;

  private EUserDepartmentMemberType(final int id) {

    this.id = id;
  }

  public static EUserDepartmentMemberType ofValue(final int value) {

    for (final EUserDepartmentMemberType type : values()) {
      if (type.getValue().intValue() == value) {
        return type;
      }
    }

    throw new IFlowInvalidEnumValueException("Invalid value '" + value + "' for enum EUserDepartmentMemberType");
  }

  @Override
  public Integer getValue() {

    return this.id;
  }

  public static Map<Integer, String> nameValueMap() {

    final Map<Integer, String> map = new HashMap<>();
    for (final EUserDepartmentMemberType type : values()) {
      map.put(type.getValue(), type.toString());
    }

    return map;

  }

}
