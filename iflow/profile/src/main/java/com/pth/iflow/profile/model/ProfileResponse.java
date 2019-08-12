package com.pth.iflow.profile.model;

import java.util.List;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class ProfileResponse {

  private User user;

  private CompanyProfile companyProfile;

  private String sessionid;

  public ProfileResponse() {
    this.user = null;
    this.companyProfile = null;
    this.sessionid = "";
  }

  public ProfileResponse(final User user, final CompanyProfile companyProfile, final String sessionid) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.sessionid = sessionid;
  }

  public ProfileResponse(final User user,
                         final Company company,
                         final List<Department> departments,
                         final List<UserGroup> userGroups,
                         final String sessionid) {
    this.user = user;
    this.companyProfile = new CompanyProfile(company, departments, userGroups);
    this.sessionid = sessionid;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
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

  public ProfileResponseEdo toEdo() {

    return new ProfileResponseEdo(this.user.toEdo(), this.companyProfile.toEdo(), this.sessionid);
  }

}
