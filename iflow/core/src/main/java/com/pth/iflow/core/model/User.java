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

  protected Long id;
  protected Long companyId;
  protected String email;
  protected String firstName;
  protected String lastName;
  protected Integer status;
  protected Integer permission;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;
  protected final Set<Long> groupIds = new HashSet<>();
  protected final Set<Long> departmentIds = new HashSet<>();
  protected final Set<Long> departmentGroupIds = new HashSet<>();
  protected final Set<Long> deputyIds = new HashSet<>();

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

  public Set<Long> getGroupIds() {
    return this.groupIds;
  }

  public void setGroupIds(final Set<Long> groups) {
    this.groupIds.clear();
    if (groups != null) {
      this.groupIds.addAll(groups);
    }
  }

  public void setGroupIds(final List<Long> groups) {
    setGroupIds(groups.stream().collect(Collectors.toSet()));
  }

  public void addGroupId(final Long groupId) {
    this.groupIds.add(groupId);
  }

  public Set<Long> getDepartmentIds() {
    return this.departmentIds;
  }

  public void setDepartmentIds(final Set<Long> departments) {
    this.departmentIds.clear();
    if (departments != null) {
      this.departmentIds.addAll(departments);
    }
  }

  public void setDepartmentIds(final List<Long> departments) {
    setDepartmentIds(departments.stream().collect(Collectors.toSet()));

  }

  public void addDepartmentId(final Long departmentId) {
    this.departmentIds.add(departmentId);
  }

  public Set<Long> getDepartmentGroupIds() {
    return this.departmentGroupIds;
  }

  public void setDepartmentGroupIds(final Set<Long> departmentGroups) {
    this.departmentGroupIds.clear();
    if (departmentGroups != null) {
      this.departmentGroupIds.addAll(departmentGroups);
    }
  }

  public void setDepartmentGroupIds(final List<Long> departmentGroups) {
    setDepartmentGroupIds(departmentGroups.stream().collect(Collectors.toSet()));
  }

  public void addDepartmentGroupId(final Long departmentGroupId) {
    this.departmentGroupIds.add(departmentGroupId);
  }

  public Set<Long> getDeputyIds() {
    return this.deputyIds;
  }

  public void setDeputyIds(final Set<Long> deputies) {
    this.deputyIds.clear();
    if (deputies != null) {
      this.deputyIds.addAll(deputies);
    }
  }

  public void setDeputyIds(final List<Long> deputies) {
    setDeputyIds(deputies.stream().collect(Collectors.toSet()));

  }

  public void addDeputyId(final Long deputyId) {
    this.deputyIds.add(deputyId);
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
    edo.setGroups(this.groupIds);
    edo.setDepartments(this.departmentIds);
    edo.setDepartmentGroups(this.departmentGroupIds);
    edo.setDeputies(this.deputyIds);

    return edo;
  }

  @Override
  public User fromEdo(final UserEdo edo) {
    final User user = new User();

    user.setFirstName(edo.getFirstName());
    user.setLastName(edo.getLastName());
    user.setPermission(edo.getPermission());
    user.setStatus(edo.getStatus());
    user.setEmail(edo.getEmail());
    user.setId(edo.getId());
    user.setCompanyId(edo.getCompanyId());
    user.setGroupIds(edo.getGroups());
    user.setDepartmentIds(edo.getDepartments());
    user.setDepartmentGroupIds(edo.getDepartmentGroups());
    user.setDeputyIds(edo.getDeputies());

    return user;
  }

  @Override
  public void fromExists(final User exist) {

    setFirstName(exist.getFirstName());
    setLastName(exist.getLastName());
    setPermission(exist.getPermission());
    setStatus(exist.getStatus());
    setEmail(exist.getEmail());
    setId(exist.getId());
    setCompanyId(exist.getCompanyId());
    setGroupIds(exist.getGroupIds());
    setDepartmentIds(exist.getDepartmentIds());
    setDepartmentGroupIds(exist.getDepartmentGroupIds());
    setDeputyIds(exist.getDeputyIds());
    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());

  }

}
