package com.pth.iflow.backend.models.ui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.pth.iflow.backend.models.BackendCompany;
import com.pth.iflow.backend.models.BackendUser;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class BackendSessionUserInfo {

  public static String   SESSION_LOGGEDUSERINFO_KEY = "mdm-session-user";

  private Date           loginTime;
  private BackendUser    user;
  private BackendCompany company;

  @Value("${server.session.timeout}")
  private int            sessionTimeOut;

  public boolean isLoggedIn() {
    return this.user != null && this.company != null;
  }

  public boolean isValid() {

    return this.isLoggedIn() && this.isNotOld();
  }

  public boolean isNotOld() {

    final Date currect = new Date();
    long diff = currect.getTime() - this.loginTime.getTime();
    diff /= 1000;

    return diff <= this.sessionTimeOut;
  }

  public BackendSessionUserInfo() {

  }

  public BackendSessionUserInfo(final BackendUser user, final BackendCompany company) {
    this.user = user;
    this.company = company;
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

  public BackendCompany getCompany() {
    return this.company;
  }

  public void setCompany(final BackendCompany company) {
    this.company = company;
  }

  public String getUserTitle() {
    return this.user.getUserTitle();
  }

}
