package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

public class CompanyProfile {

  private Company                company;

  private final List<Department> departments = new ArrayList<>();

  private final List<UserGroup>  userGroups  = new ArrayList<>();

  public CompanyProfile() {

  }

  public CompanyProfile(final Company company, final List<Department> departments, final List<UserGroup> userGroups) {
    this.setDepartments(departments);
    this.setUserGroups(userGroups);
    this.setCompany(company);

  }

  /**
   * @return the company
   */
  public Company getCompany() {
    return this.company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final Company company) {
    this.company = company;
  }

  public List<Department> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final List<Department> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public List<UserGroup> getUserGroups() {
    return this.userGroups;
  }

  public void setUserGroups(final List<UserGroup> users) {
    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

  public Integer getVersion() {
    return null;
  }

  public Long getId() {
    return null;
  }

  public void setVersion(final Integer version) {

  }

}
