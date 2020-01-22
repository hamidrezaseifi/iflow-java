package com.pth.iflow.gui.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.AssignItemEdo;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowTypeControllerEdo;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.DepartmentGroupEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationResponseEdo;
import com.pth.iflow.common.models.edo.UserDepartmentEdo;
import com.pth.iflow.common.models.edo.UserDepartmentGroupEdo;
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
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.CompanyWorkflowTypeController;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.DepartmentGroup;
import com.pth.iflow.gui.models.ProfileResponse;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserAuthenticationResponse;
import com.pth.iflow.gui.models.UserDepartment;
import com.pth.iflow.gui.models.UserDepartmentGroup;
import com.pth.iflow.gui.models.UserGroup;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowFileVersion;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;

public class GuiModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

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

  public static DepartmentEdo toEdo(final Department model) {

    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setDepartmentGroups(GuiModelEdoMapper.toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
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
    model.setCreatedAt(edo.getCreatedAt());
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

  public static Department fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setDepartmentGroups(GuiModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
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
    edo.setPermission(model.getPermissionFromUserAccess());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setEmail(model.getEmail());
    edo.setBirthDate(model.getBirthDate());
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setGroups(model.getGroups());
    edo
        .setUserDepartments(
            model
                .getUserDepartments()
                .stream()
                .map(d -> new UserDepartmentEdo(d.getDepartmentIdentity(), d.getMemberType().getValue()))
                .collect(Collectors.toList()));

    edo
        .setUserDepartmentGroups(model
            .getUserDepartmentGroups()
            .stream()
            .map(d -> new UserDepartmentGroupEdo(d.getDepartmentGroupIdentity(), d.getMemberType().getValue()))
            .collect(Collectors.toList()));
    edo.setDeputies(model.getDeputies());
    edo.setRoles(model.getRolesInt());
    edo.setIdentity(model.getIdentity());

    return edo;
  }

  public static User fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final User model = new User();

    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setUserAccessFromPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setEmail(edo.getEmail());
    model.setBirthDate(edo.getBirthDate());
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setGroups(edo.getGroups());
    model
        .setUserDepartments(edo
            .getUserDepartments()
            .stream()
            .map(d -> new UserDepartment(d.getDepartmentIdentity(), d.getMemberType()))
            .collect(Collectors.toList()));
    model
        .setUserDepartmentGroups(edo
            .getUserDepartmentGroups()
            .stream()
            .map(d -> new UserDepartmentGroup(d.getDepartmentGroupIdentity(), d.getMemberType()))
            .collect(Collectors.toList()));
    model.setDeputies(edo.getDeputies());
    model.setRoles(edo.getRoles());
    model.setIdentity(edo.getIdentity());

    return model;
  }

  public static UserGroupEdo toEdo(final UserGroup model) {

    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static UserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final UserGroup model = new UserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static Workflow fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final Workflow model = new Workflow();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());
    model.setWorkflowTypeIdentity(edo.getWorkflowTypeIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static InvoiceWorkflow fromEdo(final InvoiceWorkflowEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final InvoiceWorkflow model = new InvoiceWorkflow();

    model.setComments(edo.getWorkflow().getComments());
    model.setStatus(edo.getWorkflow().getStatus());
    model.setVersion(edo.getWorkflow().getVersion());
    model.setControllerIdentity(edo.getWorkflow().getControllerIdentity());
    model.setCurrentStepIdentity(edo.getWorkflow().getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getWorkflow().getCreatedByIdentity());
    model.setIdentity(edo.getWorkflow().getIdentity());
    model.setCompanyIdentity(edo.getWorkflow().getCompanyIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getWorkflow().getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getWorkflow().getActions()));

    model.setDiscountDate(edo.getDiscountDate());
    model.setDiscountDeadline(edo.getDiscountDeadline());
    model.setDiscountEnterDate(edo.getDiscountEnterDate());
    model.setDiscountRate(edo.getDiscountRate());
    model.setInvoiceDate(edo.getInvoiceDate());
    model.setInvoiceType(EInvoiceType.ofValue(edo.getInvoiceType()));
    model.setIsDirectDebitPermission(edo.getIsDirectDebitPermission());
    model.setPartnerCode(edo.getPartnerCode());
    model.setPaymentAmount(edo.getPaymentAmount());
    model.setRegisterNumber(edo.getRegisterNumber());
    model.setSender(edo.getSender());
    model.setVendorName(edo.getVendorName());
    model.setVendorNumber(edo.getVendorNumber());

    return model;
  }

  public static WorkflowEdo convertFromIWorkflowToEdo(final IWorkflow model) {

    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static WorkflowEdo toEdo(final Workflow model) {

    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static InvoiceWorkflowEdo toEdo(final InvoiceWorkflow model) {

    final WorkflowEdo workflowEdo = convertFromIWorkflowToEdo(model);

    final InvoiceWorkflowEdo edo = new InvoiceWorkflowEdo();
    edo.setWorkflow(workflowEdo);

    edo.setDiscountDate(model.getDiscountDate());
    edo.setDiscountDeadline(model.getDiscountDeadline());
    edo.setDiscountEnterDate(model.getDiscountEnterDate());
    edo.setDiscountRate(model.getDiscountRate());
    edo.setInvoiceDate(model.getInvoiceDate());
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

  public static List<InvoiceWorkflowEdo> toInvoiceWorkflowEdoList(final List<InvoiceWorkflow> modelList) {

    final List<InvoiceWorkflowEdo> edoList = new ArrayList<>();
    for (final InvoiceWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<InvoiceWorkflow> fromInvoiceWorkflowEdoList(final List<InvoiceWorkflowEdo> edoList)
      throws IFlowMessageConversionFailureException {

    final List<InvoiceWorkflow> modelList = new ArrayList<>();
    for (final InvoiceWorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static SingleTaskWorkflowEdo toEdo(final SingleTaskWorkflow model) {

    final WorkflowEdo workflowEdo = convertFromIWorkflowToEdo(model);

    final SingleTaskWorkflowEdo edo = new SingleTaskWorkflowEdo();
    edo.setWorkflow(workflowEdo);

    return edo;
  }

  public static SingleTaskWorkflow fromEdo(final SingleTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final SingleTaskWorkflow model = new SingleTaskWorkflow();

    model.setComments(edo.getWorkflow().getComments());
    model.setStatus(edo.getWorkflow().getStatus());
    model.setVersion(edo.getWorkflow().getVersion());
    model.setControllerIdentity(edo.getWorkflow().getControllerIdentity());
    model.setCurrentStepIdentity(edo.getWorkflow().getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getWorkflow().getCreatedByIdentity());
    model.setIdentity(edo.getWorkflow().getIdentity());
    model.setCompanyIdentity(edo.getWorkflow().getCompanyIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getWorkflow().getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getWorkflow().getActions()));

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

  public static List<WorkflowEdo> toWorkflowEdoList(final List<Workflow> modelList) {

    final List<WorkflowEdo> edoList = new ArrayList<>();
    for (final Workflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static TestThreeTaskWorkflowEdo toEdo(final TestThreeTaskWorkflow model) {

    final WorkflowEdo workflowEdo = convertFromIWorkflowToEdo(model);

    final TestThreeTaskWorkflowEdo edo = new TestThreeTaskWorkflowEdo();
    edo.setWorkflow(workflowEdo);

    return edo;
  }

  public static TestThreeTaskWorkflow fromEdo(final TestThreeTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final TestThreeTaskWorkflow model = new TestThreeTaskWorkflow();

    model.setComments(edo.getWorkflow().getComments());
    model.setStatus(edo.getWorkflow().getStatus());
    model.setVersion(edo.getWorkflow().getVersion());
    model.setControllerIdentity(edo.getWorkflow().getControllerIdentity());
    model.setCurrentStepIdentity(edo.getWorkflow().getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getWorkflow().getCreatedByIdentity());
    model.setIdentity(edo.getWorkflow().getIdentity());
    model.setCompanyIdentity(edo.getWorkflow().getCompanyIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getWorkflow().getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getWorkflow().getActions()));

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

  public static List<Workflow> fromWorkflowEdoList(final List<WorkflowEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<Workflow> modelList = new ArrayList<>();
    for (final WorkflowEdo edo : edoList) {
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

  public static WorkflowActionEdo toEdo(final WorkflowAction model) {

    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus().getValue().intValue());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setAssignToIdentity(model.getAssignToIdentity());

    return edo;
  }

  public static WorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final WorkflowAction model = new WorkflowAction();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setAssignToIdentity(edo.getAssignToIdentity());

    return model;
  }

  public static WorkflowTypeStepEdo toEdo(final WorkflowTypeStep model) {

    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(model.getStepIndex());
    edo.setViewName(model.getViewName());
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setExpireDays(model.getExpireDays());
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
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setExpireDays(edo.getExpireDays());
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
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setActiveFilePath(model.getActiveFilePath());
    edo.setActiveFileVersion(model.getActiveFileVersion());
    edo.setIdentity(model.getIdentity());

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
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setIdentity(edo.getIdentity());

    model.setFileVersions(fromWorkflowFileVersionEdoList(edo.getFileVersions()));

    return model;
  }

  public static WorkflowFileVersionEdo toEdo(final WorkflowFileVersion model) {

    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setFilePath(model.getFilePath());
    edo.setFileVersion(model.getFileVersion());

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

    return model;
  }

  public static WorkflowTypeEdo toEdo(final WorkflowType model) {

    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
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
    edo.setStatusSet(model.getStatusList().stream().map(e -> e.getValue()).collect(Collectors.toSet()));
    edo.setWorkflowStepeIdentitySet(model.getWorkflowSteps());
    edo.setWorkflowTypeIdentitySet(model.getWorkflowTypes());
    edo.setCompanyIdentity(model.getCompanyIdentity());

    return edo;
  }

  public static WorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final WorkflowSearchFilter model = new WorkflowSearchFilter();
    model.setAssignedUserIdentitySet(edo.getAssignedUserIdentitySet());
    model.setStatusList(edo.getStatusSet().stream().map(i -> EWorkflowStatus.ofValue(i)).collect(Collectors.toSet()));
    model.setWorkflowSteps(edo.getWorkflowStepeIdentitySet());
    model.setWorkflowTypes(edo.getWorkflowTypeIdentitySet());
    model.setCompanyIdentity(edo.getCompanyIdentity());

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

  public static List<WorkflowFile> fromWorkflowFileEdoList(final List<WorkflowFileEdo> edoList)
      throws IFlowMessageConversionFailureException {

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

  public static CompanyProfile fromEdo(final CompanyProfileEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final CompanyProfile model = new CompanyProfile(fromEdo(edo.getCompany()), fromDepartmentEdoList(edo.getDepartments()),
        fromUserGroupEdoList(edo.getUserGroups()), fromCompanyWorkflowTypeControllerEdoList(edo.getWorkflowTypeControllers()));

    return model;
  }

  public static CompanyProfileEdo toEdo(final CompanyProfile model) {

    final CompanyProfileEdo edo = new CompanyProfileEdo(toEdo(model.getCompany()), toDepartmentEdoList(model.getDepartments()),
        toUserGroupEdoList(model.getUserGroups()), toCompanyWorkflowTypeControllerEdoList(model.getWorkflowTypeControllers()));

    return edo;
  }

  public static List<CompanyWorkflowTypeControllerEdo>
      toCompanyWorkflowTypeControllerEdoList(final List<CompanyWorkflowTypeController> modelList) {

    final List<CompanyWorkflowTypeControllerEdo> edoList = new ArrayList<>();
    for (final CompanyWorkflowTypeController model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<CompanyWorkflowTypeController> fromCompanyWorkflowTypeControllerEdoList(
      final List<CompanyWorkflowTypeControllerEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<CompanyWorkflowTypeController> modelList = new ArrayList<>();
    for (final CompanyWorkflowTypeControllerEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static CompanyWorkflowTypeController fromEdo(final CompanyWorkflowTypeControllerEdo edo) {

    final CompanyWorkflowTypeController model = new CompanyWorkflowTypeController(edo.getWorkflowTypeIdentity(), edo.getUserIdentity(),
        edo.getPriority());
    return model;
  }

  private static CompanyWorkflowTypeControllerEdo toEdo(final CompanyWorkflowTypeController model) {

    final CompanyWorkflowTypeControllerEdo edo = new CompanyWorkflowTypeControllerEdo(model.getWorkflowTypeIdentity(),
        model.getUserIdentity(),
        model.getPriority());
    return edo;
  }

  public static ProfileResponseEdo toEdo(final ProfileResponse model) {

    return new ProfileResponseEdo(toEdo(model.getUser()), toEdo(model.getCompanyProfile()), model.getSessionid());
  }

  public static List<Department> fromDepartmentEdoList(final List<DepartmentEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<Department> modelList = new ArrayList<>();
    for (final DepartmentEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<UserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<UserGroup> modelList = new ArrayList<>();
    for (final UserGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<AssignItem> fromAssignItemEdoList(final List<AssignItemEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<AssignItem> modelList = new ArrayList<>();
    for (final AssignItemEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static AssignItem fromEdo(final AssignItemEdo edo) {

    return new AssignItem(edo.getItemIdentity(), EAssignType.valueFromName(edo.getItemType()));
  }

  public static List<AssignItemEdo> toAssignItemEdoList(final List<AssignItem> modelList) {

    final List<AssignItemEdo> edoList = new ArrayList<>();
    for (final AssignItem model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  private static AssignItemEdo toEdo(final AssignItem model) {

    return new AssignItemEdo(model.getItemIdentity(), model.getItemType().getIdentity());
  }

  public static List<WorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList)
      throws IFlowMessageConversionFailureException {

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

  public static ProfileResponse fromEdo(final ProfileResponseEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);
    return new ProfileResponse(fromEdo(edo.getUser()), fromEdo(edo.getCompanyProfile()), edo.getSessionid());

  }

  public static UserAuthenticationResponse fromEdo(final UserAuthenticationResponseEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final UserAuthenticationResponse model = new UserAuthenticationResponse();
    model.setCreated(edo.getCreated());
    model.setUserIdentity(edo.getUserIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setLastAccess(edo.getLastAccess());
    model.setSessionid(edo.getSessionid());
    model.setToken(edo.getToken());
    return model;
  }

  public static List<User> fromUserEdoList(final List<UserEdo> edoList) throws IFlowMessageConversionFailureException {

    final List<User> modelList = new ArrayList<>();
    for (final UserEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowMessageEdo> toWorkflowMessageEdoList(final List<WorkflowMessage> modelList) {

    final List<WorkflowMessageEdo> edoList = new ArrayList<>();
    if (modelList != null) {
      for (final WorkflowMessage model : modelList) {
        edoList.add(toEdo(model));
      }
    }

    return edoList;
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
