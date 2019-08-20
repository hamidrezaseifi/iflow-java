package com.pth.iflow.gui.models.ui;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiCompanyProfile;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowAccess;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class GuiSessionUserInfo {

  private static final Logger logger = LoggerFactory.getLogger(GuiSessionUserInfo.class);

  public static String SESSION_LOGGEDUSERINFO_KEY = "mdm-session-user";

  private Date              loginTime;
  private GuiUser           user;
  private GuiCompanyProfile companyProfile;
  private String            token;
  private String            sessionId;

  private final Map<Long, GuiUser> userMap = new HashMap<>();

  private final Map<Long, GuiWorkflowType> workflowTypeMap = new HashMap<>();

  @Value("${server.session.timeout}")
  private int sessionTimeOut;

  @Autowired
  IUserAccess userAccess;

  @Autowired
  IWorkflowAccess workflowAccess;

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

  public GuiSessionUserInfo(final GuiUser user, final GuiCompanyProfile companyProfile) {
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

  public GuiUser getUser() {
    return this.user;
  }

  public void setUser(final GuiUser user) {
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

  /**
   * @return the userMap
   */
  public Map<Long, GuiUser> getUserMap() {
    if (this.userMap.size() == 0) {
      try {
        final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.companyProfile.getCompany().getId());
        this.userMap.putAll(userList.stream().collect(Collectors.toMap(u -> u.getId(), u -> u)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading user list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.userMap;
  }

  /**
   * @return the workflowTypeMap
   */
  public Map<Long, GuiWorkflowType> getWorkflowTypeMap() {
    if (this.workflowTypeMap.size() == 0) {
      try {
        final List<GuiWorkflowType> typeList =
                                             this.workflowAccess.readWorkflowTypeList(this.companyProfile.getCompany().getId(), getToken());
        this.workflowTypeMap.putAll(typeList.stream().collect(Collectors.toMap(t -> t.getId(), t -> t)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading user list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.workflowTypeMap;
  }

  /**
   * @return the workflowTypeMap
   */
  public GuiWorkflowType getWorkflowTypeById(final Long workflowTypId) {
    if (this.workflowTypeMap.size() == 0) {
      try {
        final List<GuiWorkflowType> typeList =
                                             this.workflowAccess.readWorkflowTypeList(this.companyProfile.getCompany().getId(), getToken());
        this.workflowTypeMap.putAll(typeList.stream().collect(Collectors.toMap(t -> t.getId(), t -> t)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading user list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.workflowTypeMap.containsKey(workflowTypId) ? this.workflowTypeMap.get(workflowTypId) : null;
  }

}
