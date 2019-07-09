package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserAuthenticationRequestEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAuthenticationRequestEdo {

  @NotNull
  @XmlElement(name = "Email")
  private String email;

  @NotNull
  @XmlElement(name = "Password")
  private String password;

  @NotNull
  @XmlElement(name = "CompanyIdentity")
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
