package com.pth.iflow.backend.models.ui.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EUiUserRole {
  
  NOROLE(1L, "No Role", ""),
  VIEWER(10L, "Zuschauer", "ROLE_VIEWER"),
  DATA_STEWARD(20L, "Data Steward", "ROLE_DATA_STEWARD"),
  ADMIN(25L, "Administrator", "ROLE_ADMIN");
  
  private final Long   id;
  private final String name;
  private final String authority;
  
  private EUiUserRole(final Long id, final String name, final String authority) {
    this.id = id;
    this.name = name;
    this.authority = authority;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getAuthority() {
    return this.authority;
  }
  
  public String getAuthorityRole() {
    return this.authority.replace("ROLE_", "");
  }
  
  @JsonCreator
  public static EUiUserRole ofValue(final String value) {
    if (value == null) {
      return NOROLE;
    }
    for (final EUiUserRole role : values()) {
      if (role.name().equals(value)) {
        return role;
      }
    }
    return NOROLE;
  }
  
}
