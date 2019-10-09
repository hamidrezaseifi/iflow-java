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

@XmlRootElement(name = "Department", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "Department" + IFlowJaxbDefinition.TYPE_PREFIX)
public class DepartmentEdo {

  @XmlElement(name = "Identity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                        identity;

  @NotNull
  @XmlElement(name = "Title", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                        title;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer                       status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer                       version;

  @NotNull
  @XmlElementWrapper(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentGroup", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<DepartmentGroupEdo> departmentGroups = new HashSet<>();

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Set<DepartmentGroupEdo> getDepartmentGroups() {
    return this.departmentGroups;
  }

  @JsonSetter
  public void setDepartmentGroups(final Set<DepartmentGroupEdo> groups) {
    this.departmentGroups.clear();
    if (groups != null) {
      this.departmentGroups.addAll(groups);
    }
  }

}
