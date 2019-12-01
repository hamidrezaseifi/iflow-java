package com.pth.iflow.core;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserDepartmentEntity;
import com.pth.iflow.core.model.entity.UserDepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserDeputyEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.model.entity.UserUserGroupEntity;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;

public class TestDataProducer {

  protected CompanyEntity getTestCompany() {
    final CompanyEntity company = new CompanyEntity();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentity("identifyid");
    company.setStatus(1);
    company.setVersion(1);

    return company;
  }

  protected ProfileResponse getTestProfileResponse() {
    final CompanyEntity company = getTestCompany();
    final UserEntity user = getTestUser();

    return new ProfileResponse(user, company, getTestDepartmentList(), getTestUserGroupList(), "not-set");
  }

  protected UserEntity getTestUser() {
    final UserEntity model = new UserEntity();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setBirthDate(getTestBirthDate());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestUserDepartmentEntityGroupSet(1L));
    model.setDepartments(this.getTestUserDepartmentEntitySet(1L));
    model.setDeputies(this.getTestUserDeputyEntitySet(1L));
    model.setGroups(this.getTestUserUserGroupEntitySet(1L));
    model.setCompany(getTestCompany());
    // model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected UserEntity getTestNewUser() {
    final UserEntity model = new UserEntity();
    model.setCompanyId(1L);
    model.setId(null);
    model.setEmail("utest email");
    model.setBirthDate(getTestBirthDate());
    model.setFirstName("utest firstName");
    model.setLastName("utest lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestUserDepartmentEntityGroupSet(null));
    model.setDepartments(this.getTestUserDepartmentEntitySet(null));
    model.setDeputies(this.getTestUserDeputyEntitySet(null));
    model.setGroups(this.getTestUserUserGroupEntitySet(null));

    return model;
  }

  protected UserEntity getTestUser(final Long id, final String fname, final String lname, final String email) {
    final UserEntity model = new UserEntity();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestUserDepartmentEntityGroupSet(1L));
    model.setDepartments(this.getTestUserDepartmentEntitySet(1L));
    model.setDeputies(this.getTestUserDeputyEntitySet(1L));
    model.setGroups(this.getTestUserUserGroupEntitySet(1L));
    model.setBirthDate(getTestBirthDate());
    model.setCompany(getTestCompany());

