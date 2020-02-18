package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;

@Entity
@Table(name = "company_workflowtype_items_ocr_settings")
public class CompanyWorkflowtypeItemOcrSettingEntity extends EntityHelper {

  private static final long serialVersionUID = 2937568589389217869L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_workflowtype_settings_generator")
  @SequenceGenerator(name = "company_workflowtype_settings_generator", sequenceName = "company_workflowtype_items_ocr_settings_seq")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", nullable = false)
  private CompanyEntity company;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_type_id", nullable = false)
  private WorkflowTypeEntity workflowType;

  @Column(name = "property_name")
  private String propertyName;

  @Column(name = "value")
  private String value;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

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

  @Override
  public void setId(final Long id) {

    this.id = id;
  }

  public CompanyEntity getCompany() {

    return company;
  }

  public void setCompany(final CompanyEntity company) {

    this.company = company;
  }

  public WorkflowTypeEntity getWorkflowType() {

    return workflowType;
  }

  public void setWorkflowType(final WorkflowTypeEntity workflowType) {

    this.workflowType = workflowType;
  }

  public String getPropertyName() {

    return propertyName;
  }

  public void setPropertyName(final String propertyName) {

    this.propertyName = propertyName;
  }

  public String getValue() {

    return value;
  }

  public void setValue(final String value) {

    this.value = value;
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

  @Override
  public void increaseVersion() {

    version += 1;
  }
}
