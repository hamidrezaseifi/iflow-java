package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.xml.UserAuthenticationRequestEdo;

public class GuiUserAuthenticationRequest {

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

  public static GuiUserAuthenticationRequest fromEdo1(final UserAuthenticationRequestEdo edo) {
    final GuiUserAuthenticationRequest model = new GuiUserAuthenticationRequest();
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setEmail(edo.getEmail());
    model.setPassword(edo.getPassword());

    return model;
  }

}
