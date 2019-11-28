package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pth.iflow.core.storage.dao.helper.EntityHelper;

@Entity
@Table(name = "companies")
public class CompanyEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long    id;

  @Column(name = "identity")
  private String  identity;

  @Column(name = "company_name")
  private String  companyName;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @Column(name = "created_at")
  private Date    createdAt;

  @Column(name = "updated_at")
  private Date    updatedAt;

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
  public Date getCreatedAt() {
    return this.createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String getIdentityPreffix() {
    return "c";
  }

}
