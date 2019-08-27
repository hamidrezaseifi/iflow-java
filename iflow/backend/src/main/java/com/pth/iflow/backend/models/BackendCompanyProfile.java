package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyProfileEdo;

public class BackendCompanyProfile extends ModelMapperBase<CompanyProfileEdo, BackendCompanyProfile> {

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

  public Integer getVersion() {
    return null;
  }

  public Long getId() {
    return null;
  }

  public void setVersion(final Integer version) {

  }

  @Override
  public CompanyProfileEdo toEdo() {
    final CompanyProfileEdo edo = new CompanyProfileEdo(this.company.toEdo(),
                                                        ModelMapperBase.toEdoList(this.departments),
                                                        ModelMapperBase.toEdoList(this.userGroups));
    return edo;
  }

  @Override
  public BackendCompanyProfile fromEdo(final CompanyProfileEdo edo) {
    final BackendCompanyProfile model = new BackendCompanyProfile(new BackendCompany().fromEdo(edo.getCompany()),
                                                                  new BackendDepartment().fromEdoList(edo.getDepartments()),
                                                                  new BackendUserGroup().fromEdoList(edo.getUserGroups()));

    return model;
  }

}
