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
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.models.BackendWorkflowTypeStep;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.CompanyProfileEdo;
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public class BackendModelEdoMapper {

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
    edo.setDepartmentGroups(BackendModelEdoMapper.toDepartmentGroupEdoList(model.getDepartmentGroups()));
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
    model.setDepartmentGroups(BackendModelEdoMapper.fromDepartmentGroupEdoList(edo.getDepartmentGroups()));
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

  public static WorkflowTypeEdo toEdo(final BackendWorkflowType model) {
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
    model.setAssignType(EWorkflowTypeAssignType.ofValue(edo.getAssignType()));
    model.setAllowAssign(edo.getAllowAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(fromWorkflowTypeStepEdoList(edo.getSteps()));

    return model;
  }

  public static List<WorkflowTypeStepEdo> toWorkflowTypeStepEdoList(final List<BackendWorkflowTypeStep> modelList) {
    final List<WorkflowTypeStepEdo> edoList = new ArrayList<>();
    for (final BackendWorkflowTypeStep model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public static List<BackendWorkflowTypeStep> fromWorkflowTypeStepEdoList(final List<WorkflowTypeStepEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<BackendWorkflowTypeStep> modelList = new ArrayList<>();
    for (final WorkflowTypeStepEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  public static List<BackendWorkflowType> fromWorkflowTypeEdoList(final List<WorkflowTypeEdo> edoList)
      throws IFlowMessageConversionFailureException {
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

  public static List<BackendDepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<BackendDepartmentGroup> modelList = new ArrayList<>();
    for (final DepartmentGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
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

  private static List<BackendUserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<BackendUserGroup> modelList = new ArrayList<>();
    for (final UserGroupEdo edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  private static List<BackendDepartment> fromDepartmentEdoList(final List<DepartmentEdo> edoList)
      throws IFlowMessageConversionFailureException {
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
