package com.pth.iflow.common.edo.models;

public class AuthenticatedProfileRequestEdo {
  private String email;
  private String token;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(final String tocken) {
    this.token = tocken;
  }

}
