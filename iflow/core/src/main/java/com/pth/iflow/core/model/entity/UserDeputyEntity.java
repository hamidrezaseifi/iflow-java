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
@Table(name = "user_deputy")
public class UserDeputyEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_id")
  private Long              userId;

  @Id
  @Column(name = "deputy_id")
  private Long              deputyId;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date              createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deputy_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity        deputy;

  public UserDeputyEntity() {
    deputy = new UserEntity();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public Long getDeputyId() {
    return deputyId;
  }

  public void setDeputyId(final Long deputyId) {
    this.deputyId = deputyId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public UserEntity getDeputy() {
    return deputy;
  }

  public void setDeputy(final UserEntity deputy) {
    this.deputy = deputy;
  }

}
