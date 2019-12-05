package com.pth.iflow.core.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_usergroup")
public class UserUserGroupEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  UserUserGroupKey          id;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date              createdAt;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "user_group")
  private UserGroupEntity   userGroup;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "user_id")
  private UserEntity        userEntity;

  public UserUserGroupEntity() {
    // id = new UserUserGroupKey();

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
    this.id.userGroup = userGroup.getId();
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(final UserEntity userEntity) {
    this.userEntity = userEntity;
    this.id.userId = userEntity.getId();
  }

}
