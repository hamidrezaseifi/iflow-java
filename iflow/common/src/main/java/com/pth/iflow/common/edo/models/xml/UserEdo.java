package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.helper.DateEdoAdapter;

@XmlRootElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "User" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserEdo {

  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long                id;

  @NotNull
  @XmlElement(name = "CompanyId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long                companyId;

  @NotNull
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              email;

  @NotNull
  @XmlJavaTypeAdapter(DateEdoAdapter.class)
  @XmlElement(name = "BirthDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Date                birthDate;

  @NotNull
  @XmlElement(name = "FirstName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              firstName;

  @NotNull
  @XmlElement(name = "LastName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String              lastName;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             version;

  @NotNull
  @XmlElement(name = "Permission", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             permission;

  @XmlElementWrapper(name = "GroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Group")
  private final List<Long>    groups           = new ArrayList<>();

  @XmlElementWrapper(name = "DepartmentList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Department", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<Long>    departments      = new ArrayList<>();

  @XmlElementWrapper(name = "DepartmentGroupList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "DepartmentGroup", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<Long>    departmentGroups = new ArrayList<>();

  @XmlElementWrapper(name = "DeputyList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Deputy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<Long>    deputies         = new ArrayList<>();

  @XmlElementWrapper(name = "RoleList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Role", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<Integer> roles            = new ArrayList<>();

  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the companyIid
   */
  public Long getCompanyId() {
    return this.companyId;
  }

  /**
   * @param companyIid the companyIid to set
   */
  public void setCompanyId(final Long companyIid) {
    this.companyId = companyIid;
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

  public Date getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(final Date birthDate) {
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

  public List<Long> getGroups() {
    return this.groups;
  }

  public void setGroups(final List<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }

  public List<Long> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final List<Long> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final Long departmentId) {
    this.departments.add(departmentId);
  }

  public List<Long> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final List<Long> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final Long departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public List<Long> getDeputies() {
    return this.deputies;
  }

  public void setDeputies(final List<Long> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final Long deputyId) {
    this.deputies.add(deputyId);
  }

  public List<Integer> getRoles() {
    return this.roles;
  }

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
