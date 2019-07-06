package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.enums.EUserStatus;

public class User extends ModelMapperBase<UserEdo, User> {

  private Long id;
  private Long companyId;
  private String email;
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
  @Override
  public Long getId() {
    return this.id;
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
    return this.companyId;
  }

  /**
   * @param companyIid the companyIid to set
   */
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
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
  @Override
  public Integer getVersion() {
    return this.version;
  }

  /**
   * @param version the version to set
   */
  @Override
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

  public Set<Long> getGroups() {
    return this.groups;
  }

  public void setGroups(final Set<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void setGroups(final List<Long> groups) {
    setGroups(groups.stream().collect(Collectors.toSet()));
  }

  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }

  public Set<Long> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final Set<Long> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void setDepartments(final List<Long> departments) {
    setDepartments(departments.stream().collect(Collectors.toSet()));

  }

  public void addDepartment(final Long departmentId) {
    this.departments.add(departmentId);
  }

  public Set<Long> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final Set<Long> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void setDepartmentGroups(final List<Long> departmentGroups) {
    setDepartmentGroups(departmentGroups.stream().collect(Collectors.toSet()));
  }

  public void addDepartmentGroup(final Long departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public Set<Long> getDeputies() {
    return this.deputies;
  }

  public void setDeputies(final Set<Long> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void setDeputies(final List<Long> deputies) {
    setDeputies(deputies.stream().collect(Collectors.toSet()));

  }

  public void addDeputy(final Long deputyId) {
    this.deputies.add(deputyId);
  }

  @Override
  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(this.firstName);
    edo.setLastName(this.lastName);
    edo.setPermission(this.permission);
    edo.setStatus(this.status);
    edo.setEmail(this.email);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setGroups(this.groups);
    edo.setDepartments(this.departments);
    edo.setDepartmentGroups(this.departmentGroups);
    edo.setDeputies(this.deputies);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public User fromEdo(final UserEdo edo) {
    final User model = new User();

    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setEmail(edo.getEmail());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setGroups(edo.getGroups());
    model.setDepartments(edo.getDepartments());
    model.setDepartmentGroups(edo.getDepartmentGroups());
    model.setDeputies(edo.getDeputies());
    model.setVersion(edo.getVersion());

    return model;
  }

}
