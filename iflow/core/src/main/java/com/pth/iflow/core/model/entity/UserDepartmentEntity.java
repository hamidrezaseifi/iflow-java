package com.pth.iflow.core.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user_departments")
public class UserDepartmentEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_id")
  private Long              userId;

  @Id
  @Column(name = "department_id")
  private Long              departmentId;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date              createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private DepartmentEntity  department;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity        userEntity;

  public UserDepartmentEntity() {

  }

  /*
   * public Long getUserId() { return userId; }
   *
   * public void setUserId(final Long userId) { this.userId = userId; }
   */

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(final Long departmentId) {
    this.departmentId = departmentId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public DepartmentEntity getDepartment() {
    return department;
  }

  public void setDepartment(final DepartmentEntity department) {
    this.department = department;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
  }

}
