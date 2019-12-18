package com.pth.iflow.common.models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.helper.DateEdoAdapter;
import com.pth.iflow.common.edo.models.helper.StringToStringCollection;

import io.micrometer.core.lang.Nullable;

@XmlRootElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "User" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserEdo {

  @NotNull(message = "CompanyIdentity must not be null")
  @XmlElement(name = "CompanyIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String             companyIdentity;

  @NotNull(message = "Email must not be null")
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String             email;

  @XmlJavaTypeAdapter(DateEdoAdapter.class)
  @XmlElement(name = "BirthDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDate          birthDate;

  @NotNull(message = "FirstName must not be null")
  @XmlElement(name = "FirstName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String             firstName;

  @NotNull(message = "LastName must not be null")
  @XmlElement(name = "LastName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String             lastName;

  @NotNull(message = "Status must not be null")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer            status;

  @NotNull(message = "Version must not be null")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer            version;

  @NotNull(message = "Permission must not be null")
  @XmlElement(name = "Permission", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer            permission;

  @NotNull(message = "GroupList must not be null")
  @XmlElementWrapper(name = "GroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Group")
  @JsonDeserialize(using = StringToStringCollection.class)
  private final Set<String>  groups           = new HashSet<>();

  @NotNull(message = "DepartmentList must not be null")
  @XmlElementWrapper(name = "DepartmentList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Department", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @JsonDeserialize(using = StringToStringCollection.class)
  private final Set<String>  departments      = new HashSet<>();

  @NotNull(message = "DepartmentGroupList must not be null")
  @XmlElementWrapper(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentGroup", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @JsonDeserialize(using = StringToStringCollection.class)
  private final Set<String>  departmentGroups = new HashSet<>();

  @NotNull(message = "DeputyList must not be null")
  @XmlElementWrapper(name = "DeputyList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Deputy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @JsonDeserialize(using = StringToStringCollection.class)
  private final Set<String>  deputies         = new HashSet<>();

  @NotNull(message = "RoleList must not be null")
  @XmlElementWrapper(name = "RoleList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Role", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<Integer> roles            = new HashSet<>();

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

  public Set<String> getGroups() {
    return this.groups;
  }

  @JsonSetter
  public void setGroups(final Collection<String> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final String groupId) {
    this.groups.add(groupId);
  }

  public Set<String> getDepartments() {
    return this.departments;
  }

  @JsonSetter
  public void setDepartments(final Collection<String> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final String departmentId) {
    this.departments.add(departmentId);
  }

  public Set<String> getDepartmentGroups() {
    return this.departmentGroups;
  }

  @JsonSetter
  public void setDepartmentGroups(@Nullable final Collection<String> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final String departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public Set<String> getDeputies() {
    return this.deputies;
  }

  @JsonSetter
  public void setDeputies(final Collection<String> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final String deputyId) {
    this.deputies.add(deputyId);
  }

  public Set<Integer> getRoles() {
    return this.roles;
  }

  @JsonSetter
  public void setRoles(final Set<Integer> roles) {
    this.roles.clear();
    if (roles != null) {
      this.roles.addAll(roles);
    }
  }

  public void addRole(final Integer role) {
    this.roles.add(role);
  }

}
