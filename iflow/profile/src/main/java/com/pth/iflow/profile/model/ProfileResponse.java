package com.pth.iflow.profile.model;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class ProfileResponse {

  private User    user;

  private Company company;

  private String  sessionid;

  public ProfileResponse() {
    this.user = null;
    this.company = null;
    this.sessionid = "";
  }

  public ProfileResponse(final User user, final Company company, final String sessionid) {
    this.user = user;
    this.company = company;
    this.sessionid = sessionid;
  }

  public User getUser() {
    return user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(final Company company) {
    this.company = company;
  }

  public String getSessionid() {
    return sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

  public ProfileResponseEdo toEdo() {

    return new ProfileResponseEdo(user.toEdo(), company.toEdo(), sessionid);
  }

}
