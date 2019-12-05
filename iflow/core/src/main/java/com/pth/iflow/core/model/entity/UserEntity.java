package com.pth.iflow.core.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EUserStatus;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "users")
@EntityListeners(EntityListener.class)
public class UserEntity extends EntityIdentityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                           id;

  @Column(name = "email")
  private String                         email;

  @Column(name = "company_id")
  private Long                           companyId;

  @Column(name = "birthdate")
  private Date                           birthDate;

  @Column(name = "firstname")
  private String                         firstName;

  @Column(name = "lastname")
  private String                         lastName;

  @Column(name = "status")
  private Integer                        status;

  @Column(name = "permission")
  private Integer                        permission;

  @Column(name = "version")
  private Integer                        version;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                           createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                           updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private CompanyEntity                  company;

  // @ManyToMany(cascade = CascadeType.ALL)
  // @JoinTable(
  // name = "user_usergroup", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "user_group") }
  // )
  // @Fetch(value = FetchMode.SUBSELECT)
  // List<UserGroupEntity> groups = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_deputy", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "deputy_id") })
  @Fetch(value = FetchMode.SUBSELECT)
  List<UserEntity>                       deputies         = new ArrayList<>();

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_departments", joinColumns = { @JoinColumn(name = "user_id"
  ) }, inverseJoinColumns = { @JoinColumn(name = "department_id") })
      @Fetch(value = FetchMode.SUBSELECT)
  List<DepartmentEntity>                 departments      = new ArrayList<>();

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_department_groups", joinColumns = { @JoinColumn(name = "user_id"
  ) }, inverseJoinColumns = { @JoinColumn(name = "department_group_id") })
      @Fetch(value = FetchMode.SUBSELECT)
  List<DepartmentGroupEntity>            departmentGroups = new ArrayList<>();

  // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
  // @Fetch(value = FetchMode.SUBSELECT)
  // private final List<UserRoleEntity> roles = new ArrayList<>();

  // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
  // @Fetch(value = FetchMode.SUBSELECT)
  // private final List<UserDeputyEntity> deputies = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEntity")
  // @Fetch(value = FetchMode.SUBSELECT)
  private final Set<UserUserGroupEntity> groups           = new HashSet<>();

  // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
  // @Fetch(value = FetchMode.SUBSELECT)
  // private final List<UserDepartmentEntity> departments = new ArrayList<>();

  // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
  // @Fetch(value = FetchMode.SUBSELECT)
  // private final List<UserDepartmentGroupEntity> departmentGroups = new ArrayList<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
  @Fetch(value = FetchMode.SUBSELECT)
  private final List<UserRoleEntity>     roles            = new ArrayList<>();

  public UserEntity() {

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

  /**
   * @return the permission
   */
  public Integer getPermission() {
    return this.permission;
  }

  /**
   * @return the version
   */

  @Override
  public Integer getVersion() {
    return this.version;
  }

  /**
   * @param version the version to set
   */

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  /**
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return this.createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @param permission the permission to set
   */
  public void setPermission(final Integer permission) {
    this.permission = permission;
  }

  public Set<UserUserGroupEntity> getGroups() {
    return groups;
  }

  public List<DepartmentEntity> getDepartments() {
    return departments;
  }

  public List<DepartmentGroupEntity> getDepartmentGroups() {
    return departmentGroups;
  }

  public CompanyEntity getCompany() {
    return company;
  }

  public void setCompany(final CompanyEntity company) {
    this.company = company;
  }

  public List<UserRoleEntity> getRoles() {
    return roles;
  }

  public List<UserEntity> getDeputies() {
    return deputies;
  }

  @Override
  public String getIdentity() {
    return email;
  }

  @Override
  public String getIdentityPreffix() {
    return "u";
  }

  @Override
  public void setIdentity(final String identity) {
    this.email = identity;
  }

  public void setRoles(final List<UserRoleEntity> roles) {
    this.roles.clear();
    for (final UserRoleEntity entity : roles) {
      entity.setUserEntity(this);

      this.roles.add(entity);
    }

  }

  public void setRolesFromIntegerList(final List<Integer> roles) {
    this.roles.clear();
    for (final Integer role : roles) {
      final UserRoleEntity entity = new UserRoleEntity();

      entity.setUserEntity(this);
      entity.setRole(role);

      this.roles.add(entity);
    }
  }

  /*
   * public void setDeputies(final List<UserDeputyEntity> deputies) { this.deputies.clear(); for (final UserDeputyEntity entity : deputies) {
   * entity.setUserEntity(this);
   *
   * this.deputies.add(entity); }
   *
   * }
   */

  public void setDeputies(final List<UserEntity> deputies) {
    this.deputies.clear();
    for (final UserEntity model : deputies) {

      // final UserDeputyEntity entity = new UserDeputyEntity();
      // deputies.setUserEntity(this);
      // deputies.setDeputyId(model.getId());

      this.deputies.add(model);
    }
  }

  /*
   * public void setGroups(final List<UserUserGroupEntity> groups) { this.groups.clear(); for (final UserUserGroupEntity entity : groups) {
   * entity.setUserEntity(this);
   *
   * this.groups.add(entity); }
   *
   * }
   */

  public void setGroups(final List<UserGroupEntity> groups) {
    this.groups.clear();
    for (final UserGroupEntity model : groups) {

      final UserUserGroupEntity entity = new UserUserGroupEntity();
      entity.setUserEntity(this);
      entity.setUserGroup(model);

      this.groups.add(entity);

      // this.groups.add(model);
      // model.getUsers().add(this);
    }
  }

  /*
   * public void setDepartments(final List<UserDepartmentEntity> departments) { this.departments.clear(); for (final UserDepartmentEntity
   * entity : departments) { entity.setUserEntity(this);
   *
   * this.departments.add(entity); } }
   */

  public void setDepartments(final List<DepartmentEntity> departments) {
    this.departments.clear();
    for (final DepartmentEntity model : departments) {
      // final UserDepartmentEntity entity = new UserDepartmentEntity();
      // entity.setUserEntity(this);
      // entity.setDepartmentId(model.getId());

      this.departments.add(model);
    }
  }

  /*
   * public void setDepartmentGroups(final List<UserDepartmentGroupEntity> departmentGroups) { this.departmentGroups.clear(); for (final
   * UserDepartmentGroupEntity entity : departmentGroups) { entity.setUserEntity(this);
   *
   * this.departmentGroups.add(entity); } }
   */

  public void setDepartmentGroups(final List<DepartmentGroupEntity> departmentGroups) {
    this.departmentGroups.clear();
    for (final DepartmentGroupEntity model : departmentGroups) {
      // final UserDepartmentGroupEntity entity = new UserDepartmentGroupEntity();
      // entity.setUserEntity(this);
      // entity.setDepartmentGroupId(model.getId());

      this.departmentGroups.add(model);
    }
  }

  @Override
  public void increaseVersion() {
    version += 1;
  }

  public void updateFromExists(final UserEntity exists) {
    if (exists == null) {
      return;
    }
    this.birthDate = exists.birthDate;
    this.companyId = exists.companyId;
    this.email = exists.email;
    this.firstName = exists.firstName;
    this.lastName = exists.lastName;
    this.status = exists.status;
    this.version = exists.version;
    this.permission = exists.permission;

    this.departmentGroups.clear();
    this.departments.clear();
    this.deputies.clear();
    this.groups.clear();
    this.roles.clear();

    this.departmentGroups.addAll(exists.departmentGroups);
    this.departments.addAll(exists.departments);
    this.deputies.addAll(exists.deputies);
    this.groups.addAll(exists.groups);
    this.roles.addAll(exists.roles);

  }

}
