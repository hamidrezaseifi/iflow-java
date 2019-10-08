package com.pth.iflow.common.edo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.helper.DateEdoAdapter;

@XmlRootElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "User" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserEdo {

  @NotNull(message = "CompanyIdentity must not be null")
  @XmlElement(name = "CompanyIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              companyIdentity;

  @NotNull(message = "Email must not be null")
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              email;

  @XmlJavaTypeAdapter(DateEdoAdapter.class)
  @XmlElement(name = "BirthDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDate           birthDate;

  @NotNull(message = "FirstName must not be null")
  @XmlElement(name = "FirstName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              firstName;

  @NotNull(message = "LastName must not be null")
  @XmlElement(name = "LastName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              lastName;

  @NotNull(message = "Status must not be null")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             status;

  @NotNull(message = "Version must not be null")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             version;

  @NotNull(message = "Permission must not be null")
  @XmlElement(name = "Permission", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             permission;

  @NotNull(message = "GroupList must not be null")
  @XmlElementWrapper(name = "GroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Group")
  private final List<String>  groups           = new ArrayList<>();

  @NotNull(message = "DepartmentList must not be null")
  @XmlElementWrapper(name = "DepartmentList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Department", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<String>  departments      = new ArrayList<>();

  @NotNull(message = "DepartmentGroupList must not be null")
  @XmlElementWrapper(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentGroup", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<String>  departmentGroups = new ArrayList<>();

  @NotNull(message = "DeputyList must not be null")
  @XmlElementWrapper(name = "DeputyList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Deputy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<String>  deputies         = new ArrayList<>();

  @NotNull(message = "RoleList must not be null")
  @XmlElementWrapper(name = "RoleList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Role", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<Integer> roles            = new ArrayList<>();

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(final LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  /**
   * @return the permission
   */
  public Integer getPermission() {
    return this.permission;
  }

  /**
   * @param permission the permission to set
   */
  public void setPermission(final Integer permission) {
    this.permission = permission;
  }

  public List<String> getGroups() {
    return this.groups;
  }

  @JsonSetter
  public void setGroups(final List<String> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final String groupId) {
    this.groups.add(groupId);
  }

  public List<String> getDepartments() {
    return this.departments;
  }

  @JsonSetter
  public void setDepartments(final List<String> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final String departmentId) {
    this.departments.add(departmentId);
  }

  public List<String> getDepartmentGroups() {
    return this.departmentGroups;
  }

  @JsonSetter
  public void setDepartmentGroups(final List<String> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final String departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public List<String> getDeputies() {
    return this.deputies;
  }

  @JsonSetter
  public void setDeputies(final List<String> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final String deputyId) {
    this.deputies.add(deputyId);
  }

  public List<Integer> getRoles() {
    return this.roles;
  }

  @JsonSetter
  public void setRoles(final List<Integer> roles) {
    this.roles.clear();
    if (roles != null) {
      this.roles.addAll(roles);
    }
  }

  public void addRole(final Integer role) {
    this.roles.add(role);
  }

}
