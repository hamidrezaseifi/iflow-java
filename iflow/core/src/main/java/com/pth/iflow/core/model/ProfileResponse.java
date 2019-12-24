package com.pth.iflow.core.model;

import java.util.List;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;

public class ProfileResponse {

  private UserEntity     user;
  private CompanyProfile companyProfile;
  private String         sessionid;

  public ProfileResponse() {
    this.user = null;
    this.companyProfile = null;
    this.sessionid = "";
  }

  public ProfileResponse(final UserEntity user, final CompanyProfile companyProfile, final String sessionid) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.sessionid = sessionid;
  }

  public ProfileResponse(final UserEntity user, final CompanyEntity company, final List<DepartmentEntity> departments,
      final List<UserGroupEntity> userGroups, final String sessionid) {
    this.user = user;
    this.companyProfile = new CompanyProfile(company, departments, userGroups);
    this.sessionid = sessionid;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setUser(final UserEntity user) {
    this.user = user;
  }

  public CompanyProfile getCompanyProfile() {
    return this.companyProfile;
  }

  public void setCompanyProfile(final CompanyProfile companyProfile) {
    this.companyProfile = companyProfile;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

}
