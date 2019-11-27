package com.pth.iflow.core.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_id")
  private Long              userId;

  @Id
  @Column(name = "role")
  private Long              role;

  @Column(name = "created_at")
  private Date              createdAt;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public Long getRole() {
    return role;
  }

  public void setRole(final Long role) {
    this.role = role;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

}
