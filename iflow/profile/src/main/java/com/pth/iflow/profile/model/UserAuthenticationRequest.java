package com.pth.iflow.profile.model;

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

}
