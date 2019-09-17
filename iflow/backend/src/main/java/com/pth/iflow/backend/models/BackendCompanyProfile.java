package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

public class BackendCompanyProfile {

  private BackendCompany company;

  private final List<BackendDepartment> departments = new ArrayList<>();

  private final List<BackendUserGroup> userGroups = new ArrayList<>();

  public BackendCompanyProfile() {

  }

  public BackendCompanyProfile(final BackendCompany company,
                               final List<BackendDepartment> departments,
                               final List<BackendUserGroup> userGroups) {
    this.setDepartments(departments);
    this.setUserGroups(userGroups);
    this.setCompany(company);

  }

  /**
   * @return the company
   */
  public BackendCompany getCompany() {
    return this.company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final BackendCompany company) {
    this.company = company;
  }

  public List<BackendDepartment> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final List<BackendDepartment> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public List<BackendUserGroup> getUserGroups() {
    return this.userGroups;
  }

  public void setUserGroups(final List<BackendUserGroup> users) {
    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

}
