package com.pth.iflow.core.model.mapper;

import java.util.Set;
import java.util.Set;
import java.util.HashSet;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
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
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public class CoreModelEdoMapper {

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
    edo.setWorkflowIdentity(model.getWorkflow().getIdentity());
    edo.setMessageType(model.getMessageType().getValue());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(model.getCreatedAt());
    model.setStepIdentity(edo.getStepIdentity());

    return edo;
  }

  public static DepartmentEdo toEdo(final Department model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setDepartmentGroups(CoreModelEdoMapper.toDepartmentGroupEdoSet(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static ICoreIdentityModel fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setDepartmentGroups(CoreModelEdoMapper.fromDepartmentGroupEdoSet(edo.getDepartmentGroups()));
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

    return edo;
  }

  public static UserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserGroup model = new UserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowEdo toEdo(final Workflow model) {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

    edo.setFiles(toWorkflowFileEdoSet(model.getFiles()));
    edo.setActions(toWorkflowActionEdoSet(model.getActions()));

    return edo;
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
    model.setWorkflowTypeIdentity(edo.getWorkflowTypeIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoSet(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoSet(edo.getActions()));

    return model;
  }

  public static WorkflowActionEdo toEdo(final WorkflowAction model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setAssignToIdentity(model.getAssignToIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());

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
    edo.setCreatedBy(model.getCreatedBy());
    edo.setActiveFilePath(model.getActiveFilePath());
    edo.setActiveFileVersion(model.getActiveFileVersion());
    edo.setVersion(model.getVersion());

    edo.setFileVersions(toWorkflowFileVersionEdoSet(model.getFileVersions()));

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
    model.setCreatedBy(edo.getCreatedBy());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setVersion(edo.getVersion());

    model.setFileVersions(fromWorkflowFileVersionEdoSet(edo.getFileVersions()));

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
    edo.setBaseTypeId(model.getBaseTypeId());
    edo.setSendToController(model.getSendToController());
    edo.setAssignType(model.geAssignType().getValue());
    edo.setIncreaseStepAutomatic(model.getIncreaseStepAutomatic());
    edo.setAllowAssign(model.getAllowAssign());
    edo.setSteps(toWorkflowTypeStepEdoSet(model.getSteps()));
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
    model.setBaseTypeId(edo.getBaseTypeId());
    model.setSendToController(edo.getSendToController());
    model.setAssignType(EWorkflowTypeAssignType.ofValue(edo.getAssignType()));
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(fromWorkflowTypeStepEdoSet(edo.getSteps()));

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

  public static Set<WorkflowFileVersionEdo> toWorkflowFileVersionEdoSet(final Set<WorkflowFileVersion> modelSet) {
    final Set<WorkflowFileVersionEdo> edoSet = new HashSet<>();
    for (final WorkflowFileVersion model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowFileVersion> fromWorkflowFileVersionEdoSet(final Set<WorkflowFileVersionEdo> edoSet)
      throws IFlowMessageConversionFailureException {
    final Set<WorkflowFileVersion> modelSet = new HashSet<>();
    for (final WorkflowFileVersionEdo edo : edoSet) {
      modelSet.add(fromEdo(edo));
    }

    return modelSet;
  }

  public static Set<WorkflowFileEdo> toWorkflowFileEdoSet(final Set<WorkflowFile> modelSet) {
    final Set<WorkflowFileEdo> edoSet = new HashSet<>();
    for (final WorkflowFile model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowFile> fromWorkflowFileEdoSet(final Set<WorkflowFileEdo> edoSet)
      throws IFlowMessageConversionFailureException {
    final Set<WorkflowFile> modelSet = new HashSet<>();
    for (final WorkflowFileEdo edo : edoSet) {
      modelSet.add(fromEdo(edo));
    }

    return modelSet;
  }

  public static Set<WorkflowActionEdo> toWorkflowActionEdoSet(final Set<WorkflowAction> modelSet) {
    final Set<WorkflowActionEdo> edoSet = new HashSet<>();
    for (final WorkflowAction model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowMessageEdo> toWorkflowMessageEdoSet(final Set<WorkflowMessage> modelSet) {
    final Set<WorkflowMessageEdo> edoSet = new HashSet<>();
    for (final WorkflowMessage model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowAction> fromWorkflowActionEdoSet(final Set<WorkflowActionEdo> edoSet)
      throws IFlowMessageConversionFailureException {
    final Set<WorkflowAction> modelSet = new HashSet<>();
    for (final WorkflowActionEdo edo : edoSet) {
      modelSet.add(fromEdo(edo));
    }

    return modelSet;
  }

  public static Set<WorkflowTypeStepEdo> toWorkflowTypeStepEdoSet(final Set<WorkflowTypeStep> modelSet) {
    final Set<WorkflowTypeStepEdo> edoSet = new HashSet<>();
    for (final WorkflowTypeStep model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowTypeStep> fromWorkflowTypeStepEdoSet(final Set<WorkflowTypeStepEdo> edoSet)
      throws IFlowMessageConversionFailureException {
    final Set<WorkflowTypeStep> modelSet = new HashSet<>();
    for (final WorkflowTypeStepEdo edo : edoSet) {
      modelSet.add(fromEdo(edo));
    }

    return modelSet;
  }

  public static Set<DepartmentGroupEdo> toDepartmentGroupEdoSet(final Set<DepartmentGroup> modelSet) {
    final Set<DepartmentGroupEdo> edoSet = new HashSet<>();
    for (final DepartmentGroup model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<DepartmentGroup> fromDepartmentGroupEdoSet(final Set<DepartmentGroupEdo> edoSet)
      throws IFlowMessageConversionFailureException {
    final Set<DepartmentGroup> modelSet = new HashSet<>();
    for (final DepartmentGroupEdo edo : edoSet) {
      modelSet.add(fromEdo(edo));
    }

    return modelSet;
  }

  public static Set<WorkflowEdo> toWorkflowEdoSet(final Set<Workflow> modelSet) {
    final Set<WorkflowEdo> edoSet = new HashSet<>();
    for (final Workflow model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<WorkflowTypeEdo> toWorkflowTypeEdoSet(final Set<WorkflowType> modelSet) {
    final Set<WorkflowTypeEdo> edoSet = new HashSet<>();
    for (final WorkflowType model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<UserGroupEdo> toUserGroupEdoSet(final Set<UserGroup> modelSet) {
    final Set<UserGroupEdo> edoSet = new HashSet<>();
    for (final UserGroup model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<DepartmentEdo> toDepartmentEdoSet(final Set<Department> modelSet) {
    final Set<DepartmentEdo> edoSet = new HashSet<>();
    for (final Department model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
  }

  public static Set<UserEdo> toUserEdoSet(final Set<User> modelSet) {
    final Set<UserEdo> edoSet = new HashSet<>();
    for (final User model : modelSet) {
      edoSet.add(toEdo(model));
    }

    return edoSet;
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