    return model;
  }

  private Date getTestBirthDate() {
    return new Date(Calendar.getInstance().getTime().getTime() - 30 * 365 * 24 * 60 * 60 * 100);
  }

  protected List<UserEntity> getTestUserList() {
    final List<UserEntity> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
        this.getTestUser(2L, "fname 2", "lname 2", "email 2"), this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected DepartmentEntity getTestDepartment() {
    final DepartmentEntity model = new DepartmentEntity();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());
    model.setIdentity("dep-1");

    return model;
  }

  protected DepartmentEntity getTestDepartment(final Long id, final String title) {
    final DepartmentEntity model = new DepartmentEntity();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());
    model.setIdentity("det-1");

    return model;
  }

  protected List<DepartmentEntity> getTestDepartmentList() {
    final List<DepartmentEntity> list = Arrays.asList(this.getTestDepartment(1L, "DepartmentEntity 1"),
        this.getTestDepartment(2L, "DepartmentEntity 2"), this.getTestDepartment(3L, "DepartmentEntity 3"));

    return list;
  }

  protected DepartmentGroupEntity getTestDepartmentGroup() {
    final DepartmentGroupEntity model = new DepartmentGroupEntity();
    model.setDepartmentId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("depgroup-1");

    return model;
  }

  protected DepartmentGroupEntity getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroupEntity model = new DepartmentGroupEntity();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("depgroup-1");

    return model;
  }

  protected List<DepartmentGroupEntity> getTestDepartmentGroupList() {
    final List<DepartmentGroupEntity> list = Arrays.asList(this.getTestDepartmentGroup(1L, "DepartmentGroup 1"),
        this.getTestDepartmentGroup(2L, "DepartmentGroup 2"), this.getTestDepartmentGroup(3L, "DepartmentGroup 3"));

    return list;
  }

  protected UserGroupEntity getTestUserGroup() {
    final UserGroupEntity model = new UserGroupEntity();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-1");

    return model;
  }

  protected UserGroupEntity getTestUserGroup(final Long id, final String title) {
    final UserGroupEntity model = new UserGroupEntity();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-" + id);
    model.setCompany(getTestCompany());

    return model;
  }

  protected List<UserGroupEntity> getTestUserGroupList() {
    final List<UserGroupEntity> list = Arrays.asList(this.getTestUserGroup(1L, "UserGroupEntity 1"),
        this.getTestUserGroup(2L, "UserGroupEntity 2"), this.getTestUserGroup(3L, "UserGroupEntity 3"));

    return list;
  }

  protected WorkflowEntity getTestWorkflow(final Long Id) {
    final WorkflowEntity model = new WorkflowEntity();
    model.setId(Id);
    model.setIdentity(EIdentity.NOT_SET.getIdentity());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setControllerId(1l);
    model.setCurrentStepId(1l);
    model.setCreatedById(1l);
    model.setWorkflowTypeId(1l);
    model.setControllerUser(getTestUser());
    model.setCreatedByUser(getTestUser());
    model.setCurrentStep(getTestWorkflowTypeStep());
    model.setWorkflowType(getTestWorkflowType());

    model.setActions(getTestWorkflowActionList(model));
    model
        .setFiles(Arrays.asList(this.getTestWorkflowFile(1L, 1L), this.getTestWorkflowFile(2L, 2L), this.getTestWorkflowFile(3L, 3L)));

    return model;
  }

  protected InvoiceWorkflowEntity getTestInvoiceWorkflow(final Long Id) {
    final InvoiceWorkflowEntity model = new InvoiceWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    model.setSender("sender");
    model.setRegisterNumber("ext_reg_number");
    model.setInvoceDate(new Date(Calendar.getInstance().getTime().getTime()));
    model.setPartnerCode("partner_code");
    model.setVendorNumber("vendor_number");
    model.setVendorName("vendor_name");
    model.setIsDirectDebitPermission(Boolean.TRUE);
    model.setInvoiceType(EInvoiceType.PAYMENT);
    model.setDiscountEnterDate(new Date(Calendar.getInstance().getTime().getTime()));
    model.setDiscountRate(10.0);
    model.setDiscountDeadline(10);
    model.setDiscountDate(new Date(Calendar.getInstance().getTime().getTime()));
    model.setPaymentAmount(1000.0);

    return model;
  }

  protected SingleTaskWorkflowEntity getTestSingleTaskWorkflow(final Long Id) {
    final SingleTaskWorkflowEntity model = new SingleTaskWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    return model;
  }

  protected TestThreeTaskWorkflowEntity getTestTestThreeTaskWorkflow(final Long Id) {
    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    return model;
  }

  protected WorkflowResultEntity getTestWorkflowResult(final String identity, final String typeIdentity) {
    final WorkflowResultEntity model = new WorkflowResultEntity();

    model.setIdentity(identity);
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setWorkflowTypeIdentity(typeIdentity);
    model.setControllerIdentity("ControllerIdentity");
    model.setCurrentStepIdentity("currentStepIdentity");
    model.setCreatedByIdentity("createdByIdentity");

    return model;
  }

  protected InvoiceWorkflowEntity getTestNewInvoiceWorkflow() {
    final InvoiceWorkflowEntity model = getTestInvoiceWorkflow(0L);
    model.setWorkflow(getTestNewWorkflow());
    model.setWorkflowId(null);

    for (final WorkflowActionEntity action : model.getWorkflow().getActions()) {
      action.setIdentity("");
    }
    for (final WorkflowFileEntity file : model.getWorkflow().getFiles()) {
      file.setIdentity("");
    }

    model.getWorkflow().getCurrentStep().setIdentity("invocetasktypestep1");
    model.getWorkflow().setControllerId(null);
    model.getWorkflow().setWorkflowTypeId(null);
    model.getWorkflow().setCreatedById(null);
    model.getWorkflow().setCurrentStepId(null);
    model.getWorkflow().getControllerUser().setIdentity("admin@iflow.de");
    model.getWorkflow().getCreatedByUser().setIdentity("admin@iflow.de");

    return model;
  }

  protected WorkflowMessageEntity getTestWorkflowMessage(final WorkflowEntity workflow, final String message) {
    final WorkflowMessageEntity model = new WorkflowMessageEntity();

    model.setId(null);
    model.setWorkflow(workflow);
    model.setMessage(message);
    model.setStatus(EWorkflowMessageStatus.OFFERING.getValue());
    model.setVersion(1);
    model.setExpireDays(10);
    model.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW.getValue());
    model.setUserId(1L);
    model.setCreatedBy(1L);
    model.setUserId(1L);
    model.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
    model.setMessage("title test");
    model.setStepId(workflow.getCurrentStepId());

    return model;
  }

  protected List<WorkflowMessageEntity> getTestWorkflowMessageList(final WorkflowEntity workflow) {
    return Arrays.asList(this.getTestWorkflowMessage(workflow, "Message-1"), this.getTestWorkflowMessage(workflow, "Message-2"),
        this.getTestWorkflowMessage(workflow, "Message-3"));
  }

  protected WorkflowEntity getTestNewWorkflow() {
    final WorkflowEntity model = new WorkflowEntity();
    model.getWorkflowType().setIdentity("wtidentity");
    model.setWorkflowTypeId(1L);
    model.setId(null);
    model.setIdentity(EIdentity.NOT_SET.getIdentity());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setControllerId(1l);
    model.setCurrentStepId(1l);
    model.setCreatedById(1l);
    // model.setControllerIdentity("ControllerIdentity");
    // model.setCurrentStepIdentity("currentStepIdentity");
    // model.setCreatedByIdentity("createdByIdentity");
    model.setWorkflowTypeId(1l);

    model.setActions(Arrays.asList(this.getTestNewWorkflowAction(model), this.getTestNewWorkflowAction(model),
        this.getTestNewWorkflowAction(model)));
    model.setFiles(
        Arrays.asList(this.getTestNewWorkflowFile(model), this.getTestNewWorkflowFile(model), this.getTestNewWorkflowFile(model)));

    return model;
  }

  protected SingleTaskWorkflowEntity getTestNewSingleTaskWorkflowWorkflow() {
    final SingleTaskWorkflowEntity model = new SingleTaskWorkflowEntity();

    model.setWorkflowId(null);
    model.setWorkflow(getTestNewWorkflow());

    return model;
  }

  protected TestThreeTaskWorkflowEntity getTestNewTestThreeTaskWorkflow() {
    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();

    model.setWorkflowId(null);
    model.setWorkflow(getTestNewWorkflow());

    return model;
  }

  protected List<WorkflowEntity> getTestWorkflowList() {

    return Arrays.asList(this.getTestWorkflow(1L), this.getTestWorkflow(2L), this.getTestWorkflow(3L));
  }

  protected List<InvoiceWorkflowEntity> getTestInvoiceWorkflowList() {

    return Arrays.asList(this.getTestInvoiceWorkflow(1L), this.getTestInvoiceWorkflow(2L), this.getTestInvoiceWorkflow(3L));
  }

  protected List<SingleTaskWorkflowEntity> getTestSingleTaskWorkflowList() {

    return Arrays.asList(this.getTestSingleTaskWorkflow(1L), this.getTestSingleTaskWorkflow(2L), this.getTestSingleTaskWorkflow(3L));
  }

  protected List<TestThreeTaskWorkflowEntity> getTestTestThreeWorkflowList() {

    return Arrays.asList(this.getTestTestThreeTaskWorkflow(1L), this.getTestTestThreeTaskWorkflow(2L),
        this.getTestTestThreeTaskWorkflow(3L));
  }

  protected List<WorkflowResultEntity> getTestWorkflowResultList() {

    return Arrays.asList(getTestWorkflowResult("workflow1", "type1"), getTestWorkflowResult("workflow2", "type2"),
        getTestWorkflowResult("workflow3", "type3"));
  }

  protected WorkflowActionEntity getTestWorkflowAction(final Long Id, final WorkflowEntity workflow) {
    final WorkflowActionEntity model = new WorkflowActionEntity();
    model.setWorkflow(workflow);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignTo(1L);
    model.setIdentity("action-" + Id);
    model.setCurrentStep(getTestWorkflowTypeStep());
    // model.setAssignToIdentity("assignToIdentity");
    // model.setCurrentStepIdentity("currentStepIdIdentity");

    return model;
  }

  protected List<WorkflowActionEntity> getTestWorkflowActionList(final WorkflowEntity workflow) {
    return Arrays.asList(this.getTestWorkflowAction(1L, workflow), this.getTestWorkflowAction(2L, workflow),
        this.getTestWorkflowAction(3L, workflow));
  }

  protected WorkflowActionEntity getTestNewWorkflowAction(final WorkflowEntity workflow) {
    final WorkflowActionEntity model = new WorkflowActionEntity();

    model.setId(null);
    model.setWorkflow(workflow);
    model.setStatus(1);
    model.setVersion(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignTo(1L);
    model.setIdentity("");

    return model;
  }

  protected WorkflowFileEntity getTestWorkflowFile(final Long Id, final Long workflowId) {
    final WorkflowFileEntity model = new WorkflowFileEntity();
    model.getWorkflow().setId(workflowId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.getCreatedByUser().setIdentity("user@iflow.de");
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setExtention("ext");
    model.setIdentity("file-" + Id);

    model.setFileVersions(Arrays.asList(this.getTestWorkflowFileVersion(1L, 1, 1L), this.getTestWorkflowFileVersion(2L, 2, 1L),
        this.getTestWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected List<WorkflowFileEntity> getTestWorkflowFileList(final Long workflowId) {
    return Arrays.asList(this.getTestWorkflowFile(1L, workflowId), this.getTestWorkflowFile(2L, workflowId),
        this.getTestWorkflowFile(3L, workflowId));
  }

  protected WorkflowFileEntity getTestNewWorkflowFile(final WorkflowEntity workflow) {
    final WorkflowFileEntity model = new WorkflowFileEntity();
    model.setWorkflow(workflow);
    model.setId(null);
    model.setStatus(1);
    model.setVersion(1);
    model.getCreatedByUser().setIdentity("user@iflow.de");
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("utest title new");
    model.setExtention("ext");
    model.setIdentity("");

    model.setFileVersions(Arrays.asList(this.getTestNewWorkflowFileVersion(1), this.getTestNewWorkflowFileVersion(2),
        this.getTestNewWorkflowFileVersion(3)));

    return model;
  }

  protected WorkflowFileVersionEntity getTestWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {
    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();
    // model.setWorkflowFileId(workflowFileId);
    model.setId(Id);
    model.setStatus(1);
    model.setVersion(1);
    model.getCreatedByUser().setIdentity("user@iflow.de");
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);
    model.setCreatedByUser(getTestUser());

    return model;
  }

  protected WorkflowFileVersionEntity getTestNewWorkflowFileVersion(final int version) {
    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();
    // model.setWorkflowFileId(null);
    model.setId(null);
    model.setStatus(1);
    model.setVersion(1);
    model.getCreatedByUser().setIdentity("user@iflow.de");
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowTypeEntity getTestWorkflowType() {
    final WorkflowTypeEntity model = new WorkflowTypeEntity();
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
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1"), this.getTestWorkflowTypeStep(2L, "step 2"),
        this.getTestWorkflowTypeStep(3L, "step 3")));
    model.setComments("comments");
    // model.setCompanyIdentity("companyIdentity");
    model.setCompanyId(1L);

    return model;
  }

  protected WorkflowTypeEntity getTestWorkflowType(final Long id, final String title) {
    final WorkflowTypeEntity model = new WorkflowTypeEntity();
    model.setCompanyId(1L);
    // model.setCompanyIdentity("companyIdentity");
    model.setCompanyId(1L);
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
    model.setSteps(Arrays.asList(this.getTestWorkflowTypeStep(1L, "step 1"), this.getTestWorkflowTypeStep(2L, "step 2"),
        this.getTestWorkflowTypeStep(3L, "step 3")));
    model.setComments("comments");

    return model;
  }

  protected List<WorkflowTypeEntity> getTestWorkflowTypeList() {
    final List<WorkflowTypeEntity> list = Arrays.asList(this.getTestWorkflowType(1L, "WorkflowTypeEntity 1"),
        this.getTestWorkflowType(2L, "WorkflowTypeEntity 2"), this.getTestWorkflowType(3L, "WorkflowTypeEntity 3"));

    return list;
  }

  protected WorkflowTypeStepEntity getTestWorkflowTypeStep() {
    final WorkflowTypeStepEntity model = new WorkflowTypeStepEntity();
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

  protected WorkflowTypeStepEntity getTestWorkflowTypeStep(final Long id, final String title) {
    final WorkflowTypeStepEntity model = new WorkflowTypeStepEntity();
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

  protected List<WorkflowTypeStepEntity> getTestWorkflowTypeStepList() {
    final List<WorkflowTypeStepEntity> list = Arrays.asList(this.getTestWorkflowTypeStep(1L, "WorkflowTypeStepEntity 1"),
        this.getTestWorkflowTypeStep(2L, "WorkflowTypeStepEntity 2"), this.getTestWorkflowTypeStep(3L, "WorkflowTypeStepEntity 3"));

    return list;
  }

  protected Set<UserDepartmentGroupEntity> getTestUserDepartmentEntityGroupSet(final Long userId) {
    return new HashSet<UserDepartmentGroupEntity>(Arrays.asList(getTestUserDepartmentGroupEntity(userId, 1L),
        getTestUserDepartmentGroupEntity(userId, 2L), getTestUserDepartmentGroupEntity(userId, 3L)));
  }

  private UserDepartmentGroupEntity getTestUserDepartmentGroupEntity(final Long userId, final Long departmentGroupId) {
    final UserDepartmentGroupEntity model = new UserDepartmentGroupEntity();
    model.setDepartmentGroupId(departmentGroupId);
    model.setUserId(userId);
    model.setDepartmentGroup(getTestDepartmentGroup());
    return model;
  }

  protected Set<UserDepartmentEntity> getTestUserDepartmentEntitySet(final Long userId) {
    return new HashSet<UserDepartmentEntity>(Arrays.asList(getTestUserDepartmentEntity(userId, 1L),
        getTestUserDepartmentEntity(userId, 2L), getTestUserDepartmentEntity(userId, 3L)));
  }

  private UserDepartmentEntity getTestUserDepartmentEntity(final Long userId, final Long departmentId) {
    final UserDepartmentEntity model = new UserDepartmentEntity();
    model.setDepartmentId(departmentId);
    model.setUserId(userId);
    model.setDepartment(getTestDepartment());
    return model;
  }

  protected Set<UserUserGroupEntity> getTestUserUserGroupEntitySet(final Long userId) {
    return new HashSet<UserUserGroupEntity>(Arrays.asList(getTestUserUserGroupEntity(userId, 1L),
        getTestUserUserGroupEntity(userId, 2L), getTestUserUserGroupEntity(userId, 3L)));
  }

  private UserUserGroupEntity getTestUserUserGroupEntity(final Long userId, final Long userGroupId) {
    final UserUserGroupEntity model = new UserUserGroupEntity();
    model.setUserGroupId(userGroupId);
    model.setUserId(userId);
    model.setUserGroup(getTestUserGroup());
    return model;
  }

  protected Set<UserDeputyEntity> getTestUserDeputyEntitySet(final Long userId) {
    return new HashSet<UserDeputyEntity>(
        Arrays.asList(getTestUserDeputyEntity(userId, 1L), getTestUserDeputyEntity(userId, 2L), getTestUserDeputyEntity(userId, 3L)));
  }

  private UserDeputyEntity getTestUserDeputyEntity(final Long userId, final Long deputyId) {
    final UserDeputyEntity model = new UserDeputyEntity();
    model.setDeputyId(deputyId);
    model.setUserId(userId);
    model.setDeputy(new UserEntity());
    model.getDeputy().setIdentity("deputy-identity");
    return model;
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
