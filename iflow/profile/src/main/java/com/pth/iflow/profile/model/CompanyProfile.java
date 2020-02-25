package com.pth.iflow.profile.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyProfile {

  private Company company;
  private final List<Department> departments = new ArrayList<>();
  private final List<UserGroup> userGroups = new ArrayList<>();
  private final List<CompanyWorkflowTypeController> workflowTypeControllers = new ArrayList<>();
  private final List<CompanyWorkflowtypeItemOcrSetting> workflowtypeItemOcrSettings = new ArrayList<>();

  public CompanyProfile() {

  }

  public CompanyProfile(final Company company, final List<Department> departments, final List<UserGroup> userGroups,
      final List<CompanyWorkflowTypeController> workflowTypeControllers,
      final List<CompanyWorkflowtypeItemOcrSetting> workflowtypeItemOcrSettings) {

    this.setDepartments(departments);
    this.setUserGroups(userGroups);
    this.setCompany(company);
    this.setWorkflowTypeControllers(workflowTypeControllers);
    this.setWorkflowtypeItemOcrSettings(workflowtypeItemOcrSettings);
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

  public List<CompanyWorkflowTypeController> getWorkflowTypeControllers() {

    return this.workflowTypeControllers;
  }

  public void setWorkflowTypeControllers(final List<CompanyWorkflowTypeController> workflowTypeControllers) {

    this.workflowTypeControllers.clear();
    if (workflowTypeControllers != null) {
      this.workflowTypeControllers.addAll(workflowTypeControllers);
    }
  }

  public List<CompanyWorkflowtypeItemOcrSetting> getWorkflowtypeItemOcrSettings() {

    return this.workflowtypeItemOcrSettings;
  }

  public void setWorkflowtypeItemOcrSettings(final List<CompanyWorkflowtypeItemOcrSetting> workflowtypeItemOcrSettings) {

    this.workflowtypeItemOcrSettings.clear();
    if (workflowtypeItemOcrSettings != null) {
      this.workflowtypeItemOcrSettings.addAll(workflowtypeItemOcrSettings);
    }
  }
}
