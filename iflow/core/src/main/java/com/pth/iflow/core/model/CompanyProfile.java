package com.pth.iflow.core.model;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;

public class CompanyProfile {

  private CompanyEntity company;
  private final List<DepartmentEntity> departments = new ArrayList<>();
  private final List<UserGroupEntity> userGroups = new ArrayList<>();
  private final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> workflowtypeItemOcrSettings = new ArrayList<>();

  // CompanyWorkflowtypeItemOcrSettingEntity
  public CompanyProfile() {

  }

  public CompanyProfile(final CompanyEntity company, final List<DepartmentEntity> departments,
      final List<UserGroupEntity> userGroups, final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> workflowtypeItemOcrSettings) {

    this.setDepartments(departments);
    this.setUserGroups(userGroups);
    this.setCompany(company);
    this.setWorkflowtypeItemOcrSettings(workflowtypeItemOcrSettings);
  }

  /**
   * @return the company
   */
  public CompanyEntity getCompany() {

    return this.company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final CompanyEntity company) {

    this.company = company;
  }

  public List<DepartmentEntity> getDepartments() {

    return this.departments;
  }

  public void setDepartments(final List<DepartmentEntity> departments) {

    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public List<UserGroupEntity> getUserGroups() {

    return this.userGroups;
  }

  public void setUserGroups(final List<UserGroupEntity> users) {

    this.userGroups.clear();
    if (users != null) {
      this.userGroups.addAll(users);
    }
  }

  public List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> getWorkflowtypeItemOcrSettings() {

    return workflowtypeItemOcrSettings;
  }

  public void setWorkflowtypeItemOcrSettings(final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> workflowtypeItemOcrSettings) {

    this.workflowtypeItemOcrSettings.clear();
    if (workflowtypeItemOcrSettings != null) {
      this.workflowtypeItemOcrSettings.addAll(workflowtypeItemOcrSettings);
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
