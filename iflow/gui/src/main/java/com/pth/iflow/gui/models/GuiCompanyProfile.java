package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

public class GuiCompanyProfile {

  private GuiCompany                company;

  private final List<GuiDepartment> departments = new ArrayList<>();

  private final List<GuiUserGroup>  userGroups  = new ArrayList<>();

  public GuiCompanyProfile() {

  }

  public GuiCompanyProfile(final GuiCompany company, final List<GuiDepartment> departments, final List<GuiUserGroup> userGroups) {
    this.setDepartments(departments);
    this.setUserGroups(userGroups);
    this.setCompany(company);

  }

  /**
   * @return the company
   */
  public GuiCompany getCompany() {
    return this.company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final GuiCompany company) {
    this.company = company;
  }

  public List<GuiDepartment> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final List<GuiDepartment> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public List<GuiUserGroup> getUserGroups() {
    return this.userGroups;
  }

  public void setUserGroups(final List<GuiUserGroup> users) {
    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

}
