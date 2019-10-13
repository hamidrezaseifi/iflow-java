package com.pth.iflow.profile.model.mapper;

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
import com.pth.iflow.common.edo.models.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyProfile;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.WorkflowMessage;

public class ProfileModelEdoMapper {

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
    edo.setWorkflowIdentity(model.getWorkflowIdentity());
    edo.setMessageType(model.getMessageType().getValue());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(model.getCreatedAt());
    edo.setStepIdentity(model.getStepIdentity());

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

  public static UserAuthenticationResponseEdo toEdo(final UserAuthenticationSession model) {
    final UserAuthenticationResponseEdo edo = new UserAuthenticationResponseEdo();
    edo.setSessionid(model.getSessionid());
    edo.setToken(model.getToken());
    edo.setEmail(model.getEmail());
    edo.setCreated(model.getCreatedLong());
    edo.setLastAccess(model.getLastAccessLong());

    return edo;
  }

  public static UserAuthenticationRequestEdo toEdo(final UserAuthenticationRequest model) {
    final UserAuthenticationRequestEdo edo = new UserAuthenticationRequestEdo();
    edo.setCompanyIdentity(model.getCompanyIdentity());
    edo.setEmail(model.getEmail());
    edo.setPassword(model.getPassword());

    return edo;
  }

  public static UserAuthenticationRequest fromEdo(final UserAuthenticationRequestEdo edo) {
    final UserAuthenticationRequest user = new UserAuthenticationRequest();

    user.setCompanyIdentity(edo.getCompanyIdentity());
    user.setEmail(edo.getEmail());
    user.setPassword(edo.getPassword());

    return user;
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

  public static List<DepartmentGroupEdo> toDepartmentGroupEdoList(final List<DepartmentGroup> modelList) {
    final List<DepartmentGroupEdo> edoList = new ArrayList<>();
    if (modelList != null) {
      for (final DepartmentGroup model : modelList) {
        edoList.add(toEdo(model));
      }
    }

    return edoList;

  }

  public static List<DepartmentGroup> fromDepartmentGroupEdoList(final List<DepartmentGroupEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<DepartmentGroup> modelList = new ArrayList<>();
    if (edoList != null) {
      for (final DepartmentGroupEdo edo : edoList) {
        modelList.add(fromEdo(edo));
      }
    }

    return modelList;
  }

  public static List<UserGroupEdo> toUserGroupEdoList(final List<UserGroup> modelList) {
    final List<UserGroupEdo> edoList = new ArrayList<>();
    if (modelList != null) {

      for (final UserGroup model : modelList) {
        edoList.add(toEdo(model));
      }
    }
    return edoList;
  }

  public static List<DepartmentEdo> toDepartmentEdoList(final List<Department> modelList) {
    final List<DepartmentEdo> edoList = new ArrayList<>();
    if (modelList != null) {
      for (final Department model : modelList) {
        edoList.add(toEdo(model));
      }
    }

    return edoList;
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

  public static List<WorkflowMessage> fromWorkflowMessageEdoList(final List<WorkflowMessageEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<WorkflowMessage> modelList = new ArrayList<>();
    if (modelList != null) {
      for (final WorkflowMessageEdo edo : edoList) {
        modelList.add(fromEdo(edo));
      }
    }

    return modelList;
  }

  public static List<UserEdo> toUserEdoList(final List<User> modelList) {
    final List<UserEdo> edoList = new ArrayList<>();
    if (modelList != null) {
      for (final User model : modelList) {
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

  public static CompanyProfileEdo toEdo(final CompanyProfile model) {
    final CompanyProfileEdo edo = new CompanyProfileEdo(toEdo(model.getCompany()), toDepartmentEdoList(model.getDepartments()),
        toUserGroupEdoList(model.getUserGroups()));

    return edo;
  }

  public static ProfileResponseEdo toEdo(final ProfileResponse model) {
    return new ProfileResponseEdo(toEdo(model.getUser()), toEdo(model.getCompanyProfile()), model.getSessionid());
  }

  public static List<User> fromUserEdoList(final List<UserEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<User> modelList = new ArrayList<>();
    if (edoList != null) {
      for (final UserEdo edo : edoList) {
        modelList.add(fromEdo(edo));
      }
    }
    return modelList;
  }

  public static List<Department> fromDepartmentEdoList(final List<DepartmentEdo> edoList)
      throws IFlowMessageConversionFailureException {
    final List<Department> modelList = new ArrayList<>();
    if (edoList != null) {
      for (final DepartmentEdo edo : edoList) {
        modelList.add(fromEdo(edo));
      }
    }

    return modelList;
  }

  public static List<UserGroup> fromUserGroupEdoList(final List<UserGroupEdo> edoList) throws IFlowMessageConversionFailureException {
    final List<UserGroup> modelList = new ArrayList<>();
    if (edoList != null) {
      for (final UserGroupEdo edo : edoList) {
        modelList.add(fromEdo(edo));
      }
    }
    return modelList;
  }

}
