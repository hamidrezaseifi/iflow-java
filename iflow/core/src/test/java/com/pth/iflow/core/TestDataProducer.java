package com.pth.iflow.core;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.enums.ECompanyType;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EOcrType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowTypeControllerEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetItemEdo;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserDepartmentEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserGroupEdo;
import com.pth.iflow.common.models.edo.WorkflowActionEdo;
import com.pth.iflow.common.models.edo.WorkflowFileEdo;
import com.pth.iflow.common.models.edo.WorkflowFileVersionEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageEdo;
import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserDepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
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
    company.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.name());
    company.setCompanyTypeCustome("companyTypeCustome");

    return company;
  }

  protected CompanyEdo getTestCompanyEdo() {

    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName("companyName");
    edo.setIdentity("identifyid");
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.name());
    edo.setCompanyTypeCustome("companyTypeCustome");

    return edo;
  }

  protected ProfileResponse getTestProfileResponse() {

    final CompanyEntity company = getTestCompany();
    final UserEntity user = getTestUser();

    return new ProfileResponse(user, company, getTestDepartmentList(), getTestUserGroupList(),
        getTestCompanyWorkflowtypeItemOcrSettingPresetEntityList(),
        "not-set");
  }

  protected List<CompanyWorkflowtypeItemOcrSettingPresetEntity> getTestCompanyWorkflowtypeItemOcrSettingPresetEntityList() {

    return Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingPresetEntity("prop1", getTestWorkflowType(), getTestCompany()),
            getTestCompanyWorkflowtypeItemOcrSettingPresetEntity("prop2", getTestWorkflowType(), getTestCompany()),
            getTestCompanyWorkflowtypeItemOcrSettingPresetEntity("prop3", getTestWorkflowType(), getTestCompany()));
  }

  protected List<CompanyWorkflowtypeItemOcrSettingPresetEdo> getTestCompanyWorkflowtypeItemOcrSettingPresetEdoList() {

    return Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop1"),
            getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop2"),
            getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop3"));
  }

  protected ProfileResponseEdo getTestProfileResponseEdo() {

    final CompanyEdo company = getTestCompanyEdo();
    final UserEdo user = getTestUserEdo();

    final CompanyProfileEdo companyProfileEdo = new CompanyProfileEdo(company, getTestDepartmentEdoList(), getTestUserGroupEdoList(),
        getTestCompanyWorkflowTypeControllerEdoList(),
        Arrays
            .asList(getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop1"), getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop2"),
                getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("prop3")));
    return new ProfileResponseEdo(user, companyProfileEdo, "not-set");
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

  protected CompanyWorkflowtypeItemOcrSettingPresetEdo getTestCompanyWorkflowtypeItemOcrSettingPresetEdo(final String presetName) {

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edo = new CompanyWorkflowtypeItemOcrSettingPresetEdo();
    edo.setCompanyIdentity("companyIdentity");
    edo.setStatus(1);
    edo.setPresetName(presetName);
    edo.setVersion(1);
    edo.setWorkflowTypeIdentity("workflowIdentity");
    edo
        .setItems(Arrays
            .asList(getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-1"),
                getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-2"),
                getTestCompanyWorkflowtypeItemOcrSettingPresetItemEdo("prop-3")));

    return edo;
  }

  protected CompanyWorkflowtypeItemOcrSettingPresetItemEntity
      getTestCompanyWorkflowtypeItemOcrSettingPresetItemEntity(final String propName) {

    final CompanyWorkflowtypeItemOcrSettingPresetItemEntity edo = new CompanyWorkflowtypeItemOcrSettingPresetItemEntity();
    edo.setPropertyName(propName);
    edo.setStatus(1);
    edo.setValue("value");
    edo.setVersion(1);
    edo.setOcrType(EOcrType.SEARCH_WORD.getValue());

    return edo;
  }

  protected CompanyWorkflowtypeItemOcrSettingPresetEntity getTestCompanyWorkflowtypeItemOcrSettingPresetEntity(final String presetName,
      final WorkflowTypeEntity workflowType,
      final CompanyEntity company) {

    final CompanyWorkflowtypeItemOcrSettingPresetEntity model = new CompanyWorkflowtypeItemOcrSettingPresetEntity();
    model.setPresetName(presetName);
    model.setStatus(1);
    model.setVersion(1);
    model.setWorkflowType(workflowType);
    model.setCompany(company);
    model
        .setItems(Arrays
            .asList(getTestCompanyWorkflowtypeItemOcrSettingPresetItemEntity("prop-1"),
                getTestCompanyWorkflowtypeItemOcrSettingPresetItemEntity("prop-2"),
                getTestCompanyWorkflowtypeItemOcrSettingPresetItemEntity("prop-3")));

    return model;
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

    model.addUserDepartment(getTestUserDepartmentEntity());
    model.addUserDepartment(getTestUserDepartmentEntity());

    model.setDeputies(Arrays.asList());
    model.setGroups(Arrays.asList(getTestUserGroup(1L, "grp1"), getTestUserGroup(2L, "grp2")));
    model.setCompany(getTestCompany());
    model.setIdentity("identity");
    // model.setCompanyIdentity("companyIdentity");

    return model;
  }

  private UserDepartmentEntity getTestUserDepartmentEntity() {

    final UserDepartmentEntity userDepartmentEntity = new UserDepartmentEntity();

    userDepartmentEntity.setDepartment(getTestDepartment());

    userDepartmentEntity.setMemberType(5);
    return userDepartmentEntity;
  }

  protected UserEdo getTestUserEdo() {

    final UserEdo edo = new UserEdo();
    edo.setCompanyIdentity("companyIdentity");
    edo.setEmail("email");
    edo.setBirthDate(LocalDate.now().minusYears(30));
    edo.setFirstName("firstName");
    edo.setLastName("lastName");
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setPermission(1);
    edo.setUserDepartments(Arrays.asList(new UserDepartmentEdo("dep1", 5), new UserDepartmentEdo("dep2", 5)));
    edo.setDeputies(this.getTestDepartmentIdSet());
    edo.setGroups(this.getTestUserGroupIdSet());
    edo.setIdentity("identity");

    return edo;
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

    model.setDeputies(Arrays.asList(getTestUser(1L, "fname", "lname", "email")));
    model.setGroups(Arrays.asList(getTestUserGroup(1L, "grp1"), getTestUserGroup(2L, "grp2")));
    // model.setRolesFromIntegerList(Arrays.asList(1, 2, 3));

    model.setGroups(new ArrayList<>());
    model.setUserDepartments(new HashSet<>());
    model.setDeputies(new ArrayList<>());
    // model.setRoles(new ArrayList<>());

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

    model.setDeputies(Arrays.asList(getTestUser()));
    model.setGroups(Arrays.asList(getTestUserGroup(1L, "grp1"), getTestUserGroup(2L, "grp2")));
    model.setBirthDate(getTestBirthDate());
    model.setCompany(getTestCompany());
    model.setIdentity("identity" + id);

    return model;
  }

  protected UserEdo getTestUserEdo(final Long id, final String fname, final String lname, final String email) {

    final UserEdo edo = new UserEdo();

    edo.setEmail(email);
    edo.setFirstName(fname);
    edo.setLastName(lname);
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setPermission(1);
    edo.setUserDepartments(Arrays.asList(new UserDepartmentEdo("dep1", 5), new UserDepartmentEdo("dep2", 5)));
    edo.setDeputies(this.getTestDepartmentIdSet());
    edo.setGroups(this.getTestUserGroupIdSet());
    edo.setBirthDate(LocalDate.now().minusYears(30));
    edo.setCompanyIdentity("companyIdentity");
    edo.setIdentity("identity" + id);

    return edo;
  }

  private Date getTestBirthDate() {

    return new Date(Calendar.getInstance().getTime().getTime() - 30 * 365 * 24 * 60 * 60 * 100);
  }

  protected List<UserEntity> getTestUserList() {

    final List<UserEntity> list = Arrays
        .asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
            this.getTestUser(2L, "fname 2", "lname 2", "email 2"), this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected List<UserEdo> getTestUserEdoList() {

    final List<UserEdo> list = Arrays
        .asList(this.getTestUserEdo(1L, "fname 1", "lname 1", "email 1"),
            this.getTestUserEdo(2L, "fname 2", "lname 2", "email 2"), this.getTestUserEdo(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected DepartmentEntity getTestDepartment() {

    final DepartmentEntity model = new DepartmentEntity();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("dep-1");

    return model;
  }

  protected DepartmentEntity getTestDepartmentForSave() {

    final DepartmentEntity model = new DepartmentEntity();
    model.setCompanyId(1L);
    model.setId(null);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("dep-1");

    return model;
  }

  protected DepartmentEdo getTestDepartmentEdo() {

    final DepartmentEdo edo = new DepartmentEdo();

    edo.setTitle("utest title");
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setIdentity("dep-1");
    edo.setCompanyIdentity("companyIdentity");

    return edo;
  }

  protected DepartmentEntity getTestDepartment(final Long id, final String title) {

    final DepartmentEntity model = new DepartmentEntity();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("det-1");

    return model;
  }

  protected DepartmentEdo getTestDepartmentEdo(final Long id, final String title) {

    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(title);
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setIdentity("det-1");
    edo.setCompanyIdentity("companyIdentity");

    return edo;
  }

  protected List<DepartmentEntity> getTestDepartmentList() {

    final List<DepartmentEntity> list = Arrays
        .asList(this.getTestDepartment(1L, "DepartmentEntity 1"),
            this.getTestDepartment(2L, "DepartmentEntity 2"));

    return list;
  }

  protected List<DepartmentEdo> getTestDepartmentEdoList() {

    final List<DepartmentEdo> list = Arrays
        .asList(this.getTestDepartmentEdo(1L, "DepartmentEntity 1"),
            this.getTestDepartmentEdo(2L, "DepartmentEntity 2"));

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
    model.setCompany(getTestCompany());

    return model;
  }

  protected UserGroupEdo getTestUserGroupEdo() {

    final UserGroupEdo model = new UserGroupEdo();
    model.setCompanyIdentity("companyIdentity");
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-1");

    return model;
  }

  protected UserGroupEdo getTestUserGroupEdo(final Long id, final String title) {

    final UserGroupEdo model = new UserGroupEdo();
    model.setCompanyIdentity("companyIdentity");
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setIdentity("usergroup-" + id);

    return model;
  }

  protected CompanyWorkflowTypeControllerEdo getTestCompanyWorkflowTypeControllerEdo() {

    final CompanyWorkflowTypeControllerEdo model = new CompanyWorkflowTypeControllerEdo();
    model.setPriority(1);
    model.setUserIdentity("userIdentity");
    model.setWorkflowTypeIdentity("workflowTypeIdentity");

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

    final List<UserGroupEntity> list = Arrays
        .asList(this.getTestUserGroup(1L, "UserGroupEntity 1"),
            this.getTestUserGroup(2L, "UserGroupEntity 2"));

    return list;
  }

  protected List<UserGroupEdo> getTestUserGroupEdoList() {

    final List<UserGroupEdo> list = Arrays
        .asList(this.getTestUserGroupEdo(1L, "UserGroupEntity 1"),
            this.getTestUserGroupEdo(2L, "UserGroupEntity 2"));

    return list;
  }

  protected List<CompanyWorkflowTypeControllerEdo> getTestCompanyWorkflowTypeControllerEdoList() {

    final List<CompanyWorkflowTypeControllerEdo> list = Arrays
        .asList(this.getTestCompanyWorkflowTypeControllerEdo(),
            this.getTestCompanyWorkflowTypeControllerEdo(), this.getTestCompanyWorkflowTypeControllerEdo());

    return list;
  }

  protected WorkflowEntity getTestWorkflow(final Long Id) {

    final WorkflowEntity model = new WorkflowEntity();
    model.setId(Id);
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");
    model.setIdentity("workflow-1");
    model.setCompany(getTestCompany());
    model.setCompanyId(1L);
    model.setControllerId(1L);
    model.setCreatedById(1L);
    model.setCurrentStepId(1L);
    model.setWorkflowTypeId(1L);

    model.setActions(getTestWorkflowActionList(model));
    model
        .setFiles(
            Arrays.asList(this.getTestWorkflowFile(1L, model), this.getTestWorkflowFile(2L, model), this.getTestWorkflowFile(3L, model)));

    return model;
  }

  protected WorkflowEdo getTestWorkflowEdo() {

    final WorkflowEdo edo = new WorkflowEdo();

    edo.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    edo.setVersion(1);
    edo.setComments("comments");
    edo.setIdentity("workflow-1");

    edo.setControllerIdentity("controllerIdentity");
    edo.setCompanyIdentity("companyIdentity");
    edo.setCreatedByIdentity("createdByIdentity");
    edo.setCurrentStepIdentity("currentStepIdentity");
    edo.setWorkflowTypeIdentity("workflowTypeIdentity");

    edo.setActions(getTestWorkflowActionEdoList());
    edo.setFiles(Arrays.asList(this.getTestWorkflowFileEdo(1L), this.getTestWorkflowFileEdo(2L), this.getTestWorkflowFileEdo(3L)));

    return edo;
  }

  protected InvoiceWorkflowEntity getTestInvoiceWorkflow(final Long Id) {

    final InvoiceWorkflowEntity model = new InvoiceWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    model.setSender("sender");
    model.setRegisterNumber("ext_reg_number");
    model.setInvoiceDate(new Date(Calendar.getInstance().getTime().getTime()));
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

  protected InvoiceWorkflowEdo getTestInvoiceWorkflowEdo() {

    final InvoiceWorkflowEdo model = new InvoiceWorkflowEdo();
    model.setWorkflow(getTestWorkflowEdo());

    model.setSender("sender");
    model.setRegisterNumber("ext_reg_number");
    model.setInvoiceDate(LocalDate.now());
    model.setPartnerCode("partner_code");
    model.setVendorNumber("vendor_number");
    model.setVendorName("vendor_name");
    model.setIsDirectDebitPermission(Boolean.TRUE);
    model.setInvoiceType(EInvoiceType.PAYMENT.getValue());
    model.setDiscountEnterDate(LocalDate.now());
    model.setDiscountRate(10.0);
    model.setDiscountDeadline(10);
    model.setDiscountDate(LocalDate.now());
    model.setPaymentAmount(1000.0);

    return model;
  }

  protected SingleTaskWorkflowEntity getTestSingleTaskWorkflow(final Long Id) {

    final SingleTaskWorkflowEntity model = new SingleTaskWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    return model;
  }

  protected SingleTaskWorkflowEdo getTestSingleTaskWorkflowEdo() {

    final SingleTaskWorkflowEdo model = new SingleTaskWorkflowEdo();
    model.setWorkflow(getTestWorkflowEdo());

    return model;
  }

  protected TestThreeTaskWorkflowEntity getTestTestThreeTaskWorkflow(final Long Id) {

    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();
    model.setWorkflow(getTestWorkflow(Id));
    model.setWorkflowId(Id);

    return model;
  }

  protected TestThreeTaskWorkflowEdo getTestTestThreeTaskWorkflowEdo() {

    final TestThreeTaskWorkflowEdo edo = new TestThreeTaskWorkflowEdo();
    edo.setWorkflow(getTestWorkflowEdo());

    return edo;
  }

  protected InvoiceWorkflowEntity getTestNewInvoiceWorkflow() {

    final InvoiceWorkflowEntity model = getTestInvoiceWorkflow(0L);
    model.setWorkflow(getTestNewWorkflowForSave());

    model.getWorkflow().setControllerId(1L);
    model.getWorkflow().setCreatedById(1L);
    model.getWorkflow().setCurrentStepId(1L);
    model.getWorkflow().setWorkflowTypeId(1L);

    return model;
  }

  protected WorkflowMessageEntity getTestWorkflowMessage(final WorkflowEntity workflow, final String message) {

    final WorkflowMessageEntity model = new WorkflowMessageEntity();

    model.setId(null);
    model.setWorkflowId(workflow.getId());
    model.setMessage(message);
    model.setStatus(EWorkflowMessageStatus.OFFERING.getValue());
    model.setVersion(1);
    model.setExpireDays(10);
    model.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW.getValue());
    model.setUserId(1L);
    model.setCreatedById(1L);
    model.setUserId(1L);
    model.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
    model.setMessage("title test");
    model.setStepId(workflow.getCurrentStepId());

    return model;
  }

  protected WorkflowMessageEdo getTestWorkflowMessageEdo(final WorkflowEntity workflow, final String message) {

    final WorkflowMessageEdo model = new WorkflowMessageEdo();

    model.setWorkflowIdentity(workflow.getIdentity());
    model.setMessage(message);
    model.setStatus(EWorkflowMessageStatus.OFFERING.getValue());
    model.setVersion(1);
    model.setExpireDays(10);
    model.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW.getValue());
    model.setUserIdentity("userIdentity");
    model.setCreatedByIdentity("createdByIdentity");
    model.setCreatedAt(LocalDateTime.now());
    model.setMessage("title test");
    model.setStepIdentity("stepIdentity");

    return model;
  }

  protected List<WorkflowMessageEntity> getTestWorkflowMessageList(final WorkflowEntity workflow) {

    return Arrays
        .asList(this.getTestWorkflowMessage(workflow, "Message-1"), this.getTestWorkflowMessage(workflow, "Message-2"),
            this.getTestWorkflowMessage(workflow, "Message-3"));
  }

  protected List<WorkflowMessageEdo> getTestWorkflowMessageEdoist(final WorkflowEntity workflow) {

    return Arrays
        .asList(getTestWorkflowMessageEdo(workflow, "message-1"), getTestWorkflowMessageEdo(workflow, "message-2"),
            getTestWorkflowMessageEdo(workflow, "message-3"));
  }

  protected WorkflowEntity getTestNewWorkflow() {

    final WorkflowEntity model = new WorkflowEntity();
    model.setId(null);
    model.setIdentity(EIdentity.NOT_SET.getIdentity());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");

    model.setControllerId(1L);
    model.setCreatedById(1L);
    model.setCurrentStepId(1L);
    model.setWorkflowTypeId(1L);

    model.setActions(getTestWorkflowActionList(model));
    model
        .setFiles(
            Arrays.asList(this.getTestWorkflowFile(1L, model), this.getTestWorkflowFile(2L, model), this.getTestWorkflowFile(3L, model)));

    return model;
  }

  protected WorkflowEntity getTestNewWorkflowForSave() {

    final WorkflowEntity model = new WorkflowEntity();
    model.setId(null);
    model.setIdentity(EIdentity.NOT_SET.getIdentity());
    model.setStatus(EWorkflowStatus.INITIALIZE.getValue().intValue());
    model.setVersion(1);
    model.setComments("comments");

    model.setControllerId(1L);
    model.setCreatedById(1L);
    model.setCurrentStepId(1L);
    model.setWorkflowTypeId(1L);
    model.setCompanyId(1L);

    model.setActions(Arrays.asList(this.getTestWorkflowActionForSave(model)));
    model.setFiles(Arrays.asList(this.getTestWorkflowFileForSave(model)));

    return model;
  }

  protected TestThreeTaskWorkflowEntity getTestTestThreeTaskWorkflowEntityForSave() {

    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();
    model.setWorkflow(getTestNewWorkflowForSave());
    model.setWorkflowId(null);
    return model;
  }

  protected SingleTaskWorkflowEntity getTestSingleTaskWorkflowEntityForSave() {

    final SingleTaskWorkflowEntity model = new SingleTaskWorkflowEntity();
    model.setWorkflow(getTestNewWorkflowForSave());
    model.setWorkflowId(null);
    return model;
  }

  protected InvoiceWorkflowEntity getTestInvoiceWorkflowEntityForSave() {

    final InvoiceWorkflowEntity model = getTestNewInvoiceWorkflow();
    model.setWorkflow(getTestNewWorkflowForSave());
    model.setWorkflowId(null);
    return model;
  }

  protected WorkflowActionEntity getTestWorkflowActionForSave(final WorkflowEntity workflow) {

    final WorkflowActionEntity model = new WorkflowActionEntity();
    model.setWorkflowEntity(workflow);
    model.setId(null);
    model.setStatus(1);
    model.setComments("comments");
    model.setAssignToId(1L);
    model.setCurrentStepId(1L);

    return model;
  }

  protected WorkflowFileEntity getTestWorkflowFileForSave(final WorkflowEntity workflow) {

    final WorkflowFileEntity model = new WorkflowFileEntity();
    model.setWorkflowEntity(workflow);
    model.setId(null);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title ");
    model.setExtention("ext");

    model.setFileVersions(Arrays.asList(this.getTestWorkflowFileVersionForSave(model)));

    return model;
  }

  protected WorkflowFileVersionEntity getTestWorkflowFileVersionForSave(final WorkflowFileEntity workflowFileEntity) {

    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();
    model.setWorkflowFileEntity(workflowFileEntity);
    model.setId(null);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(1);

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

    return Arrays
        .asList(this.getTestTestThreeTaskWorkflow(1L), this.getTestTestThreeTaskWorkflow(2L), this.getTestTestThreeTaskWorkflow(3L));
  }

  protected List<TestThreeTaskWorkflowEdo> getTestTestThreeWorkflowEdoList() {

    return Arrays
        .asList(this.getTestTestThreeTaskWorkflowEdo(), this.getTestTestThreeTaskWorkflowEdo(),
            this.getTestTestThreeTaskWorkflowEdo());
  }

  protected List<SingleTaskWorkflowEdo> getTestSingleTaskWorkflowEdoList() {

    return Arrays.asList(this.getTestSingleTaskWorkflowEdo(), this.getTestSingleTaskWorkflowEdo(), this.getTestSingleTaskWorkflowEdo());
  }

  protected List<InvoiceWorkflowEdo> getTestInvoiceWorkflowEdoList() {

    return Arrays.asList(this.getTestInvoiceWorkflowEdo(), this.getTestInvoiceWorkflowEdo(), this.getTestInvoiceWorkflowEdo());
  }

  protected WorkflowActionEntity getTestWorkflowAction(final Long Id, final WorkflowEntity workflow) {

    final WorkflowActionEntity model = new WorkflowActionEntity();
    model.setWorkflowEntity(workflow);
    model.setId(Id);
    model.setStatus(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignToId(1L);
    model.setCurrentStepId(1L);

    // model.setAssignToIdentity("assignToIdentity");
    // model.setCurrentStepIdentity("currentStepIdIdentity");

    return model;
  }

  protected WorkflowActionEdo getTestWorkflowActionEdo() {

    final WorkflowActionEdo edo = new WorkflowActionEdo();

    edo.setStatus(1);
    edo.setCurrentStepIdentity("currectStepIdentity");
    edo.setComments("comments");
    edo.setAssignToIdentity("assignToIdentity");
    edo.setCurrentStepIdentity("currectStepIdentity");

    return edo;
  }

  protected List<WorkflowActionEntity> getTestWorkflowActionList(final WorkflowEntity workflow) {

    return Arrays
        .asList(this.getTestWorkflowAction(1L, workflow), this.getTestWorkflowAction(2L, workflow),
            this.getTestWorkflowAction(3L, workflow));
  }

  protected List<WorkflowActionEdo> getTestWorkflowActionEdoList() {

    return Arrays.asList(this.getTestWorkflowActionEdo(), this.getTestWorkflowActionEdo(), this.getTestWorkflowActionEdo());
  }

  protected WorkflowActionEntity getTestNewWorkflowAction(final WorkflowEntity workflow) {

    final WorkflowActionEntity model = new WorkflowActionEntity();

    model.setId(null);
    model.setWorkflowEntity(workflow);
    model.setStatus(1);
    model.setCurrentStepId(1L);
    model.setComments("comments");
    model.setAssignToId(1L);

    return model;
  }

  protected WorkflowFileEntity getTestWorkflowFile(final Long Id, final WorkflowEntity workflow) {

    final WorkflowFileEntity model = new WorkflowFileEntity();
    model.setWorkflowEntity(workflow);
    model.setId(Id);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("title " + Id);
    model.setExtention("ext");
    model.setIdentity("file-identity");

    model
        .setFileVersions(Arrays
            .asList(this.getTestWorkflowFileVersion(1L, 1, 1L), this.getTestWorkflowFileVersion(2L, 2, 1L),
                this.getTestWorkflowFileVersion(3L, 3, 1L)));

    return model;
  }

  protected WorkflowFileEdo getTestWorkflowFileEdo(final Long Id) {

    final WorkflowFileEdo edo = new WorkflowFileEdo();

    edo.setStatus(1);
    edo.setCreatedByIdentity("createdByIdentity");
    edo.setComments("comments");
    edo.setActiveFilePath("filePath");
    edo.setActiveFileVersion(1);
    edo.setTitle("title " + Id);
    edo.setExtention("ext");
    edo.setIdentity("file-identity");

    edo
        .setFileVersions(Arrays
            .asList(this.getTestWorkflowFileVersionEdo(1L, 1), this.getTestWorkflowFileVersionEdo(2L, 2),
                this.getTestWorkflowFileVersionEdo(3L, 3)));

    return edo;
  }

  protected List<WorkflowFileEntity> getTestWorkflowFileList(final WorkflowEntity workflow) {

    return Arrays
        .asList(this.getTestWorkflowFile(1L, workflow), this.getTestWorkflowFile(2L, workflow),
            this.getTestWorkflowFile(3L, workflow));
  }

  protected WorkflowFileEntity getTestNewWorkflowFile(final WorkflowEntity workflow) {

    final WorkflowFileEntity model = new WorkflowFileEntity();
    model.setWorkflowEntity(workflow);
    model.setId(null);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setActiveFilePath("filePath");
    model.setActiveFileVersion(1);
    model.setTitle("utest title new");
    model.setExtention("ext");

    model
        .setFileVersions(
            Arrays
                .asList(this.getTestNewWorkflowFileVersion(1), this.getTestNewWorkflowFileVersion(2),
                    this.getTestNewWorkflowFileVersion(3)));

    return model;
  }

  protected WorkflowFileVersionEntity getTestWorkflowFileVersion(final Long Id, final int version, final Long workflowFileId) {

    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();
    // model.setWorkflowFileId(workflowFileId);
    model.setId(Id);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowFileVersionEdo getTestWorkflowFileVersionEdo(final Long Id, final int version) {

    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    // model.setWorkflowFileId(workflowFileId);

    edo.setStatus(1);
    edo.setCreatedByIdentity("createdByIdentity");
    edo.setComments("comments");
    edo.setFilePath("filePath");
    edo.setFileVersion(version);

    return edo;
  }

  protected WorkflowFileVersionEntity getTestNewWorkflowFileVersion(final int version) {

    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();
    // model.setWorkflowFileId(null);
    model.setId(null);
    model.setStatus(1);
    model.setCreatedByUserId(1L);
    model.setComments("comments");
    model.setFilePath("filePath");
    model.setFileVersion(version);

    return model;
  }

  protected WorkflowTypeEntity getTestWorkflowType() {

    final WorkflowTypeEntity model = new WorkflowTypeEntity();
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model.setAllowAssign(true);
    model.setIdentity("workflowtype-1");
    model
        .setSteps(Arrays
            .asList(this.getTestWorkflowTypeStep(1L, "step 1"), this.getTestWorkflowTypeStep(2L, "step 2"),
                this.getTestWorkflowTypeStep(3L, "step 3")));
    model.setComments("comments");
    // model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected WorkflowTypeEdo getTestWorkflowTypeEdo() {

    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle("utest title");
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setAssignType(EWorkflowTypeAssignType.MANUAL.getValue());
    edo.setSendToController(true);
    edo.setIncreaseStepAutomatic(true);
    edo.setAllowAssign(true);
    edo.setIdentity("workflowtype-1");
    edo.setSteps(getTestWorkflowTypeStepEdoList());
    edo.setComments("comments");

    return edo;
  }

  protected List<WorkflowTypeEdo> getTestWorkflowTypeEdoList() {

    return Arrays.asList(getTestWorkflowTypeEdo(), getTestWorkflowTypeEdo(), getTestWorkflowTypeEdo());
  }

  protected WorkflowTypeEntity getTestWorkflowType(final Long id, final String title) {

    final WorkflowTypeEntity model = new WorkflowTypeEntity();
    // model.setCompanyIdentity("companyIdentity");
    model.setAllowAssign(Boolean.TRUE);
    model.setId(id);
    model.setIdentity("workflowtype-1");
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setAssignType(EWorkflowTypeAssignType.MANUAL);
    model.setSendToController(true);
    model.setIncreaseStepAutomatic(true);
    model
        .setSteps(Arrays
            .asList(this.getTestWorkflowTypeStep(1L, "step 1"), this.getTestWorkflowTypeStep(2L, "step 2"),
                this.getTestWorkflowTypeStep(3L, "step 3")));
    model.setComments("comments");

    return model;
  }

  protected List<WorkflowTypeEntity> getTestWorkflowTypeList() {

    final List<WorkflowTypeEntity> list = Arrays
        .asList(this.getTestWorkflowType(1L, "WorkflowTypeEntity 1"),
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

  protected WorkflowTypeStepEdo getTestWorkflowTypeStepEdo() {

    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();

    edo.setIdentity("workflowtypestep-1");
    edo.setTitle("utest title");
    edo.setStatus(1);
    edo.setVersion(1);
    edo.setStepIndex(1);
    edo.setComments("comments");
    edo.setViewName("viewName");
    edo.setExpireDays(15);

    return edo;
  }

  protected List<WorkflowTypeStepEdo> getTestWorkflowTypeStepEdoList() {

    return Arrays.asList(getTestWorkflowTypeStepEdo(), getTestWorkflowTypeStepEdo(), getTestWorkflowTypeStepEdo());
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

    final List<WorkflowTypeStepEntity> list = Arrays
        .asList(this.getTestWorkflowTypeStep(1L, "WorkflowTypeStepEntity 1"),
            this.getTestWorkflowTypeStep(2L, "WorkflowTypeStepEntity 2"), this.getTestWorkflowTypeStep(3L, "WorkflowTypeStepEntity 3"));

    return list;
  }

  protected Set<String> getTestUserGroupIdSet() {

    return new HashSet<String>(Arrays.asList("Group-1", "Group-2", "Group-3"));
  }

  protected Set<String> getTestDepartmentIdSet() {

    return new HashSet<String>(Arrays.asList("dep1", "dep2", "dep3"));
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

  protected WorkflowSearchFilterEdo getTestWorkflowSearchFilterEdo() {

    final WorkflowSearchFilterEdo filter = new WorkflowSearchFilterEdo();
    filter.setAssignedUserIdentitySet(this.getTestUserIdSet());
    filter.setStatusSet(new HashSet<>(Arrays.asList(1, 2, 3)));
    filter.setWorkflowStepeIdentitySet(this.getTestWorkflowTypeStepIdSet());
    filter.setWorkflowTypeIdentitySet(this.getTestWorkflowTypeIdSet());

    return filter;
  }

}
