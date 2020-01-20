package com.pth.iflow.common.models.edo;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.enums.EUserDepartmentMemberType;
import com.pth.iflow.common.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.models.validation.AEnumValueValidator;

@XmlRootElement(name = "UserDepartmentGroup", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserDepartmentGroup" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserDepartmentGroupEdo {

  @NotNull(message = "DepartmentGroupIdentity must not be null")
  @XmlElement(name = "DepartmentGroupIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String departmentGroupIdentity;

  @AEnumValueValidator(enumClazz = EUserDepartmentMemberType.class)
  @NotNull(message = "MemberType must not be null")
  @XmlElement(name = "MemberType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private int memberType;

  public UserDepartmentGroupEdo() {

  }

  public UserDepartmentGroupEdo(final String departmentGroupIdentity, final int memberType) {

    this.departmentGroupIdentity = departmentGroupIdentity;
    this.memberType = memberType;
  }

  public String getDepartmentGroupIdentity() {

    return this.departmentGroupIdentity;
  }

  public void setDepartmentGroupIdentity(final String departmentGroupIdentity) {

    this.departmentGroupIdentity = departmentGroupIdentity;
  }

  public int getMemberType() {

    return this.memberType;
  }

  public void setMemberType(final int memberType) {

    this.memberType = memberType;
  }

}
