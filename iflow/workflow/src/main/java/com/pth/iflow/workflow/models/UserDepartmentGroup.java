package com.pth.iflow.workflow.models;

import com.pth.iflow.common.enums.EUserDepartmentMemberType;

public class UserDepartmentGroup {

  private String departmentGroupIdentity;

  private EUserDepartmentMemberType memberType;

  public UserDepartmentGroup() {

  }

  public UserDepartmentGroup(final String departmentGroupIdentity, final EUserDepartmentMemberType memberType) {

    this.departmentGroupIdentity = departmentGroupIdentity;
    this.memberType = memberType;
  }

  public UserDepartmentGroup(final String departmentGroupIdentity, final int memberType) {

    this.departmentGroupIdentity = departmentGroupIdentity;
    this.memberType = EUserDepartmentMemberType.ofValue(memberType);
  }

  public String getDepartmentGroupIdentity() {

    return departmentGroupIdentity;
  }

  public void setDepartmentGroupIdentity(final String departmentGroupIdentity) {

    this.departmentGroupIdentity = departmentGroupIdentity;
  }

  public EUserDepartmentMemberType getMemberType() {

    return memberType;
  }

  public void setMemberType(final EUserDepartmentMemberType memberType) {

    this.memberType = memberType;
  }

  public void setMemberType(final int memberType) {

    this.memberType = EUserDepartmentMemberType.ofValue(memberType);
  }

  // EUserDepartmentAssignType
}
