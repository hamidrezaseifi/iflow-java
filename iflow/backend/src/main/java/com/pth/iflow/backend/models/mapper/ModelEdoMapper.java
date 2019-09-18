package com.pth.iflow.backend.models.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import com.pth.iflow.backend.models.BackendCompany;
import com.pth.iflow.backend.models.BackendCompanyProfile;
import com.pth.iflow.backend.models.BackendDepartment;
import com.pth.iflow.backend.models.BackendDepartmentGroup;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.BackendUserGroup;
import com.pth.iflow.backend.models.BackendWorkflow;
import com.pth.iflow.backend.models.BackendWorkflowAction;
import com.pth.iflow.backend.models.BackendWorkflowCreateRequest;
import com.pth.iflow.backend.models.BackendWorkflowFile;
import com.pth.iflow.backend.models.BackendWorkflowFileVersion;
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.models.BackendWorkflowTypeStep;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.edo.models.xml.CompanyProfileEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public class ModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public static CompanyEdo toEdo(final BackendCompany model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentifyid(model.getIdentifyid());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setId(model.getId());

    return edo;
  }

  public static BackendCompany fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendCompany model = new BackendCompany();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentifyid(edo.getIdentifyid());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());

    return model;
  }

  public static DepartmentEdo toEdo(final BackendDepartment model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setDepartmentGroups(ModelEdoMapper.toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static BackendDepartment fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendDepartment model = new BackendDepartment();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setDepartmentGroups(ModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

  public static DepartmentGroupEdo toEdo(final BackendDepartmentGroup model) {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setDepartmentId(model.getDepartmentId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static BackendDepartmentGroup fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendDepartmentGroup model = new BackendDepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDepartmentId(edo.getDepartmentId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static UserEdo toEdo(final BackendUser model) {
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
    edo.setRoles(model.getRoles().stream().map(r -> r.getId()).collect(Collectors.toList()));

    return edo;
  }

  public static WorkflowCreateRequestEdo toEdo(final BackendWorkflowCreateRequest model) {
    final WorkflowCreateRequestEdo edo = new WorkflowCreateRequestEdo();
    edo.setAssignedUsers(model.getAssigns());
    edo.setWorkflow(toEdo(model.getWorkflow()));
    return edo;
  }

  public static BackendUser fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendUser model = new BackendUser();

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

  public static ProfileResponse fromEdo(final ProfileResponseEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final ProfileResponse model = new ProfileResponse();

    model.setCompanyProfile(fromEdo(edo.getCompanyProfile()));
    model.setSessionid(edo.getSessionid());
    model.setUser(fromEdo(edo.getUser()));

    return model;
  }

  private static BackendCompanyProfile fromEdo(final CompanyProfileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendCompanyProfile model = new BackendCompanyProfile();

    model.setCompany(fromEdo(edo.getCompany()));
    model.setDepartments(fromDepartmentEdoList(edo.getDepartments()));
    model.setUserGroups(fromUserGroupEdoList(edo.getUserGroups()));

    return model;
  }

  public static UserGroupEdo toEdo(final BackendUserGroup model) {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static BackendUserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendUserGroup model = new BackendUserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowEdo toEdo(final BackendWorkflow model) {
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

  public static BackendWorkflow fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendWorkflow model = new BackendWorkflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(EWorkflowStatus.ofValue(edo.getStatus()));
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

  public static WorkflowActionEdo toEdo(final BackendWorkflowAction model) {
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

  public static BackendWorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendWorkflowAction model = new BackendWorkflowAction();

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

  public static WorkflowTypeStepEdo toEdo(final BackendWorkflowTypeStep model) {
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

  public static BackendWorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final BackendWorkflowTypeStep model = new BackendWorkflowTypeStep();

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

  public static WorkflowFileEdo toEdo(final BackendWorkflowFile model) {
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

  public static BackendWorkflowFile fromEdo(final WorkflowFileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final BackendWorkflowFile model = new BackendWorkflowFile();

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

  public static WorkflowFileVersionEdo toEdo(final BackendWorkflowFileVersion model) {
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

  public static BackendWorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final BackendWorkflowFileVersion model = new BackendWorkflowFileVersion();

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

  public static WorkflowTypeEdo toEdo(final BackendWorkflowType model) {
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

  public static BackendWorkflowType fromEdo(final WorkflowTypeEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final BackendWorkflowType model = new BackendWorkflowType();

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

  public static List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<BackendWorkflowFileVersion> modelList) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowFileVersion model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendWorkflowFileVersion> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowFileVersion> modelList = new ArrayList<>();
    for (final WorkflowFileVersionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowFileEdo> toWorkflowFileEdoList(final List<BackendWorkflowFile> modelList) {
    final List<WorkflowFileEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowFile model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendWorkflowFile> fromWorkflowFileEdoList(final List<WorkflowFileEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowFile> modelList = new ArrayList<>();
    for (final WorkflowFileEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowActionEdo> toWorkflowActionEdoList(final List<BackendWorkflowAction> modelList) {
    final List<WorkflowActionEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowAction model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendWorkflowAction> fromWorkflowActionEdoList(final List<WorkflowActionEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowAction> modelList = new ArrayList<>();
    for (final WorkflowActionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowTypeStepEdo> toWorkflowTypeStepEdoList(final List<BackendWorkflowTypeStep> modelList) {
    final List<WorkflowTypeStepEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowTypeStep model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendWorkflowTypeStep> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowTypeStep> modelList = new ArrayList<>();
    for (final WorkflowTypeStepEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<BackendWorkflow> fromWorkflowEdoList(final List<WorkflowEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflow> modelList = new ArrayList<>();
    for (final WorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<BackendWorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowType> modelList = new ArrayList<>();
    for (final WorkflowTypeEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<DepartmentGroupEdo> toDepartmentGroupEdoList(final List<BackendDepartmentGroup> modelList) {
    final List<DepartmentGroupEdo> edoList = new ArrayList<>();
    for (final BackendDepartmentGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendDepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendDepartmentGroup> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowEdo> toWorkflowEdoList(final List<BackendWorkflow> modelList) {
    final List<WorkflowEdo> edoList = new ArrayList<>();
    for (final BackendWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeEdo> toWorkflowTypeEdoList(final List<BackendWorkflowType> modelList) {
    final List<WorkflowTypeEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowType model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserGroupEdo> toUserGroupEdoList(final List<BackendUserGroup> modelList) {
    final List<UserGroupEdo> edoList = new ArrayList<>();
    for (final BackendUserGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentEdo> toDepartmentEdoList(final List<BackendDepartment> modelList) {
    final List<DepartmentEdo> edoList = new ArrayList<>();
    for (final BackendDepartment model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserEdo> toUserEdoList(final List<BackendUser> modelList) {
    final List<UserEdo> edoList = new ArrayList<>();
    for (final BackendUser model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendUser> fromUserEdoList(final List<UserEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendUser> modelList = new ArrayList<>();
    for (final UserEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static List<BackendUserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendUserGroup> modelList = new ArrayList<>();
    for (final UserGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static List<BackendDepartment> fromDepartmentEdoList(final List<DepartmentEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<BackendDepartment> modelList = new ArrayList<>();
    for (final DepartmentEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static <E> void validateCustomer(final E model) throws IFlowMessageConversionFailureException {
    final Set<ConstraintViolation<E>> violations = VALIDATOR.validate(model);
    if (violations != null && violations.size() > 0) {
      final String validationErrorMessage = createValidationErrorMessage(violations);
      throw new IFlowMessageConversionFailureException("Validation Error");
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
