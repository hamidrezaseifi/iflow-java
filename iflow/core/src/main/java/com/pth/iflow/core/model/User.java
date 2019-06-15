package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.enums.EUserStatus;

public class User extends ModelMapperBase<UserEdo, User> {
  private Long id;
  private Long companyId;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Integer status;
  private Integer permission;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private final Set<Long> groups = new HashSet<>();
  private final Set<Long> departments = new HashSet<>();
  private final Set<Long> departmentGroups = new HashSet<>();
  private final Set<Long> deputies = new HashSet<>();

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  public boolean hasId(final Long id) {
    return this.id == id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the companyIid
   */
  public Long getCompanyId() {
    return companyId;
  }

  /**
   * @param companyIid the companyIid to set
   */
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  public boolean hasPassword(final String password) {
    return this.password.equals(password);
  }

  /**
   * @param password the password to set
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
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
    return lastName;
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
    return status;
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
    return permission;
  }

  /**
   * @return the version
   */
  public Integer getVersion() {
    return version;
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
    return createdAt;
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
    return updatedAt;
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

  public Set<Long> getGroups() {
    return groups;
  }

  public void setGroups(final Set<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void setGroups(final List<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }

  public Set<Long> getDepartments() {
    return departments;
  }

  public void setDepartments(final Set<Long> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void setDepartments(final List<Long> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final Long departmentId) {
    this.departments.add(departmentId);
  }

  public Set<Long> getDepartmentGroups() {
    return departmentGroups;
  }

  public void setDepartmentGroups(final Set<Long> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final Long departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public Set<Long> getDeputies() {
    return deputies;
  }

  public void setDeputies(final Set<Long> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void setDeputies(final List<Long> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final Long deputyId) {
    this.deputies.add(deputyId);
  }

  @Override
  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(firstName);
    edo.setLastName(lastName);
    edo.setPassword(password);
    edo.setPermission(permission);
    edo.setStatus(status);
    edo.setEmail(email);
    edo.setId(id);
    edo.setCompanyId(companyId);
    edo.setGroups(groups);
    edo.setDepartments(departments);
    edo.setDepartmentGroups(departmentGroups);
    edo.setDeputies(deputies);

    return edo;
  }

  @Override
  public User fromEdo(final UserEdo edo) {
    final User user = new User();

    user.setFirstName(edo.getFirstName());
    user.setLastName(edo.getLastName());
    user.setPassword(edo.getPassword());
    user.setPermission(edo.getPermission());
    user.setStatus(edo.getStatus());
    user.setEmail(edo.getEmail());
    user.setId(edo.getId());
    user.setCompanyId(edo.getCompanyId());
    user.setGroups(edo.getGroups());
    user.setDepartments(edo.getDepartments());
    user.setDepartmentGroups(edo.getDepartmentGroups());
    user.setDeputies(edo.getDeputies());

    return user;
  }

}
