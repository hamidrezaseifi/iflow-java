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
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserGroup;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowTypeHandler;

@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionUserInfo {

  private static final Logger logger = LoggerFactory.getLogger(SessionUserInfo.class);

  public static String SESSION_LOGGEDUSERINFO_KEY = "mdm-session-user";

  private Date           loginTime;
  private User           user;
  private CompanyProfile companyProfile;
  private String         token;
  private String         sessionId;

  private final Map<String, IWorkflow> cachedWorkflow = new HashMap<>();

  private final Map<String, User> companyUsers = new HashMap<>();

  private final Map<String, WorkflowType> comapnyWorkflowTypes = new HashMap<>();

  @Value("${server.session.timeout}")
  private int sessionTimeOut;

  @Autowired
  IUserAccess userAccess;

  @Autowired
  IWorkflowTypeHandler workflowTypeHandler;

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

  public SessionUserInfo() {
    this.loginTime = new Date();
  }

  public SessionUserInfo(final User user, final CompanyProfile companyProfile) {
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

  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  public String getUserTitle() {
    return this.user.getUserTitle();
  }

  public CompanyProfile getCompanyProfile() {
    return this.companyProfile;
  }

  public String getToken() {
    return this.token;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public void setCompanyProfile(final CompanyProfile companyProfile) {
    this.companyProfile = companyProfile;
  }

  public void setToken(final String token) {
    this.token = token;
  }

  public void setSessionId(final String sessionId) {
    this.sessionId = sessionId;
  }

  /**
   * @return the companyUsers
   * @throws IFlowMessageConversionFailureException
   */
  public Map<String, User> getCompanyUsersMap() throws IFlowMessageConversionFailureException {
    if (this.companyUsers.size() == 0) {
      try {
        final List<User> userList = this.userAccess.getCompanyUserList(this.companyProfile.getCompany().getIdentity());
        this.companyUsers.putAll(userList.stream().collect(Collectors.toMap(u -> u.getEmail(), u -> u)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading company user list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.companyUsers;
  }

  public List<User> getCompanyUserList() throws IFlowMessageConversionFailureException {
    final Map<String, User> map = this.getCompanyUsersMap();

    return map.values().stream().collect(Collectors.toList());
  }

  /**
   * @return the workflowTypeMap
   * @throws IFlowMessageConversionFailureException
   */
  public Map<String, WorkflowType> getCompanyWorkflowTypes() throws IFlowMessageConversionFailureException {
    if (this.comapnyWorkflowTypes.size() == 0) {
      try {
        final List<WorkflowType> typeList = this.workflowTypeHandler.readWorkflowTypeList(this.companyProfile.getCompany().getIdentity(),
                                                                                          this.getToken());
        this.comapnyWorkflowTypes.putAll(typeList.stream().collect(Collectors.toMap(t -> t.getIdentity(), t -> t)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading company workflowtype list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.comapnyWorkflowTypes;
  }

  /**
   * @return the GuiWorkflowType
   * @throws IFlowMessageConversionFailureException
   */
  public WorkflowType getWorkflowTypeById(final String workflowTypId) throws IFlowMessageConversionFailureException {
    if (this.comapnyWorkflowTypes.size() == 0) {
      try {
        final List<WorkflowType> typeList = this.workflowTypeHandler.readWorkflowTypeList(this.companyProfile.getCompany().getIdentity(),
                                                                                          this.getToken());
        this.comapnyWorkflowTypes.putAll(typeList.stream().collect(Collectors.toMap(t -> t.getIdentity(), t -> t)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading company workflowtype: {} \n {}", e.getMessage(), e);
      }
    }

    return this.comapnyWorkflowTypes.containsKey(workflowTypId) ? this.comapnyWorkflowTypes.get(workflowTypId) : null;
  }

  /**
   * @return the GuiUser
   * @throws IFlowMessageConversionFailureException
   */
  public User getUserByIdentity(final String userId) throws IFlowMessageConversionFailureException {
    if (this.companyUsers.size() == 0) {
      try {
        final List<User> userList = this.userAccess.getCompanyUserList(this.companyProfile.getCompany().getIdentity());
        this.companyUsers.putAll(userList.stream().collect(Collectors.toMap(u -> u.getIdentity(), u -> u)));
      }
      catch (GuiCustomizedException | MalformedURLException e) {
        logger.error("error in reading user list: {} \n {}", e.getMessage(), e);
      }
    }

    return this.companyUsers.containsKey(userId) ? this.companyUsers.get(userId) : null;
  }

  // Map<String, GuiWorkflow> cachedWorkflow

  public void addCachedWorkflow(final IWorkflow workflow) {
    this.cachedWorkflow.put(workflow.getIdentity(), workflow);
  }

  public boolean hasCachedWorkflowIdentity(final String identity) {
    return this.cachedWorkflow.containsKey(identity);
  }

  public IWorkflow getCachedWorkflow(final String identity) {
    return this.cachedWorkflow.get(identity);
  }

  public Company getCompany() {
    return this.companyProfile.getCompany();
  }

  public List<Department> getCompanyDepartments() {
    return this.companyProfile.getDepartments();
  }

  public List<UserGroup> getCompanyUserGroups() {
    return this.companyProfile.getUserGroups();
  }

}
