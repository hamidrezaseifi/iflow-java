package com.pth.iflow.backend.models.ui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.pth.iflow.backend.models.GuiCompanyProfile;
import com.pth.iflow.backend.models.GuidUser;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class GuiSessionUserInfo {

  public static String          SESSION_LOGGEDUSERINFO_KEY = "mdm-session-user";

  private Date                  loginTime;
  private GuidUser           user;
  private GuiCompanyProfile companyProfile;
  private String                token;
  private String                sessionId;

  @Value("${server.session.timeout}")
  private int                   sessionTimeOut;

  public boolean isLoggedIn() {
    return (this.user != null) && (this.companyProfile != null);
  }

  public boolean isValid() {

    return this.isLoggedIn() && this.isNotOld();
  }

  public boolean isNotOld() {

    final Date current = new Date();
    long diff = current.getTime() - this.loginTime.getTime();
    diff /= 1000;

    return diff <= this.sessionTimeOut;
  }

  public GuiSessionUserInfo() {
    this.loginTime = new Date();
  }

  public GuiSessionUserInfo(final GuidUser user, final GuiCompanyProfile companyProfile) {
    this.user = user;
    this.companyProfile = companyProfile;
    this.loginTime = new Date();

  }

  public Date getLoginTime() {
    return this.loginTime;
  }

  public void setLoginTime(final Date loggedDate) {
    this.loginTime = loggedDate;
  }

  public void update() {
    this.loginTime = new Date();
  }

  public GuidUser getUser() {
    return this.user;
  }

  public void setUser(final GuidUser user) {
    this.user = user;
  }

  public String getUserTitle() {
    return this.user.getUserTitle();
  }

  public GuiCompanyProfile getCompanyProfile() {
    return this.companyProfile;
  }

  public String getToken() {
    return this.token;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public void setCompanyProfile(final GuiCompanyProfile companyProfile) {
    this.companyProfile = companyProfile;
  }

  public void setToken(final String token) {
    this.token = token;
  }

  public void setSessionId(final String sessionId) {
    this.sessionId = sessionId;
  }

}
