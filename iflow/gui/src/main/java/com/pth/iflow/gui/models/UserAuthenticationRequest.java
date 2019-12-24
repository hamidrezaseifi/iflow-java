package com.pth.iflow.gui.models;

import com.pth.iflow.common.models.edo.UserAuthenticationRequestEdo;

public class UserAuthenticationRequest {

  private String email;

  private String password;

  private String companyIdentity;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  public UserAuthenticationRequestEdo toEdo1() {
    final UserAuthenticationRequestEdo edo = new UserAuthenticationRequestEdo();
    edo.setCompanyIdentity(this.companyIdentity);
    edo.setEmail(this.email);
    edo.setPassword(this.password);

    return edo;
  }

  public static UserAuthenticationRequest fromEdo1(final UserAuthenticationRequestEdo edo) {
    final UserAuthenticationRequest model = new UserAuthenticationRequest();
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setEmail(edo.getEmail());
    model.setPassword(edo.getPassword());

    return model;
  }

}
