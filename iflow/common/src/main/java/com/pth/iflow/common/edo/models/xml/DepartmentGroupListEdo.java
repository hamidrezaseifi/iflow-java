package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DepartmentGroupListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentGroupListEdo {

  @XmlElementWrapper(name = "DepartmentGroupList")
  @XmlElement(name = "DepartmentGroupEdo")
  private final List<DepartmentGroupEdo> departmentGroups = new ArrayList<>();

  public DepartmentGroupListEdo() {

  }

  public DepartmentGroupListEdo(final List<DepartmentGroupEdo> departments) {
    setDepartmentGroups(departments);
  }

  public List<DepartmentGroupEdo> getDepartmentGroups() {
    return departmentGroups;
  }

  public void setDepartmentGroups(final List<DepartmentGroupEdo> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

}
