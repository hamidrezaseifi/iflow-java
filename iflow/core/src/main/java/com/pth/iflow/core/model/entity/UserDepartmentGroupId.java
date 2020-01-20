package com.pth.iflow.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDepartmentGroupId implements Serializable {

  private static final long serialVersionUID = -8145078865168698030L;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "department_group_id")
  private Long departmentGroupId;

  public UserDepartmentGroupId() {

  }

  public UserDepartmentGroupId(final Long userId, final Long departmentGroupId) {

    this.userId = userId;
    this.departmentGroupId = departmentGroupId;
  }

  public Long getUserId() {

    return userId;
  }

  public void setUserId(final Long userId) {

    this.userId = userId;
  }

  public Long getDepartmentGroupId() {

    return departmentGroupId;
  }

  public void setDepartmentGroupId(final Long departmentGroupId) {

    this.departmentGroupId = departmentGroupId;
  }

  @Override
  public boolean equals(final Object o) {

    if (this == o) {
      return true;
    }
    if (!(o instanceof UserDepartmentGroupId)) {
      return false;
    }
    final UserDepartmentGroupId that = (UserDepartmentGroupId) o;
    return Objects.equals(getDepartmentGroupId(), that.getDepartmentGroupId()) && Objects.equals(getUserId(), that.getUserId());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getUserId(), getDepartmentGroupId());
  }

}
