package com.pth.iflow.workflow.models;

import com.pth.iflow.common.models.helper.IdentityModel;

public class Company extends IdentityModel {

  private String  identity;
  private String  companyName;
  private Integer status;
  private Integer version;

  @Override
  public String getIdentity() {
    return identity;
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

}
