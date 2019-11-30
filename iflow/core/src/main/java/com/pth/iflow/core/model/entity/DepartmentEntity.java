package com.pth.iflow.core.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "departments")
@EntityListeners(EntityListener.class)
public class DepartmentEntity extends EntityIdentityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                              id;

  @Column(name = "company_id")
  private Long                              companyId;

  @Column(name = "identity")
  private String                            identity;

  @Column(name = "title")
  private String                            title;

  @Column(name = "status")
  private Integer                           status;

  @Column(name = "version")
  private Integer                           version;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                              createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                              updatedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "department_id")
  private final List<DepartmentGroupEntity> departmentGroups = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private final CompanyEntity               company;

  public DepartmentEntity() {
    company = new CompanyEntity();
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.pth.iflow.core.model.ICoreIdentityModel#getIdentity()
   */

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
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

  public List<DepartmentGroupEntity> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final List<DepartmentGroupEntity> groups) {
    this.departmentGroups.clear();
    if (groups != null) {
      this.departmentGroups.addAll(groups);
    }
  }

  public void addDepartmentGroup(final DepartmentGroupEntity group) {
    this.departmentGroups.add(group);
  }

  @Override
  public String getIdentityPreffix() {
    return "dp";
  }

  @Override
  public void increaseVersion() {
    version += 1;
  }
}
