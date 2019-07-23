package com.pth.iflow.profile.model;

import com.pth.iflow.common.edo.models.xml.UserAuthenticationRequestEdo;

public class UserAuthenticationRequest {
  private String email;
  private String password;
  private String companyIdentity;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getCompanyIdentity() {
    return companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  public UserAuthenticationRequestEdo toEdo() {
    final UserAuthenticationRequestEdo edo = new UserAuthenticationRequestEdo();
    edo.setCompanyIdentity(companyIdentity);
    edo.setEmail(email);
    edo.setPassword(password);

    return edo;
  }

  public static UserAuthenticationRequest fromEdo(final UserAuthenticationRequestEdo edo) {
    final UserAuthenticationRequest user = new UserAuthenticationRequest();

    user.setCompanyIdentity(edo.getCompanyIdentity());
    user.setEmail(edo.getEmail());
    user.setPassword(edo.getPassword());

    return user;
  }
}
