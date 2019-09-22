package com.pth.iflow.gui.models.mapper;

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
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowCreateRequestEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.GuiCompany;
import com.pth.iflow.gui.models.GuiCompanyProfile;
import com.pth.iflow.gui.models.GuiDepartment;
import com.pth.iflow.gui.models.GuiDepartmentGroup;
import com.pth.iflow.gui.models.GuiProfileResponse;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiUserAuthenticationResponse;
import com.pth.iflow.gui.models.GuiUserGroup;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowAction;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowFileVersion;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiWorkflowTypeStep;

public class GuiModelEdoMapper {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public static CompanyEdo toEdo(final GuiCompany model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentifyid(model.getIdentifyid());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setId(model.getId());

    return edo;
  }

  public static GuiCompany fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiCompany model = new GuiCompany();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentifyid(edo.getIdentifyid());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());

    return model;
  }

  public static DepartmentEdo toEdo(final GuiDepartment model) {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setDepartmentGroups(GuiModelEdoMapper.toDepartmentGroupEdoList(model.getDepartmentGroups()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static GuiDepartment fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiDepartment model = new GuiDepartment();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setDepartmentGroups(GuiModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

  public static DepartmentGroupEdo toEdo(final GuiDepartmentGroup model) {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setDepartmentId(model.getDepartmentId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static GuiDepartmentGroup fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiDepartmentGroup model = new GuiDepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDepartmentId(edo.getDepartmentId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static UserEdo toEdo(final GuiUser model) {
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
    edo.setRoles(model.getRolesInt());

    return edo;
  }

  public static GuiUser fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiUser model = new GuiUser();

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

  public static UserGroupEdo toEdo(final GuiUserGroup model) {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static GuiUserGroup fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiUserGroup model = new GuiUserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowEdo toEdo(final GuiWorkflow model) {
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
    edo.setCommand(model.getCommand().getName());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static GuiWorkflow fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiWorkflow model = new GuiWorkflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(fromEdo(edo.getCurrentStep()));
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());
    model.setNextAssign(edo.getNextAssign());
    model.setAssignTo(edo.getAssignTo());
    model.setCommand(EWorkflowProcessCommand.valueFromName(edo.getCommand()));

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static WorkflowActionEdo toEdo(final GuiWorkflowAction model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setAction(model.getAction());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus().getValue().intValue());
    edo.setId(model.getId());
    edo.setCreatedBy(model.getCreatedBy());
    edo.setOldStep(model.getOldStep());
    edo.setNewStep(model.getNewStep());
    edo.setNextAssign(model.getNextAssign());
    edo.setWorkflowId(model.getWorkflowId());
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static GuiWorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiWorkflowAction model = new GuiWorkflowAction();

    model.setAction(edo.getAction());
    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setOldStep(edo.getOldStep());
    model.setNewStep(edo.getNewStep());
    model.setNextAssign(edo.getNextAssign());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static WorkflowTypeStepEdo toEdo(final GuiWorkflowTypeStep model) {
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

  public static GuiWorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiWorkflowTypeStep model = new GuiWorkflowTypeStep();

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

  public static WorkflowFileEdo toEdo(final GuiWorkflowFile model) {
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

  public static GuiWorkflowFile fromEdo(final WorkflowFileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final GuiWorkflowFile model = new GuiWorkflowFile();

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

  public static WorkflowFileVersionEdo toEdo(final GuiWorkflowFileVersion model) {
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

  public static GuiWorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final GuiWorkflowFileVersion model = new GuiWorkflowFileVersion();

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

  public static WorkflowTypeEdo toEdo(final GuiWorkflowType model) {
    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setId(model.getId());
    edo.setCompanyId(model.getCompanyId());
    edo.setBaseTypeId(model.getBaseTypeId());
    edo.setSendToController(model.getSendToController());
    edo.setAssignType(model.geAssignType().getValue());
    edo.setIncreaseStepAutomatic(model.getIncreaseStepAutomatic());
    edo.setAllowAssign(model.getAllowAssign());
    edo.setSteps(toWorkflowTypeStepEdoList(model.getSteps()));
    edo.setVersion(model.getVersion());

    return edo;
  }

  public static GuiWorkflowType fromEdo(final WorkflowTypeEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final GuiWorkflowType model = new GuiWorkflowType();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setBaseTypeId(edo.getBaseTypeId());
    model.setSendToController(edo.getSendToController());
    model.setAssignType(EWorkflowTypeAssignType.ofValue(edo.getAssignType()));
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(fromWorkflowTypeStepEdoList(edo.getSteps()));

    return model;
  }

  public static WorkflowSearchFilterEdo toEdo(final GuiWorkflowSearchFilter model) {
    final WorkflowSearchFilterEdo edo = new WorkflowSearchFilterEdo();
    edo.setAssignedUserIdList(model.getAssignedUserIdList());
    edo.setStatusList(model.getStatusList());
    edo.setTitle(model.getTitle());
    edo.setWorkflowStepeIdList(model.getWorkflowStepeIdList());
    edo.setWorkflowTypeIdList(model.getWorkflowTypeIdList());

    return edo;
  }

  public static GuiWorkflowSearchFilter fromEdo(final WorkflowSearchFilterEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiWorkflowSearchFilter model = new GuiWorkflowSearchFilter();
    model.setAssignedUserIdList(edo.getAssignedUserIdList());
    model.setStatusList(edo.getStatusList());
    model.setTitle(edo.getTitle());
    model.setWorkflowStepeIdList(edo.getWorkflowStepeIdList());
    model.setWorkflowTypeIdList(edo.getWorkflowTypeIdList());

    return model;

  }

  public static List<WorkflowFileVersionEdo> toWorkflowFileVersionEdoList(final List<GuiWorkflowFileVersion> modelList) {
    final List<WorkflowFileVersionEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowFileVersion model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<GuiWorkflowFileVersion> fromWorkflowFileVersionEdoList(final List<WorkflowFileVersionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiWorkflowFileVersion> modelList = new ArrayList<>();
    for (final WorkflowFileVersionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowFileEdo> toWorkflowFileEdoList(final List<GuiWorkflowFile> modelList) {
    final List<WorkflowFileEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowFile model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<GuiWorkflowFile> fromWorkflowFileEdoList(final List<WorkflowFileEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiWorkflowFile> modelList = new ArrayList<>();
    for (final WorkflowFileEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowActionEdo> toWorkflowActionEdoList(final List<GuiWorkflowAction> modelList) {
    final List<WorkflowActionEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowAction model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<GuiWorkflowAction> fromWorkflowActionEdoList(final List<WorkflowActionEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiWorkflowAction> modelList = new ArrayList<>();
    for (final WorkflowActionEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowTypeStepEdo> toWorkflowTypeStepEdoList(final List<GuiWorkflowTypeStep> modelList) {
    final List<WorkflowTypeStepEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowTypeStep model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<GuiWorkflowTypeStep> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiWorkflowTypeStep> modelList = new ArrayList<>();
    for (final WorkflowTypeStepEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<DepartmentGroupEdo> toDepartmentGroupEdoList(final List<GuiDepartmentGroup> modelList) {
    final List<DepartmentGroupEdo> edoList = new ArrayList<>();
    for (final GuiDepartmentGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<GuiDepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiDepartmentGroup> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<WorkflowEdo> toWorkflowEdoList(final List<GuiWorkflow> modelList) {
    final List<WorkflowEdo> edoList = new ArrayList<>();
    for (final GuiWorkflow model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<WorkflowTypeEdo> toWorkflowTypeEdoList(final List<GuiWorkflowType> modelList) {
    final List<WorkflowTypeEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowType model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserGroupEdo> toUserGroupEdoList(final List<GuiUserGroup> modelList) {
    final List<UserGroupEdo> edoList = new ArrayList<>();
    for (final GuiUserGroup model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<DepartmentEdo> toDepartmentEdoList(final List<GuiDepartment> modelList) {
    final List<DepartmentEdo> edoList = new ArrayList<>();
    for (final GuiDepartment model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<UserEdo> toUserEdoList(final List<GuiUser> modelList) {
    final List<UserEdo> edoList = new ArrayList<>();
    for (final GuiUser model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static GuiCompanyProfile fromEdo(final CompanyProfileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiCompanyProfile model = new GuiCompanyProfile(fromEdo(edo.getCompany()), fromDepartmentEdoList(edo.getDepartments()),
        fromUserGroupEdoList(edo.getUserGroups()));

    return model;
  }

  public static CompanyProfileEdo toEdo(final GuiCompanyProfile model) {
    final CompanyProfileEdo edo = new CompanyProfileEdo(toEdo(model.getCompany()), toDepartmentEdoList(model.getDepartments()),
        toUserGroupEdoList(model.getUserGroups()));

    return edo;
  }

  public static ProfileResponseEdo toEdo(final GuiProfileResponse model) {
    return new ProfileResponseEdo(toEdo(model.getUser()), toEdo(model.getCompanyProfile()), model.getSessionid());
  }

  public static List<GuiDepartment> fromDepartmentEdoList(final List<DepartmentEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiDepartment> modelList = new ArrayList<>();
    for (final DepartmentEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<GuiUserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiUserGroup> modelList = new ArrayList<>();
    for (final UserGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static WorkflowCreateRequestEdo toEdo(final GuiWorkflowCreateRequest model) {
    final WorkflowCreateRequestEdo edo = new WorkflowCreateRequestEdo(toEdo(model.getWorkflow()), model.getAssigns());

    return edo;
  }

  public static GuiWorkflowCreateRequest fromEdo(final WorkflowCreateRequestEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final GuiWorkflowCreateRequest model = new GuiWorkflowCreateRequest(fromEdo(edo.getWorkflow()), edo.getAssignedUsers());

    return model;
  }

  public static List<GuiWorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<GuiWorkflowType> modelList = new ArrayList<>();
    for (final WorkflowTypeEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<GuiWorkflow> fromWorkflowEdoList(final List<WorkflowEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<GuiWorkflow> modelList = new ArrayList<>();
    for (final WorkflowEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static GuiProfileResponse fromEdo(final ProfileResponseEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    return new GuiProfileResponse(fromEdo(edo.getUser()), fromEdo(edo.getCompanyProfile()), edo.getSessionid());

  }

  public static GuiUserAuthenticationResponse fromEdo(final UserAuthenticationResponseEdo edo)
      throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final GuiUserAuthenticationResponse model = new GuiUserAuthenticationResponse();
    model.setCreated(edo.getCreated());
    model.setEmail(edo.getEmail());
    model.setLastAccess(edo.getLastAccess());
    model.setSessionid(edo.getSessionid());
    model.setToken(edo.getToken());
    return model;
  }

  public static List<GuiUser> fromUserEdoList(final List<UserEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<GuiUser> modelList = new ArrayList<>();
    for (final UserEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
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
