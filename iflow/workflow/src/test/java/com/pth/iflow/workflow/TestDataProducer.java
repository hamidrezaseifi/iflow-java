package com.pth.iflow.workflow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.Company;
import com.pth.iflow.workflow.models.CompanyProfile;
import com.pth.iflow.workflow.models.Department;
import com.pth.iflow.workflow.models.DepartmentGroup;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.UserGroup;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowFile;
import com.pth.iflow.workflow.models.WorkflowFileVersion;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setIdentity("identifyid");
    company.setStatus(1);
    company.setVersion(1);

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
    model.setCompanyIdentity("companyIdentity");
    model.setEmail("email");
    model.setBirthDate(LocalDate.now());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setCompanyIdentity("companyIdentity");

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
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());

    return model;
  }

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser("fname 1", "lname 1", "email 1"),
                                          this.getTestUser("fname 2", "lname 2", "email 2"),
                                          this.getTestUser("fname 3", "lname 3", "email 3"));

    return list;
  }

  protected InvoiceWorkflow getTestInvoiceWorkflow(final String identity) {
    final InvoiceWorkflow model = new InvoiceWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");

    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", model.getIdentity()),
                                   this.getTestWorkflowAction("action2", model.getIdentity()),
                                   this.getTestWorkflowAction("action3", model.getIdentity())));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", model.getIdentity()),
                                 this.getTestWorkflowFile("file2", model.getIdentity()),
                                 this.getTestWorkflowFile("file3", model.getIdentity())));

    return model;
  }

  protected InvoiceWorkflow getTestInvoiceWorkflow(final String identity, final WorkflowType workflowType) {
    final InvoiceWorkflow model = new InvoiceWorkflow();
    model.setWorkflowType(workflowType);
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(workflowType.getSteps().get(0));
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");

    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", model.getIdentity()),
                                   this.getTestWorkflowAction("action2", model.getIdentity()),
                                   this.getTestWorkflowAction("action3", model.getIdentity())));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", model.getIdentity()),
                                 this.getTestWorkflowFile("file2", model.getIdentity()),
                                 this.getTestWorkflowFile("file3", model.getIdentity())));

    return model;
  }

  protected InvoiceWorkflow getInvoiceTestWorkflow(final String identity, final EWorkflowActionStatus actionStatus) {
    final InvoiceWorkflow model = new InvoiceWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");
    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", identity, actionStatus),
                                   this.getTestWorkflowAction("action2", identity, actionStatus),
                                   this.getTestWorkflowAction("action3", identity, actionStatus)));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", identity),
                                 this.getTestWorkflowFile("file2", identity),
                                 this.getTestWorkflowFile("file3", identity)));

    return model;
  }

  protected SingleTaskWorkflow getSingleTaskTestWorkflow(final String identity, final EWorkflowActionStatus actionStatus) {
    final SingleTaskWorkflow model = new SingleTaskWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");
    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", identity, actionStatus),
                                   this.getTestWorkflowAction("action2", identity, actionStatus),
                                   this.getTestWorkflowAction("action3", identity, actionStatus)));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", identity),
                                 this.getTestWorkflowFile("file2", identity),
                                 this.getTestWorkflowFile("file3", identity)));

    return model;
  }

  protected TestThreeTaskWorkflow getTestThreeTaskTestWorkflow(final String identity, final EWorkflowActionStatus actionStatus) {
    final TestThreeTaskWorkflow model = new TestThreeTaskWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");
    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", identity, actionStatus),
                                   this.getTestWorkflowAction("action2", identity, actionStatus),
                                   this.getTestWorkflowAction("action3", identity, actionStatus)));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", identity),
                                 this.getTestWorkflowFile("file2", identity),
                                 this.getTestWorkflowFile("file3", identity)));

    return model;
  }

  protected SingleTaskWorkflow getTestSingleTaskWorkflow(final String identity) {
    final SingleTaskWorkflow model = new SingleTaskWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");

    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", model.getIdentity()),
                                   this.getTestWorkflowAction("action2", model.getIdentity()),
                                   this.getTestWorkflowAction("action3", model.getIdentity())));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", model.getIdentity()),
                                 this.getTestWorkflowFile("file2", model.getIdentity()),
                                 this.getTestWorkflowFile("file3", model.getIdentity())));

    return model;
  }

  protected TestThreeTaskWorkflow getTestTestThreeTaskWorkflow(final String identity) {
    final TestThreeTaskWorkflow model = new TestThreeTaskWorkflow();
    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE);
    model.setVersion(1);
    model.setComments("comments");
    model.setControllerIdentity("controllerIdentity");
    model.setCurrentStep(this.getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity("createdByIdentity");

    model.setActions(Arrays.asList(this.getTestWorkflowAction("action1", model.getIdentity()),
                                   this.getTestWorkflowAction("action2", model.getIdentity()),
                                   this.getTestWorkflowAction("action3", model.getIdentity())));
    model.setFiles(Arrays.asList(this.getTestWorkflowFile("file1", model.getIdentity()),
                                 this.getTestWorkflowFile("file2", model.getIdentity()),
                                 this.getTestWorkflowFile("file3", model.getIdentity())));

    return model;
  }

  protected WorkflowFile getTestWorkflowFile(final String identity, final String workflowIdentity) {
    final WorkflowFile model = new WorkflowFile();
    model.setWorkflowIdentity(workflowIdentity);
    model.setIdentity(identity);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity("createdByIdentity");
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + identity);
    model.setExtention("ext");
    model.setFileVersions(Arrays.asList(this.getTestWorkflowFileVersion("filever1", 1, identity),
                                        this.getTestWorkflowFileVersion("filever2", 2, identity),
                                        this.getTestWorkflowFileVersion("filever3", 3, identity)));

    return model;
  }

  protected WorkflowFileVersion getTestWorkflowFileVersion(final String identity, final int version, final String workflowFileIdentity) {
    final WorkflowFileVersion model = new WorkflowFileVersion();
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedBy(getTestUser());
    model.setCreatedByIdentity(model.getCreatedBy().getIdentity());
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowAction getTestWorkflowAction(final String identity, final String workflowIdentity) {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowIdentity(workflowIdentity);
    model.setIdentity(identity);
    model.setStatus(EWorkflowActionStatus.OPEN);
    model.setVersion(1);
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setComments("comments");
    model.setAssignToUser(getTestUser("fname", "lname", "assignedemail"));
    model.setAssignToIdentity(model.getAssignToUser().getIdentity());

    return model;
  }

  protected WorkflowAction getTestWorkflowAction(final String identity, final String workflowIdentity, final EWorkflowActionStatus actionStatus) {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowIdentity(workflowIdentity);
    model.setIdentity(identity);
    model.setStatus(actionStatus);
    model.setVersion(1);
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setComments("comments");
    model.setAssignToUser(getTestUser("fname", "lname", "assignedemail"));
    model.setAssignToIdentity(model.getAssignToUser().getIdentity());

    return model;
  }

  protected WorkflowType getTestWorkflowType() {
    final WorkflowType model = new WorkflowType();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity("identity");
    model.setBaseTypeIdentity("baseTypeIdentity");
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep("step1", "step 1", 1),
                                 this.getTestWorkflowTypeStep("step2", "step 2", 2),
                                 this.getTestWorkflowTypeStep("step3", "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected WorkflowType getTestWorkflowType(final String identity, final String title) {
    final WorkflowType model = new WorkflowType();
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setCompanyIdentity("companyIdentity");
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setBaseTypeIdentity("baseTypeIdentity");
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep("step1", "step 1", 1),
                                 this.getTestWorkflowTypeStep("step2", "step 2", 2),
                                 this.getTestWorkflowTypeStep("step3", "step 3", 3)));
    model.setComments("comments");

    return model;
  }

  protected List<WorkflowType> getTestWorkflowTypeList() {
    final List<WorkflowType> list = Arrays.asList(this.getTestWorkflowType("type1", "WorkflowType 1"),
                                                  this.getTestWorkflowType("type2", "WorkflowType 2"),
                                                  this.getTestWorkflowType("type3", "WorkflowType 3"));

    return list;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep() {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setIdentity("identity");
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");
    model.setViewName("viewName");
    model.setExpireDays(15);

    return model;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep(final String identity, final String title, final Integer index) {
    final WorkflowTypeStep model = new WorkflowTypeStep();

    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(index);
    model.setComments("comments");
    model.setViewName("viewName");
    model.setExpireDays(15);

    return model;
  }

  protected List<InvoiceWorkflow> getTestInvoiceWorkflowList() {

    return Arrays.asList(this.getTestInvoiceWorkflow("workflow1"),
                         this.getTestInvoiceWorkflow("workflow2"),
                         this.getTestInvoiceWorkflow("workflow3"));
  }

  protected List<SingleTaskWorkflow> getTestSingleTaskWorkflowList() {

    return Arrays.asList(this.getTestSingleTaskWorkflow("workflow1"),
                         this.getTestSingleTaskWorkflow("workflow2"),
                         this.getTestSingleTaskWorkflow("workflow3"));
  }

  protected List<TestThreeTaskWorkflow> getTestTestThreeTaskWorkflowList() {

    return Arrays.asList(this.getTestTestThreeTaskWorkflow("workflow1"),
                         this.getTestTestThreeTaskWorkflow("workflow2"),
                         this.getTestTestThreeTaskWorkflow("workflow3"));
  }

  protected List<WorkflowTypeStep> getTestWorkflowTypeStepList() {
    final List<WorkflowTypeStep> list = Arrays.asList(this.getTestWorkflowTypeStep("step1", "WorkflowTypeStep 1", 1),
                                                      this.getTestWorkflowTypeStep("step2", "WorkflowTypeStep 2", 2),
                                                      this.getTestWorkflowTypeStep("step3", "WorkflowTypeStep 3", 3));

    return list;
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

  protected Set<String> getTestWorkflowTypeIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestWorkflowIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestWorkflowTypeStepIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDeputiyIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestUserIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment("dep1", "Department 1"),
                                                this.getTestDepartment("dep2", "Department 2"),
                                                this.getTestDepartment("dep3", "Department 3"));

    return list;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup("usergrp1", "UserGroup 1"),
                                               this.getTestUserGroup("usergrp2", "UserGroup 2"),
                                               this.getTestUserGroup("usergrp3", "UserGroup 3"));

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

  protected Department getTestDepartment(final String identity, final String title) {
    final Department model = new Department();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());

    return model;
  }

  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup("depgrp1", "DepartmentGroup 1"),
                                                     this.getTestDepartmentGroup("depgrp2", "DepartmentGroup 2"),
                                                     this.getTestDepartmentGroup("depgrp3", "DepartmentGroup 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup(final String identity, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentIdentity("departmentIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected WorkflowSearchFilter getTestWorkflowSearchFilter() {
    final WorkflowSearchFilter filter = new WorkflowSearchFilter();
    filter.setAssignedUserIdSet(this.getTestUserIdSet());
    filter.setStatusSet(new HashSet<>(Arrays.asList(1, 2, 3)));
    filter.setWorkflowStepeIdSet(this.getTestWorkflowTypeStepIdSet());
    filter.setWorkflowTypeIdSet(this.getTestWorkflowTypeIdSet());

    return filter;
  }

  protected InvoiceWorkflowSaveRequest getTestInvoiceWorkflowSaveRequest() {
    final InvoiceWorkflowSaveRequest request = new InvoiceWorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestInvoiceWorkflow("workflow1"));
    request.setExpireDays(10);
    request.setCommand(EWorkflowProcessCommand.NONE);

    return request;
  }

  protected SingleTaskWorkflowSaveRequest getTestSingleTaskWorkflowSaveRequest() {
    final SingleTaskWorkflowSaveRequest request = new SingleTaskWorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestSingleTaskWorkflow("workflow1"));
    request.setExpireDays(10);
    request.setCommand(EWorkflowProcessCommand.NONE);

    return request;
  }

  protected TestThreeTaskWorkflowSaveRequest getTestTestThreeTaskWorkflowSaveRequest() {
    final TestThreeTaskWorkflowSaveRequest request = new TestThreeTaskWorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestTestThreeTaskWorkflow("workflow1"));
    request.setExpireDays(10);
    request.setCommand(EWorkflowProcessCommand.NONE);

    return request;
  }

  protected InvoiceWorkflowSaveRequest getTestNewInvoiceWorkflowSaveRequest() {
    final InvoiceWorkflowSaveRequest request = new InvoiceWorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestInvoiceWorkflow("workflow1"));
    request.setExpireDays(10);
    request.setCommand(EWorkflowProcessCommand.NONE);

    final WorkflowType workflowType = this.getTestWorkflowType("type1", "");
    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    request.getWorkflow().setWorkflowType(workflowType);
    request.getWorkflow().setIdentityToNew();

    return request;
  }

  protected InvoiceWorkflowSaveRequest getTestInvoiceWorkflowCreateRequestForStrategy() {
    final WorkflowType workflowType = this.getTestWorkflowType("workflowtype1", "Workflowtype 1");

    final InvoiceWorkflowSaveRequest request = new InvoiceWorkflowSaveRequest();
    request.setAssigns(this.getTestAssignedList());
    request.setWorkflow(this.getTestInvoiceWorkflow("workflow1", workflowType));
    request.setExpireDays(10);
    request.setCommand(EWorkflowProcessCommand.NONE);

    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    request.getWorkflow().setWorkflowType(workflowType);
    request.getWorkflow().setIdentity("identity");

    int stepIdndex = 0;
    for (final WorkflowAction action : request.getWorkflow().getActions()) {
      action.setCurrentStep(workflowType.getSteps().get(stepIdndex++));
      action.setCurrentStepIdentity(action.getCurrentStep().getIdentity());
    }

    return request;
  }

  protected List<AssignItem> getTestAssignedList() {
    return Arrays.asList(new AssignItem("user1", EAssignType.USER),
                         new AssignItem("user2", EAssignType.USER),
                         new AssignItem("user3", EAssignType.USER));
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

    return Arrays.asList(getTestWorkflowMessage("user1", "workflow1"),
                         getTestWorkflowMessage("user2", "workflow1"),
                         getTestWorkflowMessage("user3", "workflow1"));
  }

}
