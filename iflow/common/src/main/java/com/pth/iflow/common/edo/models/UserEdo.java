package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserEdo {

  @XmlElement(name = "ID")
  private Long            id;

  @NotNull
  @XmlElement(name = "CompanyId")
  private Long            companyId;

  @NotNull
  @XmlElement(name = "Email")
  private String          email;

  @NotNull
  @XmlElement(name = "FirstName")
  private String          firstName;

  @NotNull
  @XmlElement(name = "LastName")
  private String          lastName;

  @NotNull
  @XmlElement(name = "Status")
  private Integer         status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer         version;

  @NotNull
  @XmlElement(name = "Permission")
  private Integer         permission;

  @XmlElementWrapper(name = "GroupList")
  @XmlElement(name = "Group")
  private final Set<Long> groups           = new HashSet<>();

  @XmlElementWrapper(name = "DepartmentList")
  @XmlElement(name = "Department")
  private final Set<Long> departments      = new HashSet<>();

  @XmlElementWrapper(name = "DepartmentGroupList")
  @XmlElement(name = "DepartmentGroup")
  private final Set<Long> departmentGroups = new HashSet<>();

  @XmlElementWrapper(name = "DeputyList")
  @XmlElement(name = "Deputy")
  private final Set<Long> deputies         = new HashSet<>();

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

  public Set<Long> getGroups() {
    return this.groups;
  }

  public void setGroups(final Set<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }

  public Set<Long> getDepartments() {
    return this.departments;
  }

  public void setDepartments(final Set<Long> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public void addDepartment(final Long departmentId) {
    this.departments.add(departmentId);
  }

  public Set<Long> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final Set<Long> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public void addDepartmentGroup(final Long departmentGroupId) {
    this.departmentGroups.add(departmentGroupId);
  }

  public Set<Long> getDeputies() {
    return this.deputies;
  }

  public void setDeputies(final Set<Long> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  public void addDeputy(final Long deputyId) {
    this.deputies.add(deputyId);
  }

}
