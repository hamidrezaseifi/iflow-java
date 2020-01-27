package com.pth.iflow.core.model.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.core.storage.dao.helper.EntityListener;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;

@Entity
@Table(name = "iflow_roles")
@EntityListeners(EntityListener.class)
public class IflowRoleEntity implements ICoreEntityVersion {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date updatedAt;

  @ManyToMany(mappedBy = "groups")
  private Set<UserEntity> users = new HashSet<>();

  public IflowRoleEntity() {

  }

  @Override
  public Long getId() {

    return this.id;
  }

  public void setId(final Long id) {

    this.id = id;
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
  public void increaseVersion() {

    version += 1;
  }

  public Set<UserEntity> getUsers() {

    return users;
  }

  public void setUsers(final Set<UserEntity> users) {

    this.users = users;
  }
}
