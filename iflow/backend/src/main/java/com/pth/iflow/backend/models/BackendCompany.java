package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;

public class BackendCompany extends ModelMapperBase<CompanyEdo, BackendCompany> {

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

  @Override
  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(this.companyName);
    edo.setIdentifyid(this.identifyid);
    edo.setStatus(this.status);
    edo.setVersion(this.version);
    edo.setId(this.id);

    return edo;
  }

  @Override
  public BackendCompany fromEdo(final CompanyEdo edo) {
    final BackendCompany model = new BackendCompany();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentifyid(edo.getIdentifyid());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());

    return model;
  }

}
