package com.pth.iflow.backend.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.pth.iflow.backend.configurations.GuiSecurityConfigurations;

public class GuiAuthenticationDetails extends WebAuthenticationDetails {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private final String      companyid;

  public GuiAuthenticationDetails(final HttpServletRequest request) {
    super(request);
    this.companyid = request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME);
  }

  /**
   * @return the companyid
   */
  public String getCompanyid() {
    return this.companyid;
  }

}
