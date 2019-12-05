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
@Table(name = "user_usergroup")
public class UserUserGroupEntity implements Serializable {

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
  @Column(name = "user_group")
  private Long userGroupId;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_group", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserGroupEntity userGroup;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity userEntity;

  public UserUserGroupEntity() {

  }

  /*
   * public Long getUserId() { return userId; }
   *
   * public void setUserId(final Long userId) { this.userId = userId; }
   */

  public Long getUserGroupId() {
    return userGroupId;
  }

  public void setUserGroupId(final Long userGroupId) {
    this.userGroupId = userGroupId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public UserGroupEntity getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(final UserGroupEntity userGroup) {
    this.userGroup = userGroup;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
  }

}
