package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyProfileEdo;

public class GuiCompanyProfile extends ModelMapperBase<CompanyProfileEdo, GuiCompanyProfile> {

  private GuiCompany company;

  private final List<GuiDepartment> departments = new ArrayList<>();

  private final List<GuiUserGroup> userGroups = new ArrayList<>();

  public GuiCompanyProfile() {

  }

  public GuiCompanyProfile(final GuiCompany company,
                               final List<GuiDepartment> departments,
                               final List<GuiUserGroup> userGroups) {
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

  @Override
  public Integer getVersion() {
    return null;
  }

  @Override
  public Long getId() {
    return null;
  }

  @Override
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
  public GuiCompanyProfile fromEdo(final CompanyProfileEdo edo) {
    final GuiCompanyProfile model = new GuiCompanyProfile(new GuiCompany().fromEdo(edo.getCompany()),
                                                                  new GuiDepartment().fromEdoList(edo.getDepartments()),
                                                                  new GuiUserGroup().fromEdoList(edo.getUserGroups()));

    return model;
  }

}
