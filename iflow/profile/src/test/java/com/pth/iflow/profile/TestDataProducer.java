package com.pth.iflow.profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.enums.ECompanyType;
import com.pth.iflow.common.enums.EOcrType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.models.edo.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetItemEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.TokenProfileRequestEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyProfile;
import com.pth.iflow.profile.model.CompanyWorkflowTypeController;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPresetItem;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserDepartment;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;

public class TestDataProducer {

  protected Company getTestCompany() {

    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setIdentity("identifyid");
    company.setStatus(1);
    company.setVersion(1);
    company.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.name());
    company.setCompanyTypeCustome("companyTypeCustome");

    return company;
  }

  protected CompanyProfile getTestCompanyProfile() {

    final CompanyProfile companyProfile = new CompanyProfile(this.getTestCompany(), this.getTestDepartmentList(),
        this.getTestUserGroupList(), this.getTestCompanyWorkflowTypeControllerList(),
        this.getTestCompanyWorkflowtypeItemOcrSettingPresetList());

    return companyProfile;
  }

  protected List<CompanyWorkflowTypeController> getTestCompanyWorkflowTypeControllerList() {

    final List<CompanyWorkflowTypeController> list = Arrays
        .asList(this.getTestCompanyWorkflowTypeController(),
            this.getTestCompanyWorkflowTypeController(), this.getTestCompanyWorkflowTypeController());

    return list;
  }

  protected List<CompanyWorkflowtypeItemOcrSettingPreset> getTestCompanyWorkflowtypeItemOcrSettingPresetList() {

    return Arrays
        .asList(this.getTestCompanyWorkflowtypeItemOcrSettingPreset("prop1"),
            this.getTestCompanyWorkflowtypeItemOcrSettingPreset("prop2"),
            this.getTestCompanyWorkflowtypeItemOcrSettingPreset("prop3"));
  }

  protected List<CompanyWorkflowtypeItemOcrSettingPresetEdo> getTestCompanyWorkflowtypeItemOcrSettingPresetEdoList() {

    return Arrays
        .asList(this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop1"),
            this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop2"),
            this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop3"));
  }

  protected CompanyWorkflowtypeItemOcrSettingPresetEdo getTestCompanyWorkflowtypeItemOcrSettingPresetEdo(final String presetName) {

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edo = new CompanyWorkflowtypeItemOcrSettingPresetEdo();
    edo.setCompanyIdentity("companyIdentity");
    edo.setStatus(1);
    edo.setPresetName(presetName);
    edo.setVersion(1);
    edo.setWorkflowTypeIdentity("workflowIdentity");
    edo.setIdentity("identity-" + presetName);
    edo
        .setItems(Arrays
            .asList(this.getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-1"),
                this.getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-2"),
                this.getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-3")));

    return edo;
  }

  protected CompanyWorkflowtypeItemOcrSettingPresetItemEdo getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo(final String propName) {

    final CompanyWorkflowtypeItemOcrSettingPresetItemEdo edo = new CompanyWorkflowtypeItemOcrSettingPresetItemEdo();
    edo.setPropertyName(propName);
    edo.setStatus(1);
    edo.setValue("value");
    edo.setVersion(1);
    edo.setOcrType(EOcrType.SEARCH_WORD.getValue());

    return edo;
  }

  protected CompanyWorkflowtypeItemOcrSettingPreset getTestCompanyWorkflowtypeItemOcrSettingPreset(final String presetName) {

    final CompanyWorkflowtypeItemOcrSettingPreset model = new CompanyWorkflowtypeItemOcrSettingPreset();
    model.setPresetName(presetName);
    model.setStatus(1);
    model.setVersion(1);
    model.setWorkflowTypeIdentity("workflowIdentity");
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity("identity-" + presetName);
    model
        .setItems(Arrays
            .asList(this.getTestCompanyWorkflowtypeItemOcrSettingPresetItem("prop-1"),
                this.getTestCompanyWorkflowtypeItemOcrSettingPresetItem("prop-2"),
                this.getTestCompanyWorkflowtypeItemOcrSettingPresetItem("prop-3")));

    return model;
  }

  protected CompanyWorkflowtypeItemOcrSettingPresetItem
      getTestCompanyWorkflowtypeItemOcrSettingPresetItem(final String propName) {

    final CompanyWorkflowtypeItemOcrSettingPresetItem edo = new CompanyWorkflowtypeItemOcrSettingPresetItem();
    edo.setPropertyName(propName);
    edo.setStatus(1);
    edo.setValue("value");
    edo.setVersion(1);
    edo.setOcrType(EOcrType.SEARCH_WORD.getValue());

    return edo;
  }

  protected CompanyWorkflowTypeController getTestCompanyWorkflowTypeController() {

    final CompanyWorkflowTypeController model = new CompanyWorkflowTypeController();
    model.setPriority(1);
    model.setUserIdentity("userIdentity");
    model.setWorkflowTypeIdentity("workflowTypeIdentity");

    return model;
  }

  protected User getTestUser() {

    final User model = new User();
    model.setCompanyIdentity("companyIdentity");
    model.setEmail("email");
    model.setBirthDate(LocalDate.now());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);

    model
        .setUserDepartments(Arrays
            .asList(this.getTestUserDepartment("departmentIdentity1"), this.getTestUserDepartment("departmentIdentity2"),
                this.getTestUserDepartment("departmentIdentity3")));
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity("test-identity");

    return model;
  }

  protected User getTestUser(final String fname, final String lname, final String email) {

    final User model = new User();
    model.setCompanyIdentity("companyIdentity");
    model.setCompanyIdentity("companyIdentity");
    model.setEmail(email);
    model.setBirthDate(LocalDate.now());
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setPermission(1);
    model.setVersion(1);

    model
        .setUserDepartments(Arrays
            .asList(this.getTestUserDepartment("departmentIdentity1"), this.getTestUserDepartment("departmentIdentity2"),
                this.getTestUserDepartment("departmentIdentity3")));
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setIdentity("identity" + email);
    return model;
  }

  private UserDepartment getTestUserDepartment(final String depIdentity) {

    final UserDepartment userDepartmentGroup = new UserDepartment();

    userDepartmentGroup.setDepartmentIdentity(depIdentity);

    userDepartmentGroup.setMemberType(5);
    return userDepartmentGroup;
  }

  protected List<User> getTestUserList() {

    final List<User> list = Arrays
        .asList(this.getTestUser("fname 1", "lname 1", "email 1"),
            this.getTestUser("fname 2", "lname 2", "email 2"), this.getTestUser("fname 3", "lname 3", "email 3"));

    return list;
  }

  protected UserGroup getTestUserGroup(final String identity, final String title) {

    final UserGroup model = new UserGroup();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected UserGroup getTestUserGroup() {

    final UserGroup model = new UserGroup();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity("identity");
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected List<UserGroup> getTestUserGroupList() {

    final List<UserGroup> list = Arrays
        .asList(this.getTestUserGroup("usergrp1", "UserGroup 1"),
            this.getTestUserGroup("usergrp2", "UserGroup 2"), this.getTestUserGroup("usergrp3", "UserGroup 3"));

    return list;
  }

  protected Department getTestDepartment(final String identity, final String title) {

    final Department model = new Department();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected UserAuthenticationSession getTestUserAuthenticationSession() {

    final UserAuthenticationSession model = new UserAuthenticationSession("email", "companyidentity",
        this.getSessionMaxAgeInSeconds());

    model.setSessionid("sessionid");
    model.setToken("token");

    return model;
  }

  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo() {

    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setUserIdentity("");
    model.setToken("token");

    return model;
  }

  protected TokenProfileRequestEdo getTokenProfileRequestEdo(final String email) {

    final TokenProfileRequestEdo model = new TokenProfileRequestEdo();
    model.setToken(email);

    return model;
  }

  protected ProfileResponseEdo getTestProfileResponseEdo(final String sessionid, final UserEdo user, final CompanyEdo company) {

    final ProfileResponseEdo model = new ProfileResponseEdo();
    model.setCompanyProfile(ProfileModelEdoMapper.toEdo(this.getTestCompanyProfile()));
    model.setSessionid(sessionid);
    model.setUser(user);

    return model;
  }

  protected ProfileResponse getTestProfileResponse(final String sessionid) {

    final ProfileResponse model = new ProfileResponse(this.getTestUser(), this.getTestCompanyProfile(), sessionid);

    return model;
  }

  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo(final String email, final String token) {

    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setUserIdentity(email);
    model.setToken(token);

    return model;
  }

  protected UserAuthenticationRequest getTestUserAuthenticationRequest() {

    final UserAuthenticationRequest model = new UserAuthenticationRequest();
    model.setCompanyIdentity("companyIdentity");
    model.setPassword("password");
    model.setUserIdentity("email");

    return model;
  }

  protected List<Department> getTestDepartmentList() {

    final List<Department> list = Arrays
        .asList(this.getTestDepartment("dep1", "Department 1"),
            this.getTestDepartment("dep2", "Department 2"), this.getTestDepartment("dep3", "Department 3"));

    return list;
  }

  protected int getSessionMaxAgeInSeconds() {

    return 1000;
  }

  protected Set<String> getTestUserGroupIdSet() {

    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDepartmentIdSet() {

    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDepartmentGroupIdSet() {

    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDeputiyIdSet() {

    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestUserIdSet() {

    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected WorkflowMessage getTestWorkflowMessage(final String userId, final String workflowIdentity) {

    final WorkflowMessage message = new WorkflowMessage();
    message.setCreatedAt(LocalDateTime.now());
    message.setCreatedByIdentity("createdByIdentity");
    message.setExpireDays(15);
    message.setMessage("message 1");
    message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    message.setStatus(EWorkflowMessageStatus.OFFERING);
    message.setStepIdentity("stepIdentity");
    message.setUserIdentity(userId);
    message.setVersion(1);
    message.setWorkflowIdentity(workflowIdentity);

    return message;
  }

  protected List<WorkflowMessage> getTestWorkflowMessageList() {

    final String workflowIdentity = "workflow1";

    return Arrays
        .asList(this.getTestWorkflowMessage("user1", workflowIdentity),
            this.getTestWorkflowMessage("user2", workflowIdentity), this.getTestWorkflowMessage("user3", workflowIdentity));
  }

}
