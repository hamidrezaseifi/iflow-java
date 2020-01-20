package com.pth.iflow.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDepartmentId implements Serializable {

  private static final long serialVersionUID = -8145078865168698030L;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "department_id")
  private Long departmentId;

  public UserDepartmentId() {

  }

  public UserDepartmentId(final Long userId, final Long departmentId) {

    this.userId = userId;
    this.departmentId = departmentId;
  }

  public Long getUserId() {

    return userId;
  }

  public void setUserId(final Long userId) {

    this.userId = userId;
  }

  public Long getDepartmentId() {

    return departmentId;
  }

  public void setDepartmentId(final Long departmentId) {

    this.departmentId = departmentId;
  }

  @Override
  public boolean equals(final Object o) {

    if (this == o) {
      return true;
    }
    if (!(o instanceof UserDepartmentId)) {
      return false;
    }
    final UserDepartmentId that = (UserDepartmentId) o;
    return Objects.equals(getDepartmentId(), that.getDepartmentId()) && Objects.equals(getUserId(), that.getUserId());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getUserId(), getDepartmentId());
  }

}
