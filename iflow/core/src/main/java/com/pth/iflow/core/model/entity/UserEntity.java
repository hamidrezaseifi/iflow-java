package com.pth.iflow.core.model.entity;

import java.sql.Date;
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.pth.iflow.common.enums.EUserStatus;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "users")
@EntityListeners(EntityListener.class)
public class UserEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                                 id;

  @Column(name = "email")
  private String                               email;

  @Column(name = "company_id")
  private Long                                 companyId;

  @Column(name = "birthdate")
  private Date                                 birthDate;

  @Column(name = "firstname")
  private String                               firstName;

  @Column(name = "lastname")
  private String                               lastName;

  @Column(name = "status")
  private Integer                              status;

  @Column(name = "permission")
  private Integer                              permission;

  @Column(name = "version")
  private Integer                              version;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                                 createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                                 updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private CompanyEntity                        company;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private final Set<UserRoleEntity>            roles            = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private final Set<UserDeputyEntity>          deputies         = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private final Set<UserUserGroupEntity>       groups           = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private final Set<UserDepartmentEntity>      departments      = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private final Set<UserDepartmentGroupEntity> departmentGroups = new HashSet<>();

  public UserEntity() {
    company = new CompanyEntity();
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

  public Set<UserDepartmentEntity> getDepartments() {
    return departments;
  }

  public Set<UserDepartmentGroupEntity> getDepartmentGroups() {
    return departmentGroups;
  }

  public CompanyEntity getCompany() {
    return company;
  }

  public void setCompany(final CompanyEntity company) {
    this.company = company;
  }

  public Set<UserRoleEntity> getRoles() {
    return roles;
  }

  public Set<UserDeputyEntity> getDeputies() {
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

  public void fillGroupsFromIdentityList(final Set<String> identityList) {
    for (final String identity : identityList) {
      final UserUserGroupEntity entity = new UserUserGroupEntity();
      entity.setUserGroup(new UserGroupEntity());
      entity.getUserGroup().setIdentity(identity);
      entity.setUserId(id);
      this.groups.add(entity);
    }

  }

  public void fillDepartmentsFromIdentityList(final Set<String> identityList) {
    for (final String identity : identityList) {
      final UserDepartmentEntity entity = new UserDepartmentEntity();
      entity.setDepartment(new DepartmentEntity());
      entity.getDepartment().setIdentity(identity);
      entity.setUserId(id);
      this.departments.add(entity);
    }
  }

  public void fillDepartmentGroupsFromIdentityList(final Set<String> identityList) {
    for (final String identity : identityList) {
      final UserDepartmentGroupEntity entity = new UserDepartmentGroupEntity();
      entity.setDepartmentGroup(new DepartmentGroupEntity());
      entity.getDepartmentGroup().setIdentity(identity);
      entity.setUserId(id);
      this.departmentGroups.add(entity);
    }
  }

  public void fillDeputiesFromIdentityList(final Set<String> identityList) {
    for (final String identity : identityList) {
      final UserDeputyEntity entity = new UserDeputyEntity();
      entity.setDeputy(new UserEntity());
      entity.getDeputy().setIdentity(identity);
      entity.setUserId(id);
      this.deputies.add(entity);
    }
  }

  public void fillRolesFromRoleList(final Set<Integer> roleList) {
    for (final Integer role : roleList) {
      final UserRoleEntity entity = new UserRoleEntity();
      entity.setRole(role);
      entity.setUserId(id);
      this.roles.add(entity);
    }
  }

}
