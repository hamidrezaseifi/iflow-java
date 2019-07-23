package com.pth.iflow.backend.models.ui.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.backend.models.ui.enums.EUiUserRole;

@JsonIgnoreProperties(value = {
    "authorities", "enabled", })
public class UiUser {

  private String                  username;
  private String                  password;
  private String                  firstName;
  private String                  lastName;
  private final List<EUiUserRole> roles;
  private boolean                 isEnabled;

  public UiUser() {
    this.roles = new ArrayList<>();
    this.username = "";
    this.firstName = "";
    this.lastName = "";

  }
  
  public UiUser(final String username,
      final String firstName,
      final String lastName,
      final EUiUserRole[] roles) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.roles = Arrays.asList(roles);

  }

  public UiUser(final String username,
      final String firstName,
      final String lastName,
      final List<EUiUserRole> roles) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.roles = new ArrayList<>();
    this.roles.addAll(roles);

  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public boolean equal(final String username) {

    return this.username.equals(username);
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
    return this.lastName + ", " + this.firstName;
  }

  public List<EUiUserRole> getRoles() {
    return this.roles;
  }

  public boolean hasRole(final EUiUserRole role) {
    return this.roles.contains(role);
  }

  public boolean allowEdit() {
    return this.roles.contains(EUiUserRole.ADMIN) || this.roles.contains(EUiUserRole.DATA_STEWARD);
  }

  public boolean isAdmin() {
    return this.roles.contains(EUiUserRole.ADMIN);
  }

  public boolean isDatasteward() {
    return this.roles.contains(EUiUserRole.DATA_STEWARD);
  }

  public String getRoleNames() {
    String name = "";
    for (final EUiUserRole role : this.roles) {
      name += (name.isEmpty() ? "" : ", ") + role.toString().toUpperCase();
    }
    return name;
  }

  private String getRolesAuthoritiesNames() {
    String name = "";
    for (final EUiUserRole role : this.roles) {
      name += (name.isEmpty() ? "" : ", ") + role.getAuthority().toUpperCase();
    }
    return name;
  }

  public void setRoles(final List<EUiUserRole> roles) {
    this.roles.clear();
    this.roles.addAll(roles);
  }

  public void addRole(final EUiUserRole role) {
    this.roles.add(role);
  }

  public boolean isEnabled() {
    return this.isEnabled;
  }

  @JsonSetter("isEnabled")
  public void setEnabled(final boolean isEnabled) {
    this.isEnabled = isEnabled;
  }
  
  public String getUserTitle() {
    return this.lastName + ", " + this.firstName;
  }

  public List<GrantedAuthority> getAuthorities() {
    final List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList(getRolesAuthoritiesNames());
    return list;
  }
}
