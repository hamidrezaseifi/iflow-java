package com.pth.ifow.workflow.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;

public class ProfileResponse extends ModelMapperBase<ProfileResponseEdo, ProfileResponse> {

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
    return this.user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  public Company getCompany() {
    return this.company;
  }

  public void setCompany(final Company company) {
    this.company = company;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

  @Override
  public Integer getVersion() {

    return 0;
  }

  @Override
  public Long getId() {
    return null;
  }

  @Override
  public void setVersion(final Integer version) {

  }

  @Override
  public ProfileResponseEdo toEdo() {

    final ProfileResponseEdo edo = new ProfileResponseEdo(this.user.toEdo(), this.company.toEdo(), this.sessionid);

    return edo;
  }

  @Override
  public ProfileResponse fromEdo(final ProfileResponseEdo edo) {
    final ProfileResponse model = new ProfileResponse(new User().fromEdo(edo.getUser()), new Company().fromEdo(edo.getCompany()),
        edo.getSessionid());
    return model;
  }

}
