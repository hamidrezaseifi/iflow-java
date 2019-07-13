package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DepartmentListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentListEdo {

  @XmlElementWrapper(name = "DepartmentList")
  @XmlElement(name = "DepartmentEdo")
  private final List<DepartmentEdo> departments = new ArrayList<>();

  public DepartmentListEdo() {

  }

  public DepartmentListEdo(final List<DepartmentEdo> departments) {
    setDepartments(departments);
  }

  public List<DepartmentEdo> getDepartments() {
    return departments;
  }

  public void setDepartments(final List<DepartmentEdo> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

}
