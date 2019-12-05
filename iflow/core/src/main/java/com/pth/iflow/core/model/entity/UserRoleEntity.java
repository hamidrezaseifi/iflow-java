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

@Entity
@Table(name = "user_roles")
public class UserRoleEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  // @Id
  // @Column(name = "user_id")
  // private Long userId;

  @Id
  @Column(name = "role")
  private Integer role;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity userEntity;

  /*
   * public Long getUserId() { return userId; }
   *
   * public void setUserId(final Long userId) { this.userId = userId; }
   */

  public Integer getRole() {
    return role;
  }

  public void setRole(final Integer role) {
    this.role = role;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
  }

}
