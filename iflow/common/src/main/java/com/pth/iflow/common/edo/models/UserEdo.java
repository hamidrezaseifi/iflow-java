package com.pth.iflow.common.edo.models;

public class UserEdo {
  private Long id;
  private Long companyIid;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Integer status;
  private Integer permission;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
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
  public void setCompanyIid(Long companyIid) {
    this.companyIid = companyIid;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
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

  /**
   * @return the permission
   */
  public Integer getPermission() {
    return permission;
  }

  /**
   * @param permission the permission to set
   */
  public void setPermission(final Integer permission) {
    this.permission = permission;
  }

}
