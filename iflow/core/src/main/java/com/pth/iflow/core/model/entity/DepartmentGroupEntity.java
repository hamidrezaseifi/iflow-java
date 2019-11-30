package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "departments_group")
@EntityListeners(EntityListener.class)
public class DepartmentGroupEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "identity")
  private String                 identity;

  @Column(name = "department_id")
  private Long                   departmentId;

  @Column(name = "title")
  private String                 title;

  @Column(name = "status")
  private Integer                status;

  @Column(name = "version")
  private Integer                version;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                   createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                   updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private final DepartmentEntity department;

  public DepartmentGroupEntity() {
    department = new DepartmentEntity();
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getDepartmentId() {
    return this.departmentId;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public void setDepartmentId(final Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String getIdentityPreffix() {
    return "dpg";
  }

}
