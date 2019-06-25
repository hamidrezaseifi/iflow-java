package com.pth.ifow.profile.model;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.enums.EUserStatus;

public class User {

  private Long    id;
  private Long    companyId;
  private String  email;
  private String  firstName;
  private String  lastName;
  private Integer status;
  private Integer permission;

  public User() {

  }

  /**
   * @return the id
   */
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

  /**
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @param email the email to set
   */
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
   * @param permission the permission to set
   */
  public void setPermission(final Integer permission) {
    this.permission = permission;
  }

  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(this.firstName);
    edo.setLastName(this.lastName);
    edo.setPermission(this.permission);
    edo.setStatus(this.status);
    edo.setEmail(this.email);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);

    return edo;
  }

  public static User fromEdo(final UserEdo edo) {
    if (edo == null) {
      return null;
    }
    final User user = new User();

    user.setFirstName(edo.getFirstName());
    user.setLastName(edo.getLastName());
    user.setPermission(edo.getPermission());
    user.setStatus(edo.getStatus());
    user.setEmail(edo.getEmail());
    user.setId(edo.getId());
    user.setCompanyId(edo.getCompanyId());

    return user;
  }

}
