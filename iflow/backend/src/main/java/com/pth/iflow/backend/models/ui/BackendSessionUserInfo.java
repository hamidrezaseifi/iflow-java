package com.pth.iflow.backend.models.ui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.pth.iflow.backend.models.BackendCompanyProfile;
import com.pth.iflow.backend.models.BackendUser;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class BackendSessionUserInfo {

  public static String          SESSION_LOGGEDUSERINFO_KEY = "mdm-session-user";

  private Date                  loginTime;
  private BackendUser           user;
  private BackendCompanyProfile companyProfile;

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

  public BackendSessionUserInfo() {
    this.loginTime = new Date();
  }

  public BackendSessionUserInfo(final BackendUser user, final BackendCompanyProfile companyProfile) {
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

  public BackendUser getUser() {
    return this.user;
  }

  public void setUser(final BackendUser user) {
    this.user = user;
  }

  public BackendCompanyProfile getCompanyProfil() {
    return this.companyProfile;
  }

  public void setCompanyProfil(final BackendCompanyProfile companyProfile) {
    this.companyProfile = companyProfile;
  }

  public String getUserTitle() {
    return this.user.getUserTitle();
  }

}
