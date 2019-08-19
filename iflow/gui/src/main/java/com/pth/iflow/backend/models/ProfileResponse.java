package com.pth.iflow.backend.models;

import java.util.List;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class ProfileResponse {

  private GuidUser user;

  private GuiCompanyProfile companyProfile;

  private String sessionid;

  public ProfileResponse() {
    this.user = null;
    this.companyProfile = null;
    this.sessionid = "";
  }

  public ProfileResponse(final GuidUser user, final GuiCompanyProfile companyProfile, final String sessionid) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.sessionid = sessionid;
  }

  public ProfileResponse(final GuidUser user,
                         final GuiCompany company,
                         final List<GuiDepartment> departments,
                         final List<GuiUserGroup> userGroups,
                         final String sessionid) {
    this.user = user;
    this.companyProfile = new GuiCompanyProfile(company, departments, userGroups);
    this.sessionid = sessionid;
  }

  public GuidUser getUser() {
    return this.user;
  }

  public void setUser(final GuidUser user) {
    this.user = user;
  }

  public GuiCompanyProfile getCompanyProfile() {
    return this.companyProfile;
  }

  public void setCompanyProfile(final GuiCompanyProfile companyProfile) {
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

  public static ProfileResponse fromEdo(final ProfileResponseEdo edo) {

    return new ProfileResponse(new GuidUser().fromEdo(edo.getUser()),
                               new GuiCompanyProfile().fromEdo(edo.getCompanyProfile()),
                               edo.getSessionid());
  }

}
