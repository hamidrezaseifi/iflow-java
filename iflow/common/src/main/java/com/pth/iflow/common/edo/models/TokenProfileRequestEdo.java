package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TokenProfileRequestEdo")
@XmlAccessorType(XmlAccessType.FIELD)
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
