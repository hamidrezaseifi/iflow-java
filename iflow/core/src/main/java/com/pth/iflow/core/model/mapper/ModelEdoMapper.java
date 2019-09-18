package com.pth.iflow.core.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
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
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public class ModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public static CompanyEdo toEdo(final Company model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentifyid(model.getIdentifyid());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setId(model.getId());

    return edo;
  }

  public static Company fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Company model = new Company();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentifyid(edo.getIdentifyid());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());

    return model;
  }

  public static DepartmentEdo toEdo(final Department model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setDepartmentGroups(ModelEdoMapper.toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static Department fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setDepartmentGroups(ModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

  public static DepartmentGroupEdo toEdo(final DepartmentGroup model) {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setDepartmentId(model.getDepartmentId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static DepartmentGroup fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final DepartmentGroup model = new DepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDepartmentId(edo.getDepartmentId());
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
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
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
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
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
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static UserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserGroup model = new UserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowEdo toEdo(final Workflow model) {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setId(model.getId());
    edo.setController(model.getController());
    edo.setCurrentStep(toEdo(model.getCurrentStep()));
    edo.setCurrentStepId(model.getCurrentStep() != null ? model.getCurrentStep().getId() : null);
    edo.setCreatedBy(model.getCreatedBy());
    edo.setWorkflowTypeId(model.getWorkflowTypeId());
    edo.setVersion(model.getVersion());
    edo.setNextAssign(model.getNextAssign());
    edo.setAssignTo(model.getAssignTo());
    edo.setCommand(model.getCommand());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static Workflow fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Workflow model = new Workflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(fromEdo(edo.getCurrentStep()));
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());
    model.setNextAssign(edo.getNextAssign());
    model.setAssignTo(edo.getAssignTo());
    model.setCommand(edo.getCommand());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static WorkflowActionEdo toEdo(final WorkflowAction model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setAction(model.getAction());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCreatedBy(model.getCreatedBy());
    edo.setOldStep(model.getOldStep());
    edo.setNewStep(model.getNewStep());
    edo.setNextAssign(model.getNextAssign());
    edo.setWorkflowId(model.getWorkflowId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowAction model = new WorkflowAction();

    model.setAction(edo.getAction());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setOldStep(edo.getOldStep());
    model.setNewStep(edo.getNewStep());
    model.setNextAssign(edo.getNextAssign());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowTypeStepEdo toEdo(final WorkflowTypeStep model) {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(model.getStepIndex());
    edo.setViewName(model.getViewName());
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setWorkflowTypeId(model.getWorkflowTypeId());
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
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

  public static WorkflowFileEdo toEdo(final WorkflowFile model) {
    final WorkflowFileEdo edo = new WorkflowFileEdo();
    edo.setTitle(model.getTitle());
    edo.setExtention(model.getExtention());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCreatedBy(model.getCreatedBy());
    edo.setActiveFilePath(model.getActiveFilePath());
    edo.setActiveFileVersion(model.getActiveFileVersion());
    edo.setWorkflowId(model.getWorkflowId());
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
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    model.setFileVersions(fromWorkflowFileVersionEdoList(edo.getFileVersions()));

    return model;
  }

  public static WorkflowFileVersionEdo toEdo(final WorkflowFileVersion model) {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCreatedBy(model.getCreatedBy());
    edo.setFilePath(model.getFilePath());
    edo.setFileVersion(model.getFileVersion());
    edo.setWorkflowFileId(model.getWorkflowFileId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static WorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowFileVersion model = new WorkflowFileVersion();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());
    model.setWorkflowFileId(edo.getWorkflowFileId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowTypeEdo toEdo(final WorkflowType model) {
    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setBaseTypeId(model.getBaseTypeId());
    edo.setSendToController(model.getSendToController());
    edo.setManualAssign(model.getManualAssign());
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
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setBaseTypeId(edo.getBaseTypeId());
    model.setSendToController(edo.getSendToController());
    model.setManualAssign(edo.getManualAssign());
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(fromWorkflowTypeStepEdoList(edo.getSteps()));

    return model;
  }

  public static WorkflowSearchFilterEdo toEdo(final WorkflowSearchFilter model) {
    final WorkflowSearchFilterEdo edo = new WorkflowSearchFilterEdo();
    edo.setAssignedUserIdList(model.getAssignedUserIdList());
    edo.setStatusList(model.getStatusList());
    edo.setTitle(model.getTitle());
    edo.setWorkflowStepeIdList(model.getWorkflowStepeIdList());
    edo.setWorkflowTypeIdList(model.getWorkflowTypeIdList());

    return edo;
  }

  public static WorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) {
    final WorkflowSearchFilter model = new WorkflowSearchFilter();
    model.setAssignedUserIdList(edo.getAssignedUserIdList());
    model.setStatusList(edo.getStatusList());
    model.setTitle(edo.getTitle());
    model.setWorkflowStepeIdList(edo.getWorkflowStepeIdList());
    model.setWorkflowTypeIdList(edo.getWorkflowTypeIdList());

    return model;

  }

  public static List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<WorkflowFileVersion> modelList) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();
    for (final WorkflowFileVersion model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowFileVersion> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> edoList) throws IFlowMessageConversionFailureException {
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

  public static List<WorkflowAction> fromWorkflowActionEdoList(final List<WorkflowActionEdo> edoList) throws IFlowMessageConversionFailureException {
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

  public static List<WorkflowTypeStep> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList) throws IFlowMessageConversionFailureException {
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

  public static List<DepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<DepartmentGroup> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
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
