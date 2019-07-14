package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "DepartmentList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "DepartmentList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class DepartmentListEdo {

  @XmlElementWrapper(name = "DepartmentList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentEdo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<DepartmentEdo> departments = new ArrayList<>();

  public DepartmentListEdo() {

  }

  public DepartmentListEdo(final List<DepartmentEdo> departments) {
    this.setDepartments(departments);
  }

  public List<DepartmentEdo> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final List<DepartmentEdo> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

}
