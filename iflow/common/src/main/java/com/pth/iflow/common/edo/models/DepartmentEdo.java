package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

public class DepartmentEdo {
  private Long id;
  private Long companyId;
  private String title;
  private Integer status;
  private final Set<Integer> groups = new HashSet<>();

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

  public Set<Integer> getGroups() {
    return groups;
  }

  public void setGroups(final Set<Integer> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final Integer groupId) {
    this.groups.add(groupId);
  }
}
