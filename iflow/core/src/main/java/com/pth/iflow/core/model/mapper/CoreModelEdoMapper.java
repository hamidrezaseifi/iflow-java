package com.pth.iflow.core.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

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
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.helper.CoreDataHelper;
import com.pth.iflow.core.model.CompanyProfile;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;

public class CoreModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public static CompanyEdo toEdo(final CompanyEntity model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentity(model.getIdentity());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static CompanyEntity fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final CompanyEntity model = new CompanyEntity();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentity(edo.getIdentity());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static CompanyProfileEdo toEdo(final CompanyProfile model) {
    final CompanyProfileEdo edo = new CompanyProfileEdo(toEdo(model.getCompany()), toDepartmentEdoList(model.getDepartments()),
        toUserGroupEdoList(model.getUserGroups()));

    return edo;
  }

  public static ProfileResponseEdo toEdo(final ProfileResponse model) {
    return new ProfileResponseEdo(toEdo(model.getUser()), toEdo(model.getCompanyProfile()), model.getSessionid());
  }

  public static WorkflowMessageEntity fromEdo(final WorkflowMessageEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowMessageEntity model = new WorkflowMessageEntity();
    model.setStatus(edo.getStatus());
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

  public static WorkflowResultEdo toEdo(final WorkflowResultEntity model) {
    final WorkflowResultEdo edo = new WorkflowResultEdo();

    edo.setStatus(model.getStatus());
    edo.setControllerIdentity(model.getController().getIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStep().getIdentity());
    edo.setCreatedByIdentity(model.getCreatedBy().getIdentity());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());

    return edo;
  }

  public static WorkflowMessageEdo toEdo(final WorkflowMessageEntity model) {
    final WorkflowMessageEdo edo = new WorkflowMessageEdo();
    edo.setStatus(model.getStatus());
    edo.setUserIdentity(model.getUserIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setWorkflowIdentity(model.getWorkflowIdentity());
    edo.setMessageType(model.getMessageType());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(CoreDataHelper.toLocalDateTime(model.getCreatedAt()));
    edo.setStepIdentity(model.getStepIdentity());

    return edo;
  }

  public static DepartmentEdo toEdo(final DepartmentEntity model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setDepartmentGroups(toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static DepartmentEntity fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final DepartmentEntity model = new DepartmentEntity();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setDepartmentGroups(fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

  public static DepartmentGroupEdo toEdo(final DepartmentGroupEntity model) {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static DepartmentGroupEntity fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final DepartmentGroupEntity model = new DepartmentGroupEntity();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static UserEdo toEdo(final UserEntity model) {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(model.getFirstName());
    edo.setLastName(model.getLastName());
    edo.setPermission(model.getPermission());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setEmail(model.getEmail());
    edo.setBirthDate(model.getBirthDate().toLocalDate());
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setGroups(model.getGroups());
    edo.setDepartments(model.getDepartments());
    edo.setDepartmentGroups(model.getDepartmentGroups());
    edo.setDeputies(model.getDeputies());
    edo.setRoles(model.getRoles());

    return edo;
  }

  public static UserEntity fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserEntity model = new UserEntity();

    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setEmail(edo.getEmail());
    model.setBirthDate(CoreDataHelper.fromLocalDate(edo.getBirthDate()));
    model.setCompanyIdentity(edo.getCompanyIdentity());
    model.setGroups(edo.getGroups());
    model.setDepartments(edo.getDepartments());
    model.setDepartmentGroups(edo.getDepartmentGroups());
    model.setDeputies(edo.getDeputies());
    model.setRoles(edo.getRoles());

    return model;
  }

  public static UserGroupEdo toEdo(final UserGroupEntity model) {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompanyIdentity());

    return edo;
  }

  public static UserGroupEntity fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserGroupEntity model = new UserGroupEntity();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());
    model.setCompanyIdentity(edo.getCompanyIdentity());

    return model;
  }

  public static InvoiceWorkflowEdo toEdo(final InvoiceWorkflowEntity model) {
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

    edo.setDiscountDate(CoreDataHelper.toLocalDate(model.getDiscountDate()));
    edo.setDiscountDeadline(model.getDiscountDeadline());
    edo.setDiscountEnterDate(CoreDataHelper.toLocalDate(model.getDiscountEnterDate()));
    edo.setDiscountRate(model.getDiscountRate());
    edo.setInvoceDate(CoreDataHelper.toLocalDate(model.getInvoceDate()));
    edo.setInvoiceType(model.getInvoiceType());
    edo.setIsDirectDebitPermission(model.getIsDirectDebitPermission());
    edo.setPartnerCode(model.getPartnerCode());
    edo.setPaymentAmount(model.getPaymentAmount());
    edo.setRegisterNumber(model.getRegisterNumber());
    edo.setSender(model.getSender());
    edo.setVendorName(model.getVendorName());
    edo.setVendorNumber(model.getVendorNumber());

    return edo;
  }

  public static InvoiceWorkflowEntity fromEdo(final InvoiceWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final InvoiceWorkflowEntity model = new InvoiceWorkflowEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    model.setDiscountDate(CoreDataHelper.fromLocalDate(edo.getDiscountDate()));
    model.setDiscountDeadline(edo.getDiscountDeadline());
    model.setDiscountEnterDate(CoreDataHelper.fromLocalDate(edo.getDiscountEnterDate()));
    model.setDiscountRate(edo.getDiscountRate());
    model.setInvoceDate(CoreDataHelper.fromLocalDate(edo.getInvoceDate()));
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

  public static SingleTaskWorkflowEdo toEdo(final SingleTaskWorkflowEntity model) {
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

  public static SingleTaskWorkflowEntity fromEdo(final SingleTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final SingleTaskWorkflowEntity model = new SingleTaskWorkflowEntity();

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

  public static TestThreeTaskWorkflowEdo toEdo(final TestThreeTaskWorkflowEntity model) {
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

  public static TestThreeTaskWorkflowEntity fromEdo(final TestThreeTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();

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

  public static WorkflowActionEdo toEdo(final WorkflowActionEntity model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setAssignToIdentity(model.getAssignToIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    return edo;
  }

  public static WorkflowActionEntity fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowActionEntity model = new WorkflowActionEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setAssignToIdentity(edo.getAssignToIdentity());

    return model;
  }

  public static WorkflowTypeStepEdo toEdo(final WorkflowTypeStepEntity model) {
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

  public static WorkflowTypeStepEntity fromEdo(final WorkflowTypeStepEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowTypeStepEntity model = new WorkflowTypeStepEntity();

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

  public static WorkflowFileEdo toEdo(final WorkflowFileEntity model) {
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

  public static WorkflowFileEntity fromEdo(final WorkflowFileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFileEntity model = new WorkflowFileEntity();

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

  public static WorkflowFileVersionEdo toEdo(final WorkflowFileVersionEntity model) {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setCreatedByIdentity(model.getCreatedBy().getIdentity());
    edo.setFilePath(model.getFilePath());
    edo.setFileVersion(model.getFileVersion());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowFileVersionEntity fromEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFileVersionEntity model = new WorkflowFileVersionEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowTypeEdo toEdo(final WorkflowTypeEntity model) {
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

  public static WorkflowTypeEntity fromEdo(final WorkflowTypeEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowTypeEntity model = new WorkflowTypeEntity();

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
    edo.setAssignedUserIdentitySet(model.getAssignedUserIdentitySet());
    edo.setStatusSet(model.getStatusSet());
    edo.setWorkflowStepeIdentitySet(model.getWorkflowStepIdentitySet());
    edo.setWorkflowTypeIdentitySet(model.getWorkflowTypeIdentitySet());

    return edo;
  }

  public static WorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowSearchFilter model = new WorkflowSearchFilter();
    model.setAssignedUserIdentitySet(edo.getAssignedUserIdentitySet());
    model.setStatusSet(edo.getStatusSet());
    model.setWorkflowStepIdentitySet(edo.getWorkflowStepeIdentitySet());
    model.setWorkflowTypeIdentitySet(edo.getWorkflowTypeIdentitySet());

    return model;

  }

  public static List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<WorkflowFileVersionEntity> modelList) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();
    for (final WorkflowFileVersionEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowFileVersionEntity> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowFileVersionEntity> modelList = new ArrayList<>();
    for (final WorkflowFileVersionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowFileEdo> toWorkflowFileEdoList(final List<WorkflowFileEntity> modelList) {
    final List<WorkflowFileEdo> edoList = new ArrayList<>();
    for (final WorkflowFileEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowFileEntity> fromWorkflowFileEdoList(final List<WorkflowFileEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowFileEntity> modelList = new ArrayList<>();
    for (final WorkflowFileEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowActionEdo> toWorkflowActionEdoList(final List<WorkflowActionEntity> modelList) {
    final List<WorkflowActionEdo> edoList = new ArrayList<>();
    for (final WorkflowActionEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowMessageEdo> toWorkflowMessageEdoList(final List<WorkflowMessageEntity> modelList) {
    final List<WorkflowMessageEdo> edoList = new ArrayList<>();
    for (final WorkflowMessageEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowActionEntity> fromWorkflowActionEdoList(final List<WorkflowActionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowActionEntity> modelList = new ArrayList<>();
    for (final WorkflowActionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowTypeStepEdo> toWorkflowTypeStepEdoList(final List<WorkflowTypeStepEntity> modelList) {
    final List<WorkflowTypeStepEdo> edoList = new ArrayList<>();
    for (final WorkflowTypeStepEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeStepEntity> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowTypeStepEntity> modelList = new ArrayList<>();
    for (final WorkflowTypeStepEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<DepartmentGroupEdo> toDepartmentGroupEdoList(final List<DepartmentGroupEntity> modelList) {
    final List<DepartmentGroupEdo> edoList = new ArrayList<>();
    for (final DepartmentGroupEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentGroupEntity> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<DepartmentGroupEntity> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<InvoiceWorkflowEdo> toInvoiceWorkflowEdoList(final List<InvoiceWorkflowEntity> modelList) {
    final List<InvoiceWorkflowEdo> edoList = new ArrayList<>();
    for (final InvoiceWorkflowEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowResultEdo> toWorkflowResultEdoList(final List<WorkflowResultEntity> modelList) {
    final List<WorkflowResultEdo> edoList = new ArrayList<>();
    for (final WorkflowResultEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowResultEdo> toWorkflowResultEntityEdoList(final List<WorkflowResultEntity> modelList) {
    final List<WorkflowResultEdo> edoList = new ArrayList<>();
    for (final WorkflowResultEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<TestThreeTaskWorkflowEdo> toTestThreeTaskWorkflowEdoList(final List<TestThreeTaskWorkflowEntity> modelList) {
    final List<TestThreeTaskWorkflowEdo> edoList = new ArrayList<>();
    for (final TestThreeTaskWorkflowEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<SingleTaskWorkflowEdo> toSingleTaskWorkflowEdoList(final List<SingleTaskWorkflowEntity> modelList) {
    final List<SingleTaskWorkflowEdo> edoList = new ArrayList<>();
    for (final SingleTaskWorkflowEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeEdo> toWorkflowTypeEdoList(final List<WorkflowTypeEntity> modelList) {
    final List<WorkflowTypeEdo> edoList = new ArrayList<>();
    for (final WorkflowTypeEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserGroupEdo> toUserGroupEdoList(final List<UserGroupEntity> modelList) {
    final List<UserGroupEdo> edoList = new ArrayList<>();
    for (final UserGroupEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentEdo> toDepartmentEdoList(final List<DepartmentEntity> modelList) {
    final List<DepartmentEdo> edoList = new ArrayList<>();
    for (final DepartmentEntity model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserEdo> toUserEdoList(final List<UserEntity> modelList) {
    final List<UserEdo> edoList = new ArrayList<>();
    for (final UserEntity model : modelList) {
      edoList.add(toEdo(model));
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
