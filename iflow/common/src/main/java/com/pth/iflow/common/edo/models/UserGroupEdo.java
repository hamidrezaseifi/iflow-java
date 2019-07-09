package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserGroupEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserGroupEdo {

  @XmlElement(name = "ID")
  private Long    id;

  @NotNull
  @XmlElement(name = "CompanyId")
  private Long    companyId;

  @NotNull
  @XmlElement(name = "Title")
  private String  title;

  @NotNull
  @XmlElement(name = "Status")
  private Integer status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer version;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return status;
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

}
