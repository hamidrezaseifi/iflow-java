package com.pth.iflow.workflow;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.workflow.models.Company;
import com.pth.iflow.workflow.models.CompanyProfile;
import com.pth.iflow.workflow.models.Department;
import com.pth.iflow.workflow.models.DepartmentGroup;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.UserGroup;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
import com.pth.iflow.workflow.models.WorkflowFile;
import com.pth.iflow.workflow.models.WorkflowFileVersion;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentifyid("identifyid");
    company.setStatus(1);

    return company;
  }

  protected CompanyProfile getTestCompanyProfile() {

    final CompanyProfile companyProfile = new CompanyProfile(this.getTestCompany(),
                                                             this.getTestDepartmentList(),
                                                             this.getTestUserGroupList());

    return companyProfile;
  }

  protected User getTestUser() {
    final User model = new User();
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

  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setBirthDate(new Date());
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
                                          this.getTestUser(2L, "fname 2", "lname 2", "email 2"),
                                          this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected Workflow getTestWorkflow(final Long Id) {
    final Workflow model = new Workflow();
    model.setWorkflowTypeId(1L);
    model.setId(Id);
    model.setTitle("title " + Id);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setController(1L);
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepId(model.getCurrentStep().getId());
    model.setCreatedBy(1L);
    model.setAssignTo(1L);
    model.setNextAssign(false);
    model.setActions(
                     Arrays.asList(this.getTestWorkflowAction(1L, 1L),
                                   this.getTestWorkflowAction(2L, 2L),
                                   this.getTestWorkflowAction(3L, 3L)));
    model
         .setFiles(Arrays.asList(this.getTestWorkflowFile(1L, 1L), this.getTestWorkflowFile(2L, 2L), this.getTestWorkflowFile(3L, 3L)));

    return model;
  }

  protected Workflow getTestWorkflow(final Long Id, final EWorkflowActionStatus actionStatus) {
    final Workflow model = new Workflow();
    model.setWorkflowTypeId(1L);
    model.setId(Id);
    model.setTitle("title " + Id);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setController(1L);
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepId(model.getCurrentStep().getId());
    model.setCreatedBy(1L);
    model.setAssignTo(1L);
    model.setActions(Arrays.asList(this.getTestWorkflowAction(1L, 1L, actionStatus),
                                   this.getTestWorkflowAction(2L, 2L, actionStatus),
                                   this.getTestWorkflowAction(3L, 3L, actionStatus)));
    model
         .setFiles(Arrays.asList(this.getTestWorkflowFile(1L, 1L), this.getTestWorkflowFile(2L, 2L), this.getTestWorkflowFile(3L, 3L)));

    return model;
  }

  protected WorkflowFile getTestWorkflowFile(final Long Id, final Long workflowId) {
    final WorkflowFile model = new WorkflowFile();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setFileVersions(Arrays.asList(this.getTestWorkflowFileVersion(1L, 1, 1L),
                                        this.getTestWorkflowFileVersion(2L, 2, 1L),
                                        this.getTestWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected WorkflowFileVersion getTestWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {
    final WorkflowFileVersion model = new WorkflowFileVersion();
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

  protected WorkflowAction getTestWorkflowAction(final Long Id, final Long workflowId) {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setAction("action " + Id);
    model.setStatus(EWorkflowActionStatus.DONE_REQUEST);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setNewStep(2L);
    model.setOldStep(1L);
    model.setComments("comments");
    model.setNextAssign(1L);

    return model;
  }

  protected WorkflowAction getTestWorkflowAction(final Long Id, final Long workflowId, final EWorkflowActionStatus actionStatus) {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setAction("action " + Id);
    model.setStatus(actionStatus);
    model.setVersion(1);
    model.setCreatedBy(1L);
    model.setNewStep(2L);
    model.setOldStep(1L);
    model.setComments("comments");
    model.setNextAssign(1L);

    return model;
  }

  protected WorkflowType getTestWorkflowType() {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setBaseTypeId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setManualAssign(true);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1", 1),
                                 this.getTestWorkflowTypeStep(2L, "step 2", 2),
                                 this.getTestWorkflowTypeStep(3L, "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected WorkflowType getTestWorkflowType(final Long id, final String title) {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setManualAssign(true);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1", 1),
                                 this.getTestWorkflowTypeStep(2L, "step 2", 2),
                                 this.getTestWorkflowTypeStep(3L, "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected List<WorkflowType> getTestWorkflowTypeList() {
    final List<WorkflowType> list = Arrays.asList(this.getTestWorkflowType(1L, "WorkflowType 1"),
                                                  this.getTestWorkflowType(2L, "WorkflowType 2"),
                                                  this.getTestWorkflowType(3L, "WorkflowType 3"));

    return list;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep() {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");

    return model;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep(final Long id, final String title, final Integer index) {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setStepIndex(index);
    model.setComments("comments");

    return model;
  }

  protected List<Workflow> getTestWorkflowList() {

    return Arrays.asList(this.getTestWorkflow(1L), this.getTestWorkflow(2L), this.getTestWorkflow(3L));
  }

  protected List<WorkflowTypeStep> getTestWorkflowTypeStepList() {
    final List<WorkflowTypeStep> list = Arrays.asList(this.getTestWorkflowTypeStep(1L, "WorkflowTypeStep 1", 1),
                                                      this.getTestWorkflowTypeStep(2L, "WorkflowTypeStep 2", 2),
                                                      this.getTestWorkflowTypeStep(3L, "WorkflowTypeStep 3", 3));

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

  protected List<Long> getTestWorkflowTypeIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestWorkflowIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestWorkflowTypeStepIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDeputiyIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestUserIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment(1L, "Department 1"),
                                                this.getTestDepartment(2L, "Department 2"),
                                                this.getTestDepartment(3L, "Department 3"));

    return list;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup(1L, "UserGroup 1"),
                                               this.getTestUserGroup(2L, "UserGroup 2"),
                                               this.getTestUserGroup(3L, "UserGroup 3"));

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
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup(1L, "DepartmentGroup 1"),
                                                     this.getTestDepartmentGroup(2L, "DepartmentGroup 2"),
                                                     this.getTestDepartmentGroup(3L, "DepartmentGroup 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected WorkflowSearchFilter getTestWorkflowSearchFilter() {
    final WorkflowSearchFilter filter = new WorkflowSearchFilter();
    filter.setAssignedUserIdList(this.getTestUserIdList());
    filter.setStatusList(Arrays.asList(1, 2, 3));
    filter.setTitle("title");
    filter.setWorkflowStepeIdList(this.getTestWorkflowTypeStepIdList());
    filter.setWorkflowTypeIdList(this.getTestWorkflowTypeIdList());

    return filter;
  }

  protected WorkflowCreateRequest getTestWorkflowCreateRequest() {
    final WorkflowCreateRequest request = new WorkflowCreateRequest();
    request.setAssignedUsers(this.getTestUserIdList());
    request.setWorkflow(this.getTestWorkflow(null));

    return request;
  }

}
