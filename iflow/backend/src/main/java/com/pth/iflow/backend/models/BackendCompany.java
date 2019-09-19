package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.base.DataModelBase;

public class BackendCompany extends DataModelBase<CompanyEdo, BackendCompany> {

  private Long    id;
  private String  identifyid;
  private String  companyName;
  private Integer status;
  private Integer version;

  /**
   * @return the id
   */

  public Long getId() {
    return this.id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the identifyid
   */
  public String getIdentifyid() {
    return this.identifyid;
  }

  /**
   * @param identifyid the identifyid to set
   */
  public void setIdentifyid(final String identifyid) {
    this.identifyid = identifyid;
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

  public boolean isNew() {
    return (this.id == null) || (this.id <= 0);
  }

}
