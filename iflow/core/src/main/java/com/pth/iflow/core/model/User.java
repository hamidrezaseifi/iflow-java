package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.enums.EUserStatus;

public class User {
  private Long id;
  private Long companyIid;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Integer status;
  private Integer permission;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public User() {

  }

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
  public Long getCompanyIid() {
    return companyIid;
  }

  /**
   * @param companyIid the companyIid to set
   */
  public void setCompanyIid(final Long companyIid) {
    this.companyIid = companyIid;
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

  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(firstName);
    edo.setLastName(lastName);
    edo.setPassword(password);
    edo.setPermission(permission);
    edo.setStatus(status);
    edo.setEmail(email);
    edo.setId(id);
    edo.setCompanyIid(companyIid);

    return edo;
  }

  public static User fromEdo(final UserEdo edo) {
    final User user = new User();

    user.setFirstName(edo.getFirstName());
    user.setLastName(edo.getLastName());
    user.setPassword(edo.getPassword());
    user.setPermission(edo.getPermission());
    user.setStatus(edo.getStatus());
    user.setEmail(edo.getEmail());
    user.setId(edo.getId());
    user.setCompanyIid(edo.getCompanyIid());

    return user;
  }

}
