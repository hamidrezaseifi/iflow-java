package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AuthenticatedProfileRequestEdo")
public class AuthenticatedProfileRequestEdo {

  @NotNull
  @XmlElement(name = "Email")
  private String email;

  @NotNull
  @XmlElement(name = "Token")
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
