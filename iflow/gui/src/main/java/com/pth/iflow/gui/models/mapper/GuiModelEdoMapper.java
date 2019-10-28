package com.pth.iflow.gui.models.mapper;

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
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.DepartmentGroup;
import com.pth.iflow.gui.models.ProfileResponse;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserAuthenticationResponse;
import com.pth.iflow.gui.models.UserGroup;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowFileVersion;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;

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
    edo.setRoles(model.getRolesInt());

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

  public static WorkflowEdo toEdo(final Workflow model) {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatusInt());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStep() != null ? model.getCurrentStep().getIdentity() : null);
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());
    edo.setVersion(model.getVersion());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setIdentity(model.getIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }

  public static Workflow fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final Workflow model = new Workflow();

    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setWorkflowTypeIdentity(edo.getWorkflowTypeIdentity());
    model.setVersion(edo.getVersion());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  public static WorkflowActionEdo toEdo(final WorkflowAction model) {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus().getValue().intValue());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setVersion(model.getVersion());
    edo.setAssignToIdentity(model.getAssignToIdentity());

    return edo;
  }

  public static WorkflowAction fromEdo(final WorkflowActionEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowAction model = new WorkflowAction();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setVersion(edo.getVersion());
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
    edo.setVersion(model.getVersion());
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
    model.setVersion(edo.getVersion());
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

  public static CompanyProfile fromEdo(final CompanyProfileEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final CompanyProfile model = new CompanyProfile(fromEdo(edo.getCompany()), fromDepartmentEdoList(edo.getDepartments()),
        fromUserGroupEdoList(edo.getUserGroups()));

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

  public static List<Department> fromDepartmentEdoList(final List<DepartmentEdo> edoList)
      throws IFlowMessageConversionFailureException {
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

  public static WorkflowSaveRequestEdo toEdo(final WorkflowSaveRequest model) throws IFlowMessageConversionFailureException {
    final WorkflowSaveRequestEdo edo = new WorkflowSaveRequestEdo();

    edo.setWorkflow(toEdo(model.getWorkflow()));
    edo.setExpireDays(model.getExpireDays());
    edo.setAssigns(toAssignItemEdoList(model.getAssigns()));
    edo.setCommand(model.getCommand().getName());

    return edo;
  }

  public static WorkflowSaveRequest fromEdo(final WorkflowSaveRequestEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);
    final WorkflowSaveRequest model = new WorkflowSaveRequest();

    model.setWorkflow(fromEdo(edo.getWorkflow()));
    model.setExpireDays(edo.getExpireDays());
    model.setAssigns(fromAssignItemEdoList(edo.getAssigns()));
    model.setCommand(EWorkflowProcessCommand.valueFromName(edo.getCommand()));

    return model;
  }

  public static List<AssignItem> fromAssignItemEdoList(final List<AssignItemEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<AssignItem> modelList = new ArrayList<>();
    for (final AssignItemEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static AssignItem fromEdo(final AssignItemEdo edo) {
    return new AssignItem(edo.getItemIdentity(), EAssignType.valueFromName(edo.getItemType()));
  }

  public static List<AssignItemEdo> toAssignItemEdoList(final List<AssignItem> modelList)
      throws IFlowMessageConversionFailureException {
    final List<AssignItemEdo> edoList = new ArrayList<>();
    for (final AssignItem model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  private static AssignItemEdo toEdo(final AssignItem model) {
    return new AssignItemEdo(model.getItemIdentity(), model.getItemType().getName());
  }

  public static List<WorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowType> modelList = new ArrayList<>();
    for (final WorkflowTypeEdo edo : edoList) {
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

  public static UserAuthenticationResponse fromEdo(final UserAuthenticationResponseEdo edo)
      throws IFlowMessageConversionFailureException {
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
