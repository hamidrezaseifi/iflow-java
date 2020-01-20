package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.pth.iflow.common.enums.EUserDepartmentMemberType;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "user_departments")
@EntityListeners(EntityListener.class)
public class UserDepartmentEntity {

  @EmbeddedId
  private UserDepartmentId id;

  @Column(name = "member_type")
  private int memberType;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("department_id")
  @JoinColumn(
              name = "department_id", referencedColumnName = "id"
  )
  private DepartmentEntity department;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("userId")
  private UserEntity user;

  // @ManyToOne
  // @JoinColumn(name = "user_id", insertable = false, updatable = false)
  // @JoinColumn(name = "id.user_id", insertable = false, updatable = false)
  // @Fetch(FetchMode.JOIN)
  // private UserEntity user;

  public UserDepartmentEntity() {

  }

  public UserDepartmentEntity(final boolean createId) {

    if (createId) {
      id = new UserDepartmentId();
    }
  }

  public UserDepartmentId getId() {

    return id;
  }

  public void setId(final UserDepartmentId id) {

    this.id = id;
  }

  public EUserDepartmentMemberType getMemberType() {

    return EUserDepartmentMemberType.ofValue(memberType);
  }

  public void setMemberType(final int memberType) {

    this.memberType = memberType;
  }

  public void setMemberType(final EUserDepartmentMemberType memberType) {

    this.memberType = memberType.getValue();
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

  public UserEntity getUser() {

    return user;
  }

  public void setUser(final UserEntity user) {

    this.user = user;
  }

  // EUserDepartmentAssignType
}
