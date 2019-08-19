package com.pth.iflow.backend.models;

import java.util.List;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class GuiProfileResponse {

  private GuiUser user;

  private GuiCompanyProfile companyProfile;

  private String sessionid;

  public GuiProfileResponse() {
    this.user = null;
    this.companyProfile = null;
    this.sessionid = "";
  }

  public GuiProfileResponse(final GuiUser user, final GuiCompanyProfile companyProfile, final String sessionid) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.sessionid = sessionid;
  }

  public GuiProfileResponse(final GuiUser user,
                         final GuiCompany company,
                         final List<GuiDepartment> departments,
                         final List<GuiUserGroup> userGroups,
                         final String sessionid) {
    this.user = user;
    this.companyProfile = new GuiCompanyProfile(company, departments, userGroups);
    this.sessionid = sessionid;
  }

  public GuiUser getUser() {
    return this.user;
  }

  public void setUser(final GuiUser user) {
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

  public static GuiProfileResponse fromEdo(final ProfileResponseEdo edo) {

    return new GuiProfileResponse(new GuiUser().fromEdo(edo.getUser()),
                               new GuiCompanyProfile().fromEdo(edo.getCompanyProfile()),
                               edo.getSessionid());
  }

}
