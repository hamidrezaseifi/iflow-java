package com.pth.iflow.backend.models;

import java.util.List;

public class ProfileResponse {

  private BackendUser user;

  private BackendCompanyProfile companyProfile;

  private String sessionid;

  public ProfileResponse() {
    this.user = null;
    this.companyProfile = null;
    this.sessionid = "";
  }

  public ProfileResponse(final BackendUser user, final BackendCompanyProfile companyProfile, final String sessionid) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.sessionid = sessionid;
  }

  public ProfileResponse(final BackendUser user,
                         final BackendCompany company,
                         final List<BackendDepartment> departments,
                         final List<BackendUserGroup> userGroups,
                         final String sessionid) {
    this.user = user;
    this.companyProfile = new BackendCompanyProfile(company, departments, userGroups);
    this.sessionid = sessionid;
  }

  public BackendUser getUser() {
    return this.user;
  }

  public void setUser(final BackendUser user) {
    this.user = user;
  }

  public BackendCompanyProfile getCompanyProfile() {
    return this.companyProfile;
  }

  public void setCompanyProfile(final BackendCompanyProfile companyProfile) {
    this.companyProfile = companyProfile;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

}
