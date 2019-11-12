package com.pth.iflow.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.InvoiceWorkflow;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowFileVersion;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentity("identifyid");
    company.setStatus(1);
    company.setVersion(1);

    return company;
  }

  protected ProfileResponse getTestProfileResponse() {
    final Company company = getTestCompany();
    final User user = getTestUser();

    return new ProfileResponse(user, company, getTestDepartmentList(), getTestUserGroupList(), "not-set");
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
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected User getTestNewUser() {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(null);
    model.setEmail("utest email");
    model.setBirthDate(LocalDate.now());
    model.setFirstName("utest firstName");
    model.setLastName("utest lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());

    return model;
  }

  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setCompanyIdentity("test-companyIdentity");
    model.setBirthDate(LocalDate.now().minusYears(30));

    return model;
  }

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
                                          this.getTestUser(2L, "fname 2", "lname 2", "email 2"),
                                          this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected Department getTestDepartment() {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());
    model.setIdentity("dep-1");

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
    model.setIdentity("det-1");

    return model;
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment(1L, "Department 1"),
                                                this.getTestDepartment(2L, "Department 2"),
                                                this.getTestDepartment(3L, "Department 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup() {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("depgroup-1");

    return model;
  }

  protected DepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("depgroup-1");

    return model;
  }

  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup(1L, "DepartmentGroup 1"),
                                                     this.getTestDepartmentGroup(2L, "DepartmentGroup 2"),
                                                     this.getTestDepartmentGroup(3L, "DepartmentGroup 3"));

    return list;
  }

  protected UserGroup getTestUserGroup() {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-1");
    model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected UserGroup getTestUserGroup(final Long id, final String title) {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-" + id);
    model.setCompanyIdentity("test-companyIdentity");

    return model;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup(1L, "UserGroup 1"),
                                               this.getTestUserGroup(2L, "UserGroup 2"),
                                               this.getTestUserGroup(3L, "UserGroup 3"));

    return list;
  }

  protected Workflow getTestWorkflow(final Long Id) {
    final Workflow model = new Workflow();
    model.setWorkflowType(getTestWorkflowType());
    model.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());
    model.setId(Id);
    model.setIdentity(EWorkflowIdentity.NOT_SET.getName());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setController(getTestUser(1L, "fname", "lname", "email1"));
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setCreatedBy(getTestUser(2L, "fname", "lname", "email2"));
    model.setControllerIdentity(model.getController().getEmail());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity(model.getCreatedBy().getEmail());

    model.setActions(
                     Arrays.asList(this.getTestWorkflowAction(1L, 1L),
                                   this.getTestWorkflowAction(2L, 2L),
                                   this.getTestWorkflowAction(3L, 3L)));
    model
         .setFiles(Arrays.asList(this.getTestWorkflowFile(1L, 1L), this.getTestWorkflowFile(2L, 2L), this.getTestWorkflowFile(3L, 3L)));

    return model;
  }

  protected InvoiceWorkflow getTestInvoiceWorkflow(final Long Id) {
    final InvoiceWorkflow model = new InvoiceWorkflow();
    model.setWorkflowType(getTestWorkflowType());
    model.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());
    model.setId(Id);
    model.setIdentity(EWorkflowIdentity.NOT_SET.getName());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setController(getTestUser(1L, "fname", "lname", "email1"));
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setCreatedBy(getTestUser(2L, "fname", "lname", "email2"));
    model.setControllerIdentity(model.getController().getEmail());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity(model.getCreatedBy().getEmail());

    model.setActions(
                     Arrays.asList(this.getTestWorkflowAction(1L, 1L),
                                   this.getTestWorkflowAction(2L, 2L),
                                   this.getTestWorkflowAction(3L, 3L)));
    model
         .setFiles(Arrays.asList(this.getTestWorkflowFile(1L, 1L), this.getTestWorkflowFile(2L, 2L), this.getTestWorkflowFile(3L, 3L)));

    model.setSender("sender");
    model.setRegisterNumber("ext_reg_number");
    model.setInvoceDate(LocalDate.now());
    model.setPartnerCode("partner_code");
    model.setVendorNumber("vendor_number");
    model.setVendorName("vendor_name");
    model.setIsDirectDebitPermission(Boolean.TRUE);
    model.setInvoiceType(EInvoiceType.PAYMENT);
    model.setDiscountEnterDate(LocalDate.now());
    model.setDiscountRate(10.0);
    model.setDiscountDeadline(10);
    model.setDiscountDate(LocalDate.now());
    model.setPaymentAmount(1000.0);

    return model;
  }

  protected InvoiceWorkflow getTestNewInvoiceWorkflow() {
    final InvoiceWorkflow model = getTestInvoiceWorkflow(0L);
    model.setId(null);
    model.setIdentity("");
    for (final WorkflowAction action : model.getActions()) {
      action.setIdentity("");
    }
    for (final WorkflowFile file : model.getFiles()) {
      file.setIdentity("");
    }

    return model;
  }

  protected WorkflowMessage getTestWorkflowMessage(final Workflow workflow, final String message) {
    final WorkflowMessage model = new WorkflowMessage();
    model.setWorkflowIdentity(workflow.getIdentity());
    model.setId(null);
    model.setWorkflow(workflow);
    model.setMessage(message);
    model.setStatus(EWorkflowMessageStatus.OFFERING);
    model.setVersion(1);
    model.setExpireDays(10);
    model.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    model.setUserId(1L);
    model.setCreatedBy(1L);
    model.setCreatedByIdentity("createdByIdentity");
    model.setStepIdentity("stepIdentity");
    model.setUserIdentity("userIdentity");
    model.setCreatedAt(LocalDateTime.now());

    model.setMessage("title test");
    model.setStepId(workflow.getCurrentStep().getId());

    return model;
  }

  protected List<WorkflowMessage> getTestWorkflowMessageList(final Workflow workflow) {
    return Arrays.asList(this.getTestWorkflowMessage(workflow, "Message-1"),
                         this.getTestWorkflowMessage(workflow, "Message-2"),
                         this.getTestWorkflowMessage(workflow, "Message-3"));
  }

  protected Workflow getTestNewWorkflow() {
    final Workflow model = new Workflow();
    model.setWorkflowType(getTestWorkflowType());
    model.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());
    model.setId(null);
    model.setIdentity(EWorkflowIdentity.NOT_SET.getName());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setController(getTestUser(1L, "fname", "lname", "email1"));
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setCreatedBy(getTestUser(2L, "fname", "lname", "email2"));
    model.setControllerIdentity(model.getController().getEmail());
    model.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    model.setCreatedByIdentity(model.getCreatedBy().getEmail());

    model.setActions(Arrays.asList(this.getTestNewWorkflowAction(), this.getTestNewWorkflowAction(), this.getTestNewWorkflowAction()));
    model.setFiles(Arrays.asList(this.getTestNewWorkflowFile(), this.getTestNewWorkflowFile(), this.getTestNewWorkflowFile()));

    return model;
  }

  protected List<Workflow> getTestWorkflowList() {

    return Arrays.asList(this.getTestWorkflow(1L), this.getTestWorkflow(2L), this.getTestWorkflow(3L));
  }

  protected List<InvoiceWorkflow> getTestInvoiceWorkflowList() {

    return Arrays.asList(this.getTestInvoiceWorkflow(1L), this.getTestInvoiceWorkflow(2L), this.getTestInvoiceWorkflow(3L));
  }

  protected WorkflowAction getTestWorkflowAction(final Long Id, final Long workflowId) {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignTo(1L);
    model.setIdentity("action-" + Id);
    model.setAssignToIdentity("assignToIdentity");
    model.setCurrentStepIdentity("currentStepIdIdentity");

    return model;
  }

  protected List<WorkflowAction> getTestWorkflowActionList(final Long workflowId) {
    return Arrays.asList(this.getTestWorkflowAction(1L, workflowId),
                         this.getTestWorkflowAction(2L, workflowId),
                         this.getTestWorkflowAction(3L, workflowId));
  }

  protected WorkflowAction getTestNewWorkflowAction() {
    final WorkflowAction model = new WorkflowAction();
    model.setWorkflowId(null);
    model.setId(null);
    model.setStatus(1);
    model.setVersion(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignTo(1L);
    model.setIdentity("");

    return model;
  }

  protected WorkflowFile getTestWorkflowFile(final Long Id, final Long workflowId) {
    final WorkflowFile model = new WorkflowFile();
    model.setWorkflowId(workflowId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity("user@iflow.de");
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setExtention("ext");
    model.setIdentity("file-" + Id);

    model.setFileVersions(Arrays.asList(this.getTestWorkflowFileVersion(1L, 1, 1L),
                                        this.getTestWorkflowFileVersion(2L, 2, 1L),
                                        this.getTestWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected List<WorkflowFile> getTestWorkflowFileList(final Long workflowId) {
    return Arrays.asList(this.getTestWorkflowFile(1L, workflowId),
                         this.getTestWorkflowFile(2L, workflowId),
                         this.getTestWorkflowFile(3L, workflowId));
  }

  protected WorkflowFile getTestNewWorkflowFile() {
    final WorkflowFile model = new WorkflowFile();
    model.setWorkflowId(null);
    model.setId(null);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity("user@iflow.de");
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("utest title new");
    model.setExtention("ext");
    model.setIdentity("");

    model.setFileVersions(Arrays.asList(this.getTestNewWorkflowFileVersion(1),
                                        this.getTestNewWorkflowFileVersion(2),
                                        this.getTestNewWorkflowFileVersion(3)));

    return model;
  }

  protected WorkflowFileVersion getTestWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {
    final WorkflowFileVersion model = new WorkflowFileVersion();
    model.setWorkflowFileId(workflowFileId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity("user@iflow.de");
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);
    model.setCreatedBy(getTestUser());

    return model;
  }

  protected WorkflowFileVersion getTestNewWorkflowFileVersion(final int version) {
    final WorkflowFileVersion model = new WorkflowFileVersion();
    model.setWorkflowFileId(null);
    model.setId(null);
    model.setStatus(1);
    model.setVersion(1);
    model.setCreatedByIdentity("user@iflow.de");
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowType getTestWorkflowType() {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setBaseTypeIdentity("baseTypeIdentity");
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setIdentity("workflowtype-1");
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1"),
                                 this.getTestWorkflowTypeStep(2L, "step 2"),
                                 this.getTestWorkflowTypeStep(3L, "step 3")));
    model.setComments("comments");
    model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected WorkflowType getTestWorkflowType(final Long id, final String title) {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setCompanyIdentity("test-companyIdentity");
    model.setBaseTypeIdentity("test-baseTypeIdentity");
    model.setAllowAssign(Boolean.TRUE);
    model.setId(id);
    model.setIdentity("workflowtype-1");
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1"),
                                 this.getTestWorkflowTypeStep(2L, "step 2"),
                                 this.getTestWorkflowTypeStep(3L, "step 3")));
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
    model.setIdentity("workflowtypestep-1");
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");
    model.setViewName("viewName");
    model.setExpireDays(15);

    return model;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep(final Long id, final String title) {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setIdentity("workflowtypestep-1");
    model.setWorkflowTypeId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setStepIndex(1);
    model.setComments("comments");
    model.setViewName("viewName");
    model.setExpireDays(15);

    return model;
  }

  protected List<WorkflowTypeStep> getTestWorkflowTypeStepList() {
    final List<WorkflowTypeStep> list = Arrays.asList(this.getTestWorkflowTypeStep(1L, "WorkflowTypeStep 1"),
                                                      this.getTestWorkflowTypeStep(2L, "WorkflowTypeStep 2"),
                                                      this.getTestWorkflowTypeStep(3L, "WorkflowTypeStep 3"));

    return list;
  }

  protected Set<String> getTestUserGroupIdSet() {
    return new HashSet<String>(Arrays.asList("Group-1", "Group-2", "Group-3"));
  }

  protected Set<String> getTestDepartmentIdSet() {
    return new HashSet<String>(Arrays.asList("dep1", "dep2", "dep3"));
  }

  protected Set<String> getTestDepartmentGroupIdSet() {
    return new HashSet<String>(Arrays.asList("depgrp11", "depgrp11", "depgrp13"));
  }

  protected Set<String> getTestWorkflowTypeIdSet() {
    return new HashSet<String>(Arrays.asList("threetasktype1", "singletasktype1", "invocetasktype1"));
  }

  protected Set<String> getTestDeputiyIdSet() {
    return new HashSet<String>(Arrays.asList("user@iflow.de", "user2@iflow.de", "user3@iflow.de"));
  }

  protected Set<String> getTestUserIdSet() {
    return new HashSet<String>(Arrays.asList("user@iflow.de", "user2@iflow.de", "user3@iflow.de"));
  }

  protected Set<String> getTestWorkflowTypeStepIdSet() {
    return new HashSet<String>(Arrays.asList("threetasktype1step1", "threetasktype1step2", "threetasktype1step3"));
  }

  protected Set<String> getTestWorkflowIdentityList() {

    return new HashSet<String>(Arrays.asList("workflow-1", "workflow-2", "workflow-3"));
  }

  protected WorkflowSearchFilter getTestWorkflowSearchFilter() {
    final WorkflowSearchFilter filter = new WorkflowSearchFilter();
    filter.setAssignedUserIdentitySet(this.getTestUserIdSet());
    filter.setStatusSet(new HashSet<>(Arrays.asList(1, 2, 3)));
    filter.setWorkflowStepIdentitySet(this.getTestWorkflowTypeStepIdSet());
    filter.setWorkflowTypeIdentitySet(this.getTestWorkflowTypeIdSet());

    return filter;
  }

}
