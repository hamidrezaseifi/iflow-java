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
@Table(name = "user_department_groups")
public class UserDepartmentGroupEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /*
   * @Id
   *
   * @Column(name = "user_id") private Long userId;
   */

  @Id
  @Column(name = "department_group_id")
  private Long departmentGroupId;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_group_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private DepartmentGroupEntity departmentGroup;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity userEntity;

  public UserDepartmentGroupEntity() {
    departmentGroup = new DepartmentGroupEntity();
  }

  /*
   * public Long getUserId() { return userId; }
   *
   * public void setUserId(final Long userId) { this.userId = userId; }
   */

  public Long getDepartmentGroupId() {
    return departmentGroupId;
  }

  public void setDepartmentGroupId(final Long departmentGroupId) {
    this.departmentGroupId = departmentGroupId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public DepartmentGroupEntity getDepartmentGroup() {
    return departmentGroup;
  }

  public void setDepartmentGroup(final DepartmentGroupEntity departmentGroup) {
    this.departmentGroup = departmentGroup;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
  }

}
