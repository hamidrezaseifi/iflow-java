package com.pth.ifow.profile.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;

public class Company extends ModelMapperBase<CompanyEdo, Company> {

  private Long id;
  private String identifyid;
  private String companyName;
  private Integer status;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  /**
   * @return the id
   */
  @Override
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

  /**
   * @return the version
   */
  @Override
  public Integer getVersion() {
    return this.version;
  }

  /**
   * @param version the version to set
   */
  @Override
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

  @Override
  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(this.companyName);
    edo.setIdentifyid(this.identifyid);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public Company fromEdo(final CompanyEdo edo) {
    final Company model = new Company();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentifyid(edo.getIdentifyid());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setVersion(edo.getVersion());

    return model;
  }

}
