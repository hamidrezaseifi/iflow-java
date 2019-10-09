package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "DepartmentGroupList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class DepartmentGroupListEdo {

  @NotNull
  @XmlElementWrapper(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentGroup")
  private final Set<DepartmentGroupEdo> departmentGroups = new HashSet<>();

  public DepartmentGroupListEdo() {

  }

  public DepartmentGroupListEdo(final Set<DepartmentGroupEdo> departments) {
    this.setDepartmentGroups(departments);
  }

  public Set<DepartmentGroupEdo> getDepartmentGroups() {
    return this.departmentGroups;
  }

  @JsonSetter
  public void setDepartmentGroups(final Set<DepartmentGroupEdo> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

}
