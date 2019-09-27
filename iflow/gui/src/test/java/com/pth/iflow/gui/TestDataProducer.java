package com.pth.iflow.gui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.gui.models.GuiAssignItem;
import com.pth.iflow.gui.models.GuiCompany;
import com.pth.iflow.gui.models.GuiCompanyProfile;
import com.pth.iflow.gui.models.GuiDepartment;
import com.pth.iflow.gui.models.GuiDepartmentGroup;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiUserGroup;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowAction;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowFileVersion;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiWorkflowTypeStep;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.models.ui.enums.EUiUserRole;

public class TestDataProducer {

  protected GuiCompany getTestCompany() {
    final GuiCompany company = new GuiCompany();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentifyid("identifyid");
    company.setStatus(1);

    return company;
  }

  protected GuiCompanyProfile getTestCompanyProfile() {

    final GuiCompanyProfile companyProfile = new GuiCompanyProfile(this.getTestCompany(), this.getTestDepartmentList(),
        this.getTestUserGroupList());

    return companyProfile;
  }

  protected GuiUser getTestUser() {
    final GuiUser model = new GuiUser();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setBirthDate(new Date());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected GuiUser getTestUser(final Long id, final String fname, final String lname, final String email) {
    final GuiUser model = new GuiUser();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setBirthDate(new Date());
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected List<GuiUser> getTestUserList() {
    final List<GuiUser> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
        this.getTestUser(2L, "fname 2", "lname 2", "email 2"), this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected GuiWorkflow getTestGuiWorkflow(final Long Id) {
    final GuiWorkflow model = new GuiWorkflow();
    model.setWorkflowTypeId(1L);
    model.setId(Id);
    model.setTitle("title " + Id);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setController(1L);
    model.setCurrentStep(this.getTestGuiWorkflowTypeStep());
    model.setCurrentStepId(model.getCurrentStep().getId());
    model.setCreatedBy(1L);
    model.setAssignTo(1L);
    model.setCommand(EWorkflowProcessCommand.CREATE);
    model.setNextAssign(true);
    model.setActions(Arrays.asList(this.getTestGuiWorkflowAction(1L, 1L), this.getTestGuiWorkflowAction(2L, 2L),
        this.getTestGuiWorkflowAction(3L, 3L)));
    model.setFiles(
        Arrays.asList(this.getTestGuiWorkflowFile(1L, 1L), this.getTestGuiWorkflowFile(2L, 2L), this.getTestGuiWorkflowFile(3L, 3L)));

    return model;
  }

  protected GuiWorkflowFile getTestGuiWorkflowFile(final Long Id, final Long workflowId) {
    final GuiWorkflowFile model = new GuiWorkflowFile();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setExtention("extention");
    model.setFileVersions(Arrays.asList(this.getTestGuiWorkflowFileVersion(1L, 1, 1L), this.getTestGuiWorkflowFileVersion(2L, 2, 1L),
        this.getTestGuiWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected GuiWorkflowFileVersion getTestGuiWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {
    final GuiWorkflowFileVersion model = new GuiWorkflowFileVersion();
    model.setWorkflowFileId(workflowFileId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected GuiWorkflowAction getTestGuiWorkflowAction(final Long Id, final Long workflowId) {
    final GuiWorkflowAction model = new GuiWorkflowAction();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setAction("action " + Id);
    model.setStatus(EWorkflowActionStatus.INITIALIZE);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setNewStep(2L);
    model.setOldStep(1L);
    model.setComments("comments");

    return model;
  }

  protected GuiWorkflowType getTestGuiWorkflowType() {
    final GuiWorkflowType model = new GuiWorkflowType();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setBaseTypeId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setBaseTypeId(1L);
    model.setSteps(Arrays.asList(this.getTestGuiWorkflowTypeStep(1L, "step 1", 1), this.getTestGuiWorkflowTypeStep(2L, "step 2", 2),
        this.getTestGuiWorkflowTypeStep(3L, "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected GuiWorkflowType getTestGuiWorkflowType(final Long id, final String title) {
    final GuiWorkflowType model = new GuiWorkflowType();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setBaseTypeId(1L);
    model.setSteps(Arrays.asList(this.getTestGuiWorkflowTypeStep(1L, "step 1", 1), this.getTestGuiWorkflowTypeStep(2L, "step 2", 2),
        this.getTestGuiWorkflowTypeStep(3L, "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected List<GuiWorkflowType> getTestGuiWorkflowTypeList() {
    final List<GuiWorkflowType> list = Arrays.asList(this.getTestGuiWorkflowType(1L, "GuiWorkflowType 1"),
        this.getTestGuiWorkflowType(2L, "GuiWorkflowType 2"), this.getTestGuiWorkflowType(3L, "GuiWorkflowType 3"));

    return list;
  }

  protected GuiWorkflowTypeStep getTestGuiWorkflowTypeStep() {
    final GuiWorkflowTypeStep model = new GuiWorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");
    model.setViewName("viewName");

    return model;
  }

  protected GuiWorkflowTypeStep getTestGuiWorkflowTypeStep(final Long id, final String title, final Integer index) {
    final GuiWorkflowTypeStep model = new GuiWorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setStepIndex(index);
    model.setComments("comments");
    model.setViewName("viewName");

    return model;
  }

  protected List<GuiWorkflow> getTestGuiWorkflowList() {

    return Arrays.asList(this.getTestGuiWorkflow(1L), this.getTestGuiWorkflow(2L), this.getTestGuiWorkflow(3L));
  }

  protected List<GuiWorkflowTypeStep> getTestGuiWorkflowTypeStepList() {
    final List<GuiWorkflowTypeStep> list = Arrays.asList(this.getTestGuiWorkflowTypeStep(1L, "GuiWorkflowTypeStep 1", 1),
        this.getTestGuiWorkflowTypeStep(2L, "GuiWorkflowTypeStep 2", 2),
        this.getTestGuiWorkflowTypeStep(3L, "GuiWorkflowTypeStep 3", 3));

    return list;
  }

  protected List<Long> getTestUserGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDepartmentIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDepartmentGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestGuiWorkflowTypeIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestGuiWorkflowIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestGuiWorkflowTypeStepIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDeputiyIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestUserIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<GuiAssignItem> getTestAssignedList() {
    return Arrays.asList(new GuiAssignItem(1L, EAssignType.USER), new GuiAssignItem(2L, EAssignType.USER),
        new GuiAssignItem(3L, EAssignType.USER));
  }

  protected List<GuiDepartment> getTestDepartmentList() {
    final List<GuiDepartment> list = Arrays.asList(this.getTestDepartment(1L, "GuiDepartment 1"),
        this.getTestDepartment(2L, "GuiDepartment 2"), this.getTestDepartment(3L, "GuiDepartment 3"));

    return list;
  }

  protected List<GuiUserGroup> getTestUserGroupList() {
    final List<GuiUserGroup> list = Arrays.asList(this.getTestUserGroup(1L, "GuiUserGroup 1"),
        this.getTestUserGroup(2L, "GuiUserGroup 2"), this.getTestUserGroup(3L, "GuiUserGroup 3"));

    return list;
  }

  protected GuiUserGroup getTestUserGroup(final Long id, final String title) {
    final GuiUserGroup model = new GuiUserGroup();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected GuiDepartment getTestDepartment(final Long id, final String title) {
    final GuiDepartment model = new GuiDepartment();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());

    return model;
  }

  protected List<GuiDepartmentGroup> getTestDepartmentGroupList() {
    final List<GuiDepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup(1L, "GuiDepartmentGroup 1"),
        this.getTestDepartmentGroup(2L, "GuiDepartmentGroup 2"), this.getTestDepartmentGroup(3L, "GuiDepartmentGroup 3"));

    return list;
  }

  protected GuiDepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final GuiDepartmentGroup model = new GuiDepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected GuiWorkflowSearchFilter getTestGuiWorkflowSearchFilter() {
    final GuiWorkflowSearchFilter filter = new GuiWorkflowSearchFilter();
    filter.setAssignedUserIdList(this.getTestUserIdList());
    filter.setStatusList(Arrays.asList(1, 2, 3));
    filter.setTitle("title");
    filter.setWorkflowStepeIdList(this.getTestGuiWorkflowTypeStepIdList());
    filter.setWorkflowTypeIdList(this.getTestGuiWorkflowTypeIdList());

    return filter;
  }

  protected GuiWorkflowCreateRequest getTestGuiWorkflowCreateRequest() {
    final GuiWorkflowCreateRequest request = new GuiWorkflowCreateRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestGuiWorkflow(null));

    return request;
  }

  protected GuiUser createUiUser(final String email, final String fname, final String lname, final List<EUiUserRole> roles) {
    final GuiUser user = new GuiUser();
    user.setFirstName(fname);
    user.setLastName(lname);
    user.setEmail(email);
    user.setEnabled(true);
    user.setRoles(roles.stream().map(r -> r.getId()).collect(Collectors.toList()));

    return user;

  }

  protected GuiUser createUiUser() {
    final GuiUser user = this.createUiUser("username", "fname", "lname", Arrays.asList(EUiUserRole.ADMIN, EUiUserRole.VIEW));
    return user;
  }

  protected GuiSessionUserInfo createGuiSessionUserInfo() {

    final GuiSessionUserInfo info = new GuiSessionUserInfo(this.createUiUser("admin", "", "", Arrays.asList(EUiUserRole.ADMIN)),
        this.getTestCompanyProfile());
    info.setToken("test-token");
    info.setSessionId("test-sessionId");
    info.update();

    return info;
  }

}
