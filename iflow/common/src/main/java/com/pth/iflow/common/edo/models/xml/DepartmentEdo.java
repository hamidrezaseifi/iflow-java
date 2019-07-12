package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DepartmentEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentEdo {
  
  @XmlElement(name = "ID")
  private Long id;
  
  @NotNull
  @XmlElement(name = "CompanyId")
  private Long companyId;
  
  @NotNull
  @XmlElement(name = "Title")
  private String title;
  
  @NotNull
  @XmlElement(name = "Status")
  private Integer status;
  
  @NotNull
  @XmlElement(name = "Version")
  private Integer version;
  
  @XmlElementWrapper(name = "GroupList")
  @XmlElement(name = "Group")
  private final List<Long> groups = new ArrayList<>();
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public Long getCompanyId() {
    return this.companyId;
  }
  
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
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
  
  public List<Long> getGroups() {
    return this.groups;
  }
  
  public void setGroups(final List<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }
  
  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }
}
