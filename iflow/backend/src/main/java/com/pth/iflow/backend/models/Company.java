package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.helper.IdentityModel;

public class Company extends IdentityModel {

  private Long    id;
  private String  identity;
  private String  companyName;
  private Integer status;
  private Integer version;

  /**
   * @return the id
   */

  @Override
  public String getIdentity() {
    return this.identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  /**
   * @return the companyName
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Override
  public boolean isNew() {
    return (this.id == null) || (this.id <= 0);
  }

}
