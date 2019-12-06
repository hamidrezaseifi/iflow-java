package testspring.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                 id;

  @Column(name = "email")
  private String               email;

  @Column(name = "company_id")
  private Long                 companyId;

  @Column(name = "birthdate")
  private Date                 birthDate;

  @Column(name = "firstname")
  private String               firstName;

  @Column(name = "lastname")
  private String               lastName;

  @Column(name = "status")
  private Integer              status;

  @Column(name = "permission")
  private Integer              permission;

  @Column(name = "version")
  private Integer              version;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                 createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                 updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private CompanyEntity        company;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "user_usergroup", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "user_group") }
  )
  private Set<UserGroupEntity> groups;

  public UserEntity() {

  }

  /**
   * @return the id
   */

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

  /**
   * @return the permission
   */
  public Integer getPermission() {
    return this.permission;
  }

  /**
   * @return the version
   */

  public Integer getVersion() {
    return this.version;
  }

  /**
   * @param version the version to set
   */

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

  public CompanyEntity getCompany() {
    return this.company;
  }

  public void setCompany(final CompanyEntity company) {
    this.company = company;
  }

  public String getIdentity() {
    return this.email;
  }

  public String getIdentityPreffix() {
    return "u";
  }

  public void setIdentity(final String identity) {
    this.email = identity;
  }

  public void increaseVersion() {
    this.version += 1;
  }

  public Set<UserGroupEntity> getGroups() {
    return this.groups;
  }

  public void setGroups(final Set<UserGroupEntity> groups) {
    this.groups = groups;
  }

}
