package com.pth.iflow.gui.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EUserStatus;
import com.pth.iflow.gui.models.ui.enums.EUiUserRole;

@JsonIgnoreProperties(value = { "authorities", "enabled", "roles", })
public class User extends IdentityModel {

  private String                  companyIdentity;
  private String                  email;
  private LocalDate               birthDate;
  private String                  firstName;
  private String                  lastName;
  private Integer                 status;
  private Integer                 permission;
  private Integer                 version;
  private LocalDateTime           createdAt;
  private LocalDateTime           updatedAt;
  private final Set<String>       groups           = new HashSet<>();
  private final Set<String>       departments      = new HashSet<>();
  private final Set<String>       departmentGroups = new HashSet<>();
  private final Set<String>       deputies         = new HashSet<>();
  private final List<EUiUserRole> roles            = new ArrayList<>();

  private boolean                 isEnabled;

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  public String getUsername() {
    return this.email;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(final LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  public String geFullName() {
    return this.lastName + ", " + this.firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {
    this.status = status;
  }

  public boolean isActive() {
    return this.status == EUserStatus.ACTIVE.getValue().intValue();
  }

  /**
   * @return the permission
   */
  public Integer getPermission() {
    return this.permission;
  }

  /**
   * @return the version
   */

  public Integer getVersion() {
    return this.version;
  }

  /**
   * @param version the version to set
   */

  public void setVersion(final Integer version) {
    this.version = version;
  }

  /**
   * @return the createdAt
   */
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the updatedAt
   */
  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @param permission the permission to set
   */
  public void setPermission(final Integer permission) {
    this.permission = permission;
  }

  public Set<String> getGroups() {
    return this.groups;
  }

  public void setGroups(final Set<String> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final String groupId) {
    this.groups.add(groupId);
  }

  public Set<String> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final Set<String> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final String departmentId) {
    this.departments.add(departmentId);
  }

  public Set<String> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final Set<String> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final String departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public Set<String> getDeputies() {
    return this.deputies;
  }

  public void setDeputies(final Set<String> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final String deputyId) {
    this.deputies.add(deputyId);
  }

  public List<EUiUserRole> getRoles() {
    return this.roles;
  }

  public Set<Integer> getRolesInt() {
    return this.roles.stream().map(r -> r.getId()).collect(Collectors.toSet());
  }

  public void setRoles(final Set<Integer> roles) {
    this.roles.clear();
    if (roles != null) {
      this.roles.addAll(roles.stream().map(r -> EUiUserRole.ofId(r)).collect(Collectors.toList()));
    }
  }

  public void addRole(final Integer role) {
    this.roles.add(EUiUserRole.ofId(role));
  }

  public User() {
    this.isEnabled = true;
  }

  public String getFullName() {
    return this.lastName + ", " + this.firstName;
  }

  public boolean allowEdit() {
    return true;
  }

  public boolean isAdmin() {
    return true;
  }

  private String getRolesAuthoritiesNames() {

    String name = "";
    for (final EUiUserRole role : this.roles) {
      name += (name.isEmpty() ? "" : ", ") + role.getAuthority().toUpperCase();
    }
    return name;
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
    return AuthorityUtils.commaSeparatedStringToAuthorityList(this.getRolesAuthoritiesNames());
  }

  @Override
  public String getIdentity() {

    return this.email;
  }

  @Override
  public void setIdentity(final String identity) {
    // TODO Auto-generated method stub

  }

}
