package com.pth.iflow.gui.models;

public class GuiCompany {

  private String  identity;
  private String  companyName;
  private Integer status;
  private Integer version;

  /**
   * @return the id
   */

  /**
   * @return the identifyid
   */
  public String getIdentity() {
    return this.identity;
  }

  /**
   * @param identifyid the identifyid to set
   */
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

}
