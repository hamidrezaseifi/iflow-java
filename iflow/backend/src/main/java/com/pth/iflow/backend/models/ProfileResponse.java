package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class ProfileResponse {

  private BackendUser  user;

  private BackendCompany company;

  private String  sessionid;

  public ProfileResponse() {
    this.user = null;
    this.company = null;
    this.sessionid = "";
  }

  public ProfileResponse(final BackendUser user, final BackendCompany company, final String sessionid) {
    this.user = user;
    this.company = company;
    this.sessionid = sessionid;
  }

  public BackendUser getUser() {
    return this.user;
  }

  public void setUser(final BackendUser user) {
    this.user = user;
  }

  public BackendCompany getCompany() {
    return this.company;
  }

  public void setCompany(final BackendCompany company) {
    this.company = company;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

  public ProfileResponseEdo toEdo() {

    final ProfileResponseEdo edo = new ProfileResponseEdo(this.user.toEdo(), this.company.toEdo(), this.sessionid);

    return edo;
  }

  public static ProfileResponse fromEdo(final ProfileResponseEdo edo) {
    final ProfileResponse model = new ProfileResponse(new BackendUser().fromEdo(edo.getUser()), new BackendCompany().fromEdo(edo.getCompany()),
        edo.getSessionid());
    return model;
  }

}
