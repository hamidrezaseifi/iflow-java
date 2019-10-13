package com.pth.iflow.gui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.DepartmentGroup;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserGroup;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowFileVersion;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.ui.enums.EUiUserRole;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setIdentity("identifyid");
    company.setStatus(1);

    return company;
  }

  protected CompanyProfile getTestCompanyProfile() {

    final CompanyProfile companyProfile = new CompanyProfile(this.getTestCompany(), this.getTestDepartmentList(),
        this.getTestUserGroupList());

    return companyProfile;
  }

  protected User getTestUser() {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setBirthDate(LocalDate.now());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setBirthDate(LocalDate.now());
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

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
        this.getTestUser(2L, "fname 2", "lname 2", "email 2"), this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected Workflow getTestGuiWorkflow(final Long Id) {
    final Workflow model = new Workflow();
    model.setWorkflowTypeId(1L);
    model.setIdentity(EWorkflowIdentity.NOT_SET.getName());
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setController(1L);
    model.setCurrentStep(this.getTestGuiWorkflowTypeStep());
    model.setCurrentStepId(model.getCurrentStep().getId());
    model.setCreatedByIdentity(1L);
    model.setActions(Arrays.asList(this.getTestGuiWorkflowAction(1L, 1L), this.getTestGuiWorkflowAction(2L, 2L),
        this.getTestGuiWorkflowAction(3L, 3L)));
    model.setFiles(
        Arrays.asList(this.getTestGuiWorkflowFile(1L, 1L), this.getTestGuiWorkflowFile(2L, 2L), this.getTestGuiWorkflowFile(3L, 3L)));

    return model;
  }

  protected WorkflowFile getTestGuiWorkflowFile(final Long Id, final Long workflowId) {
    final WorkflowFile model = new WorkflowFile();
    model.setIdentity("identity" + Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setExtention("extention");
    model.setFileVersions(Arrays.asList(this.getTestGuiWorkflowFileVersion(1L, 1, 1L), this.getTestGuiWorkflowFileVersion(2L, 2, 1L),
        this.getTestGuiWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected WorkflowFileVersion getTestGuiWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {
    final WorkflowFileVersion model = new WorkflowFileVersion();
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity(1L);
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowAction getTestGuiWorkflowAction(final Long Id, final Long workflowId) {
    final WorkflowAction model = new WorkflowAction();
    model.setStatus(EWorkflowActionStatus.INITIALIZE);
    model.setVersion(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignTo(1L);

    return model;
  }

  protected WorkflowType getTestGuiWorkflowType() {
    final WorkflowType model = new WorkflowType();
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

  protected WorkflowType getTestGuiWorkflowType(final Long id, final String title) {
    final WorkflowType model = new WorkflowType();
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

  protected List<WorkflowType> getTestGuiWorkflowTypeList() {
    final List<WorkflowType> list = Arrays.asList(this.getTestGuiWorkflowType(1L, "GuiWorkflowType 1"),
        this.getTestGuiWorkflowType(2L, "GuiWorkflowType 2"), this.getTestGuiWorkflowType(3L, "GuiWorkflowType 3"));

    return list;
  }

  protected WorkflowTypeStep getTestGuiWorkflowTypeStep() {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");
    model.setViewName("viewName");

    return model;
  }

  protected WorkflowTypeStep getTestGuiWorkflowTypeStep(final Long id, final String title, final Integer index) {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setStepIndex(index);
    model.setComments("comments");
    model.setViewName("viewName");
    model.setExpireDays(15);

    return model;
  }

  protected List<Workflow> getTestGuiWorkflowList() {

    return Arrays.asList(this.getTestGuiWorkflow(1L), this.getTestGuiWorkflow(2L), this.getTestGuiWorkflow(3L));
  }

  protected List<WorkflowTypeStep> getTestGuiWorkflowTypeStepList() {
    final List<WorkflowTypeStep> list = Arrays.asList(this.getTestGuiWorkflowTypeStep(1L, "GuiWorkflowTypeStep 1", 1),
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

  protected List<AssignItem> getTestAssignedList() {
    return Arrays.asList(new AssignItem(1L, EAssignType.USER), new AssignItem(2L, EAssignType.USER),
        new AssignItem(3L, EAssignType.USER));
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment(1L, "GuiDepartment 1"),
        this.getTestDepartment(2L, "GuiDepartment 2"), this.getTestDepartment(3L, "GuiDepartment 3"));

    return list;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup(1L, "GuiUserGroup 1"),
        this.getTestUserGroup(2L, "GuiUserGroup 2"), this.getTestUserGroup(3L, "GuiUserGroup 3"));

    return list;
  }

  protected UserGroup getTestUserGroup(final Long id, final String title) {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected Department getTestDepartment(final Long id, final String title) {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());

    return model;
  }

  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup(1L, "GuiDepartmentGroup 1"),
        this.getTestDepartmentGroup(2L, "GuiDepartmentGroup 2"), this.getTestDepartmentGroup(3L, "GuiDepartmentGroup 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected WorkflowSearchFilter getTestGuiWorkflowSearchFilter() {
    final WorkflowSearchFilter filter = new WorkflowSearchFilter();
    filter.setAssignedUserIdSet(this.getTestUserIdList());
    filter.setStatusSet(Arrays.asList(1, 2, 3));
    filter.setWorkflowStepeIdSet(this.getTestGuiWorkflowTypeStepIdList());
    filter.setWorkflowTypeIdSet(this.getTestGuiWorkflowTypeIdList());

    return filter;
  }

  protected WorkflowSaveRequest getTestGuiWorkflowSaveRequest() {
    final WorkflowSaveRequest request = new WorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestGuiWorkflow(null));
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  protected WorkflowSaveRequest getTestGuiWorkflowSaveRequest(final Workflow workflow) {
    final WorkflowSaveRequest request = new WorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(workflow);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  protected User createUiUser(final String email, final String fname, final String lname, final List<EUiUserRole> roles) {
    final User user = new User();
    user.setFirstName(fname);
    user.setLastName(lname);
    user.setEmail(email);
    user.setEnabled(true);
    user.setRoles(roles.stream().map(r -> r.getId()).collect(Collectors.toList()));

    return user;

  }

  protected User createUiUser() {
    final User user = this.createUiUser("username", "fname", "lname", Arrays.asList(EUiUserRole.ADMIN, EUiUserRole.VIEW));
    return user;
  }

  protected SessionUserInfo createGuiSessionUserInfo() {

    final SessionUserInfo info = new SessionUserInfo(this.createUiUser("admin", "", "", Arrays.asList(EUiUserRole.ADMIN)),
        this.getTestCompanyProfile());
    info.setToken("test-token");
    info.setSessionId("test-sessionId");
    info.update();

    return info;
  }

}
