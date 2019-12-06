package com.pth.iflow.workflow.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.pth.iflow.common.edo.models.AssignItemEdo;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.CompanyProfileEdo;
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.Company;
import com.pth.iflow.workflow.models.CompanyProfile;
import com.pth.iflow.workflow.models.Department;
import com.pth.iflow.workflow.models.DepartmentGroup;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.UserGroup;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowFile;
import com.pth.iflow.workflow.models.WorkflowFileVersion;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.workflow.WorkflowResult;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;

public class WorkflowModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public static CompanyProfileEdo toEdo(final CompanyProfile model) {
    final CompanyProfileEdo edo = new CompanyProfileEdo(toEdo(model.getCompany()), toDepartmentEdoList(model.getDepartments()),
        toUserGroupEdoList(model.getUserGroups()));
    return edo;
  }

  public static CompanyEdo toEdo(final Company model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentity(model.getIdentity());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static Company fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Company model = new Company();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentity(edo.getIdentity());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowMessage fromEdo(final WorkflowMessageEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowMessage model = new WorkflowMessage();
    model.setStatus(EWorkflowMessageStatus.ofValue(edo.getStatus()));
    model.setUserIdentity(edo.getUserIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setVersion(edo.getVersion());
    model.setWorkflowIdentity(edo.getWorkflowIdentity());
    model.setMessageType(EWorkflowMessageType.ofValue(edo.getMessageType()));
    model.setExpireDays(edo.getExpireDays());
    model.setMessage(edo.getMessage());
    model.setStepIdentity(edo.getStepIdentity());

    return model;
  }

  public static WorkflowMessageEdo toEdo(final WorkflowMessage model) {
    final WorkflowMessageEdo edo = new WorkflowMessageEdo();
    edo.setStatus(model.getStatus().getValue());
    edo.setUserIdentity(model.getUserIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setWorkflowIdentity(model.getWorkflowIdentity());
    edo.setMessageType(model.getMessageType().getValue());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(model.getCreatedAt());
    edo.setStepIdentity(model.getStepIdentity());

    return edo;
  }

  public static WorkflowResult fromEdo(final WorkflowResultEdo edo) {
    final WorkflowResult model = new WorkflowResult();

    model.setStatus(edo.getStatus());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());
    model.setWorkflowTypeIdentity(edo.getWorkflowTypeIdentity());

    return model;
  }

  public static WorkflowResultEdo toEdo(final WorkflowResult model) {
    final WorkflowResultEdo edo = new WorkflowResultEdo();

    edo.setStatus(model.getStatus().getValue());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());

    return edo;
  }

  public static DepartmentEdo toEdo(final Department model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setDepartmentGroups(toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static Department fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setDepartmentGroups(fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

  public static DepartmentGroupEdo toEdo(final DepartmentGroup model) {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static DepartmentGroup fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final DepartmentGroup model = new DepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static UserEdo toEdo(final User model) {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(model.getFirstName());
    edo.setLastName(model.getLastName());
    edo.setPermission(model.getPermission());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setEmail(model.getEmail());
    edo.setBirthDate(model.getBirthDate());
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setGroups(model.getGroups());
    edo.setDepartments(model.getDepartments());
    edo.setDepartmentGroups(model.getDepartmentGroups());
    edo.setDeputies(model.getDeputies());
    edo.setRoles(model.getRoles());

    return edo;
  }

  public static User fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final User model = new User();

    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setEmail(edo.getEmail());
    model.setBirthDate(edo.getBirthDate());
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setGroups(edo.getGroups());
    model.setDepartments(edo.getDepartments());
    model.setDepartmentGroups(edo.getDepartmentGroups());
    model.setDeputies(edo.getDeputies());
    model.setRoles(edo.getRoles());

    return model;
  }

  public static UserGroupEdo toEdo(final UserGroup model) {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());

    return edo;
  }

  public static UserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserGroup model = new UserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());

    return model;
  }

  public static InvoiceWorkflowEdo toEdo(final InvoiceWorkflow model) {
    final InvoiceWorkflowEdo edo = new InvoiceWorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    edo.setDiscountDate(model.getDiscountDate());
    edo.setDiscountDeadline(model.getDiscountDeadline());
    edo.setDiscountEnterDate(model.getDiscountEnterDate());
    edo.setDiscountRate(model.getDiscountRate());
    edo.setInvoceDate(model.getInvoceDate());
    edo.setInvoiceType(model.getInvoiceType().getValue());
    edo.setIsDirectDebitPermission(model.getIsDirectDebitPermission());
    edo.setPartnerCode(model.getPartnerCode());
    edo.setPaymentAmount(model.getPaymentAmount());
    edo.setRegisterNumber(model.getRegisterNumber());
    edo.setSender(model.getSender());
    edo.setVendorName(model.getVendorName());
    edo.setVendorNumber(model.getVendorNumber());

    return edo;
  }

  public static InvoiceWorkflow fromEdo(final InvoiceWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final InvoiceWorkflow model = new InvoiceWorkflow();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    model.setDiscountDate(edo.getDiscountDate());
    model.setDiscountDeadline(edo.getDiscountDeadline());
    model.setDiscountEnterDate(edo.getDiscountEnterDate());
    model.setDiscountRate(edo.getDiscountRate());
    model.setInvoceDate(edo.getInvoceDate());
    model.setInvoiceType(edo.getInvoiceType());
    model.setIsDirectDebitPermission(edo.getIsDirectDebitPermission());
    model.setPartnerCode(edo.getPartnerCode());
    model.setPaymentAmount(edo.getPaymentAmount());
    model.setRegisterNumber(edo.getRegisterNumber());
    model.setSender(edo.getSender());
    model.setVendorName(edo.getVendorName());
    model.setVendorNumber(edo.getVendorNumber());

    return model;
  }

  public static SingleTaskWorkflowEdo toEdo(final SingleTaskWorkflow model) {
    final SingleTaskWorkflowEdo edo = new SingleTaskWorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static SingleTaskWorkflow fromEdo(final SingleTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final SingleTaskWorkflow model = new SingleTaskWorkflow();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static SingleTaskWorkflowSaveRequest fromEdo(final SingleTaskWorkflowSaveRequestEdo edo)
      throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final SingleTaskWorkflowSaveRequest request = new SingleTaskWorkflowSaveRequest();
    request.setAssigns(fromAssignItemEdoList(edo.getAssigns()));
    request.setCommand(EWorkflowProcessCommand.valueFromName(edo.getCommand()));
    request.setExpireDays(edo.getExpireDays());
    request.setWorkflow(fromEdo(edo.getWorkflow()));

    return request;
  }

  public static SingleTaskWorkflowSaveRequestEdo toEdo(final SingleTaskWorkflowSaveRequest model) {
    final SingleTaskWorkflowSaveRequestEdo request = new SingleTaskWorkflowSaveRequestEdo();
    request.setAssigns(toAssignItemEdoList(model.getAssigns()));
    request.setCommand(model.getCommand().getIdentity());
    request.setExpireDays(model.getExpireDays());
    request.setWorkflow(toEdo(model.getWorkflow()));

    return request;
  }

  public static List<SingleTaskWorkflowEdo> toSingleTaskWorkflowEdoList(final List<SingleTaskWorkflow> modelList) {
    final List<SingleTaskWorkflowEdo> edoList = new ArrayList<>();
    for (final SingleTaskWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<SingleTaskWorkflow> fromSingleTaskWorkflowEdoList(final List<SingleTaskWorkflowEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<SingleTaskWorkflow> modelList = new ArrayList<>();
    for (final SingleTaskWorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  // -----------------------------------------------------------------------------

  public static TestThreeTaskWorkflowEdo toEdo(final TestThreeTaskWorkflow model) {
    final TestThreeTaskWorkflowEdo edo = new TestThreeTaskWorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static TestThreeTaskWorkflow fromEdo(final TestThreeTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final TestThreeTaskWorkflow model = new TestThreeTaskWorkflow();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static TestThreeTaskWorkflowSaveRequest fromEdo(final TestThreeTaskWorkflowSaveRequestEdo edo)
      throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final TestThreeTaskWorkflowSaveRequest request = new TestThreeTaskWorkflowSaveRequest();
    request.setAssigns(fromAssignItemEdoList(edo.getAssigns()));
    request.setCommand(EWorkflowProcessCommand.valueFromName(edo.getCommand()));
    request.setExpireDays(edo.getExpireDays());
    request.setWorkflow(fromEdo(edo.getWorkflow()));

    return request;
  }

  public static TestThreeTaskWorkflowSaveRequestEdo toEdo(final TestThreeTaskWorkflowSaveRequest model) {
    final TestThreeTaskWorkflowSaveRequestEdo request = new TestThreeTaskWorkflowSaveRequestEdo();
    request.setAssigns(toAssignItemEdoList(model.getAssigns()));
    request.setCommand(model.getCommand().getIdentity());
    request.setExpireDays(model.getExpireDays());
    request.setWorkflow(toEdo(model.getWorkflow()));

    return request;
  }

  public static List<TestThreeTaskWorkflowEdo> toTestThreeTaskWorkflowEdoList(final List<TestThreeTaskWorkflow> modelList) {
    final List<TestThreeTaskWorkflowEdo> edoList = new ArrayList<>();
    for (final TestThreeTaskWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<TestThreeTaskWorkflow> fromTestThreeTaskWorkflowEdoList(final List<TestThreeTaskWorkflowEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<TestThreeTaskWorkflow> modelList = new ArrayList<>();
    for (final TestThreeTaskWorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  // -----------------------------------------------------------------------------

  public static List<WorkflowResult> fromWorkflowResultEdoList(final List<WorkflowResultEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowResult> modelList = new ArrayList<>();
    for (final WorkflowResultEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowResultEdo> toWorkflowResultEdoList(final List<WorkflowResult> modelList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowResultEdo> edoList = new ArrayList<>();
    for (final WorkflowResult model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static WorkflowActionEdo toEdo(final WorkflowAction model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus().getValue());
    edo.setAssignToIdentity(model.getAssignToIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());

    return edo;
  }

  public static WorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowAction model = new WorkflowAction();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setAssignToIdentity(edo.getAssignToIdentity());

    return model;
  }

  public static WorkflowTypeStepEdo toEdo(final WorkflowTypeStep model) {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(model.getStepIndex());
    edo.setViewName(model.getViewName());
    edo.setExpireDays(model.getExpireDays());
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowTypeStep model = new WorkflowTypeStep();

    model.setStepIndex(edo.getStepIndex());
    model.setViewName(edo.getViewName());
    model.setExpireDays(edo.getExpireDays());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());

    return model;
  }

  public static WorkflowFileEdo toEdo(final WorkflowFile model) {
    final WorkflowFileEdo edo = new WorkflowFileEdo();
    edo.setTitle(model.getTitle());
    edo.setExtention(model.getExtention());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setActiveFilePath(model.getActiveFilePath());
    edo.setActiveFileVersion(model.getActiveFileVersion());
    edo.setVersion(model.getVersion());

    edo.setFileVersions(toWorkflowFileVersionEdoList(model.getFileVersions()));

    return edo;
  }

  public static WorkflowFile fromEdo(final WorkflowFileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFile model = new WorkflowFile();

    model.setTitle(edo.getTitle());
    model.setExtention(edo.getExtention());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setVersion(edo.getVersion());

    model.setFileVersions(fromWorkflowFileVersionEdoList(edo.getFileVersions()));

    return model;
  }

  public static WorkflowFileVersionEdo toEdo(final WorkflowFileVersion model) {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setCreatedByIdentity(model.getCreatedBy().getIdentity());
    edo.setFilePath(model.getFilePath());
    edo.setFileVersion(model.getFileVersion());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFileVersion model = new WorkflowFileVersion();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowTypeEdo toEdo(final WorkflowType model) {
    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setBaseTypeIdentity(model.getBaseTypeIdentity());
    edo.setSendToController(model.getSendToController());
    edo.setAssignType(model.geAssignType().getValue());
    edo.setIncreaseStepAutomatic(model.getIncreaseStepAutomatic());
    edo.setAllowAssign(model.getAllowAssign());
    edo.setSteps(toWorkflowTypeStepEdoList(model.getSteps()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowType fromEdo(final WorkflowTypeEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowType model = new WorkflowType();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setBaseTypeIdentity(edo.getBaseTypeIdentity());
    model.setSendToController(edo.getSendToController());
    model.setAssignType(EWorkflowTypeAssignType.ofValue(edo.getAssignType()));
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(fromWorkflowTypeStepEdoList(edo.getSteps()));

    return model;
  }

  public static WorkflowSearchFilterEdo toEdo(final WorkflowSearchFilter model) {
    final WorkflowSearchFilterEdo edo = new WorkflowSearchFilterEdo();
    edo.setAssignedUserIdentitySet(model.getAssignedUserIdSet());
    edo.setStatusSet(model.getStatusSet());
    edo.setWorkflowStepeIdentitySet(model.getWorkflowStepeIdSet());
    edo.setWorkflowTypeIdentitySet(model.getWorkflowTypeIdSet());

    return edo;
  }

  public static WorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowSearchFilter model = new WorkflowSearchFilter();
    model.setAssignedUserIdSet(edo.getAssignedUserIdentitySet());
    model.setStatusSet(edo.getStatusSet());
    model.setWorkflowStepeIdSet(edo.getWorkflowStepeIdentitySet());
    model.setWorkflowTypeIdSet(edo.getWorkflowTypeIdentitySet());

    return model;

  }

  public static List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<WorkflowFileVersion> modelList) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();
    for (final WorkflowFileVersion model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowFileVersion> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowFileVersion> modelList = new ArrayList<>();
    for (final WorkflowFileVersionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowFileEdo> toWorkflowFileEdoList(final List<WorkflowFile> modelList) {
    final List<WorkflowFileEdo> edoList = new ArrayList<>();
    for (final WorkflowFile model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowFile> fromWorkflowFileEdoList(final List<WorkflowFileEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<WorkflowFile> modelList = new ArrayList<>();
    for (final WorkflowFileEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowActionEdo> toWorkflowActionEdoList(final List<WorkflowAction> modelList) {
    final List<WorkflowActionEdo> edoList = new ArrayList<>();
    for (final WorkflowAction model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowMessageEdo> toWorkflowMessageEdoList(final List<WorkflowMessage> modelList) {
    final List<WorkflowMessageEdo> edoList = new ArrayList<>();
    for (final WorkflowMessage model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowAction> fromWorkflowActionEdoList(final List<WorkflowActionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowAction> modelList = new ArrayList<>();
    for (final WorkflowActionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowTypeStepEdo> toWorkflowTypeStepEdoList(final List<WorkflowTypeStep> modelList) {
    final List<WorkflowTypeStepEdo> edoList = new ArrayList<>();
    for (final WorkflowTypeStep model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeStep> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowTypeStep> modelList = new ArrayList<>();
    for (final WorkflowTypeStepEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<DepartmentGroupEdo> toDepartmentGroupEdoList(final List<DepartmentGroup> modelList) {
    final List<DepartmentGroupEdo> edoList = new ArrayList<>();
    for (final DepartmentGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<DepartmentGroup> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<InvoiceWorkflowEdo> toInvoiceWorkflowEdoList(final List<InvoiceWorkflow> modelList) {
    final List<InvoiceWorkflowEdo> edoList = new ArrayList<>();
    for (final InvoiceWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeEdo> toWorkflowTypeEdoList(final List<WorkflowType> modelList) {
    final List<WorkflowTypeEdo> edoList = new ArrayList<>();
    for (final WorkflowType model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserGroupEdo> toUserGroupEdoList(final List<UserGroup> modelList) {
    final List<UserGroupEdo> edoList = new ArrayList<>();
    for (final UserGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentEdo> toDepartmentEdoList(final List<Department> modelList) {
    final List<DepartmentEdo> edoList = new ArrayList<>();
    for (final Department model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserEdo> toUserEdoList(final List<User> modelList) {
    final List<UserEdo> edoList = new ArrayList<>();
    for (final User model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<User> fromUserEdoList(final List<UserEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<User> modelList = new ArrayList<>();
    for (final UserEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static ProfileResponse fromEdo(final ProfileResponseEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final ProfileResponse model = new ProfileResponse(fromEdo(edo.getUser()), fromEdo(edo.getCompanyProfile()), edo.getSessionid());

    return model;
  }

  private static CompanyProfile fromEdo(final CompanyProfileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final CompanyProfile model = new CompanyProfile(fromEdo(edo.getCompany()), fromDepartmentEdoList(edo.getDepartments()),
        fromUserGroupEdoList(edo.getUserGroups()));

    return model;
  }

  private static List<UserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<UserGroup> modelList = new ArrayList<>();
    for (final UserGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static List<Department> fromDepartmentEdoList(final List<DepartmentEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<Department> modelList = new ArrayList<>();
    for (final DepartmentEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<InvoiceWorkflow> fromInvoiceWorkflowEdoList(final List<InvoiceWorkflowEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<InvoiceWorkflow> modelList = new ArrayList<>();
    for (final InvoiceWorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<WorkflowType> modelList = new ArrayList<>();
    for (final WorkflowTypeEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowMessage> fromWorkflowMessageEdoList(final List<WorkflowMessageEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowMessage> modelList = new ArrayList<>();
    for (final WorkflowMessageEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static InvoiceWorkflowSaveRequest fromEdo(final InvoiceWorkflowSaveRequestEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final InvoiceWorkflowSaveRequest request = new InvoiceWorkflowSaveRequest();
    request.setAssigns(fromAssignItemEdoList(edo.getAssigns()));
    request.setCommand(EWorkflowProcessCommand.valueFromName(edo.getCommand()));
    request.setExpireDays(edo.getExpireDays());
    request.setWorkflow(fromEdo(edo.getWorkflow()));

    return request;
  }

  public static InvoiceWorkflowSaveRequestEdo toEdo(final InvoiceWorkflowSaveRequest model) {
    final InvoiceWorkflowSaveRequestEdo request = new InvoiceWorkflowSaveRequestEdo();
    request.setAssigns(toAssignItemEdoList(model.getAssigns()));
    request.setCommand(model.getCommand().getIdentity());
    request.setExpireDays(model.getExpireDays());
    request.setWorkflow(toEdo(model.getWorkflow()));

    return request;
  }

  private static List<AssignItemEdo> toAssignItemEdoList(final List<AssignItem> modelList) {
    final List<AssignItemEdo> edoList = new ArrayList<>();
    for (final AssignItem model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  private static AssignItemEdo toEdo(final AssignItem model) {
    final AssignItemEdo edo = new AssignItemEdo(model.getItemIdentity(), model.getItemType().getIdentity());

    return edo;
  }

  private static List<AssignItem> fromAssignItemEdoList(final List<AssignItemEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<AssignItem> modelList = new ArrayList<>();
    for (final AssignItemEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static AssignItem fromEdo(final AssignItemEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final AssignItem model = new AssignItem(edo.getItemIdentity(), EAssignType.valueFromName(edo.getItemType()));

    return model;
  }

  private static <E> void validateCustomer(final E model) throws IFlowMessageConversionFailureException {
    final Set<ConstraintViolation<E>> violations = VALIDATOR.validate(model);
    if (violations != null && violations.size() > 0) {
      final String validationErrorMessage = createValidationErrorMessage(violations);
      throw new IFlowMessageConversionFailureException(validationErrorMessage);
    }
  }

  private static <E> String createValidationErrorMessage(final Set<ConstraintViolation<E>> violations) {
    final StringBuilder builder = new StringBuilder();
    builder.append("There are errors in the received XML:");
    builder.append(System.lineSeparator());
    for (final ConstraintViolation<E> violation : violations) {
      builder.append("Error: ");
      builder.append(violation.getMessage());
      builder.append(": ");
      builder.append(violation.getInvalidValue());
      builder.append(System.lineSeparator());
    }
    return builder.toString();
  }

}
