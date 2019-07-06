package com.pth.iflow.common.edo.models;

public class ProfileResponseEdo {
  private UserEdo user;
  private CompanyEdo company;
  private String sessionid;

  public ProfileResponseEdo() {
    this.user = null;
    this.company = null;
    this.sessionid = "";
  }

  public ProfileResponseEdo(final UserEdo user, final CompanyEdo company, final String sessionid) {
    this.user = user;
    this.company = company;
    this.sessionid = sessionid;
  }

  public UserEdo getUser() {
    return user;
  }

  public void setUser(final UserEdo user) {
    this.user = user;
  }

  public CompanyEdo getCompany() {
    return company;
  }

  public void setCompany(final CompanyEdo company) {
    this.company = company;
  }

  public String getSessionid() {
    return sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

}
