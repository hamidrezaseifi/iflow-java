package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TokenProfileRequestEdo")
public class TokenProfileRequestEdo {

  @NotNull
  @XmlElement(name = "Token")
  private String token;

  public String getToken() {
    return this.token;
  }

  public void setToken(final String tocken) {
    this.token = tocken;
  }

}
