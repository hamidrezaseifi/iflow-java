package com.pth.ifow.workflow.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;

public class Company extends ModelMapperBase<CompanyEdo, Company> {

  private Long id;
  private String identifyid;
  private String companyName;
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

  @Override
  public Integer getVersion() {
    return version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Override
  public boolean isNew() {
    return id == null || id <= 0;
  }

  @Override
  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(this.companyName);
    edo.setIdentifyid(this.identifyid);
    edo.setStatus(this.status);
    edo.setId(this.id);

    return edo;
  }

  @Override
  public Company fromEdo(final CompanyEdo edo) {
    final Company company = new Company();
    company.setCompanyName(edo.getCompanyName());
    company.setIdentifyid(edo.getIdentifyid());
    company.setStatus(edo.getStatus());
    company.setId(edo.getId());

    return company;
  }

}
