package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.enums.EUserStatus;

@JsonIgnoreProperties(value = { "authorities", "enabled", })
public class BackendUser extends ModelMapperBase<UserEdo, BackendUser> {

  private Long             id;
  private Long             companyId;
  private String           email;
  private Date             birthDate;
  private String           firstName;
  private String           lastName;
  private Integer          status;
  private Integer          version;
  private Integer          permission;
  private final List<Long> groupIds         = new ArrayList<>();
  private final List<Long> departments      = new ArrayList<>();
  private final List<Long> departmentGroups = new ArrayList<>();
  private final List<Long> deputies         = new ArrayList<>();

  private boolean isEnabled;

  public BackendUser() {

  }

  public String getFullName() {
    return this.lastName + ", " + this.firstName;
  }

  public boolean allowEdit() {
    return true;
  }

  public boolean isAdmin() {
    return true;
  }

  private String getRolesAuthoritiesNames(final List<BackendUserGroup> allUserGroups) {
    final List<BackendUserGroup> userGroups = new ArrayList<>();
    userGroups.addAll(allUserGroups.stream().filter(g -> this.groupIds.contains(g.getId())).collect(Collectors.toList()));
    String name = "";
    for (final BackendUserGroup group : userGroups) {
      name += (name.isEmpty() ? "" : ", ") + group.getTitle().toUpperCase();
    }
    return name;
  }

  public boolean isEnabled() {
    return this.isEnabled;
  }

  @JsonSetter("isEnabled")
  public void setEnabled(final boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public String getUserTitle() {
    return this.lastName + ", " + this.firstName;
  }

  public List<GrantedAuthority> getAuthorities(final List<BackendUserGroup> allUserGroups) {
    final List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList(this.getRolesAuthoritiesNames(allUserGroups));
    return list;
  }

  /**
   * @return the id
   */
  @Override
  public Long getId() {
    return this.id;
  }

  public boolean hasId(final Long id) {
    return this.id == id;
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
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getEmail() {
    return this.email;
  }

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

  public boolean isActive() {
    return this.status == EUserStatus.ACTIVE.getValue().intValue();
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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
    return this.groupIds;
  }

  public void setGroups(final List<Long> groups) {
    this.groupIds.clear();
    if (groups != null) {
      this.groupIds.addAll(groups);
    }
  }

  public void addGroup(final Long groupId) {
    this.groupIds.add(groupId);
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

  @Override
  public boolean isNew() {
    return (this.id == null) || (this.id <= 0);
  }

  @Override
  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(this.firstName);
    edo.setLastName(this.lastName);
    edo.setPermission(this.permission);
    edo.setStatus(this.status);
    edo.setVersion(this.version);
    edo.setEmail(this.email);
    edo.setBirthDate(this.birthDate);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setGroups(this.groupIds);
    edo.setDepartments(this.departments);
    edo.setDepartmentGroups(this.departmentGroups);
    edo.setDeputies(this.deputies);

    return edo;
  }

  @Override
  public BackendUser fromEdo(final UserEdo edo) {
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

    return model;
  }

}
