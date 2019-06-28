package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class Company extends ModelMapperBase<CompanyEdo, Company> {

  protected Long id;
  protected String identifyid;
  protected String companyName;
  protected Integer status;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;

  protected final Set<Long> groupIds = new HashSet<>();
  protected final Set<Long> departmentIds = new HashSet<>();
  protected final Set<Long> workflowTypeIds = new HashSet<>();
  protected final Set<Long> userIds = new HashSet<>();

  /**
   * @return the id
   */
  @Override
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
   * @return the identifyid
   */
  public String getIdentifyid() {
    return this.identifyid;
  }

  /**
   * @param identifyid the identifyid to set
   */
  public void setIdentifyid(final String identifyid) {
    this.identifyid = identifyid;
  }

  /**
   * @return the companyName
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
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

  public Set<Long> getGroupIds() {
    return this.groupIds;
  }

  public void setGroupIds(final Set<Long> groups) {
    this.groupIds.clear();
    if (groups != null) {
      this.groupIds.addAll(groups);
    }
  }

  public void setGroupIds(final List<Long> groups) {
    setGroupIds(groups.stream().collect(Collectors.toSet()));
  }

  public void addGroupId(final Long groupId) {
    this.groupIds.add(groupId);
  }

  public Set<Long> getDepartmentIds() {
    return this.departmentIds;
  }

  public void setDepartmentIds(final Set<Long> departments) {
    this.departmentIds.clear();
    if (departments != null) {
      this.departmentIds.addAll(departments);
    }
  }

  public void setDepartmentIds(final List<Long> departments) {
    setDepartmentIds(departments.stream().collect(Collectors.toSet()));

  }

  public void addDepartmentId(final Long departmentId) {
    this.departmentIds.add(departmentId);
  }

  public Set<Long> getWorkflowTypeIds() {
    return this.workflowTypeIds;
  }

  public void setWorkflowTypeIds(final Set<Long> idList) {
    this.workflowTypeIds.clear();
    if (idList != null) {
      this.workflowTypeIds.addAll(idList);
    }
  }

  public void setWorkflowTypeIds(final List<Long> idList) {
    setWorkflowTypeIds(idList.stream().collect(Collectors.toSet()));
  }

  public void addWorkflowTypeId(final Long departmentGroupId) {
    this.workflowTypeIds.add(departmentGroupId);
  }

  public Set<Long> getUserIds() {
    return this.userIds;
  }

  public void setUserIds(final Set<Long> idList) {
    this.userIds.clear();
    if (idList != null) {
      this.userIds.addAll(idList);
    }
  }

  public void setUserIds(final List<Long> idList) {
    setUserIds(idList.stream().collect(Collectors.toSet()));
  }

  public void addUserId(final Long departmentGroupId) {
    this.userIds.add(departmentGroupId);
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
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the updatedAt
   */
  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(this.companyName);
    edo.setIdentifyid(this.identifyid);
    edo.setStatus(this.status);
    edo.setId(this.id);

    return edo;
  }

  @Override
  public Company fromEdo(final CompanyEdo edo) {
    final Company company = new Company();
    company.setCompanyName(edo.getCompanyName());
    company.setIdentifyid(edo.getIdentifyid());
    company.setStatus(edo.getStatus());
    company.setId(edo.getId());

    return company;
  }

  @Override
  public void fromExists(final Company exist) {
    setCompanyName(exist.getCompanyName());
    setIdentifyid(exist.getIdentifyid());
    setStatus(exist.getStatus());
    setId(exist.getId());
    setGroupIds(exist.getGroupIds());
    setDepartmentIds(exist.getDepartmentIds());
    setWorkflowTypeIds(exist.getWorkflowTypeIds());
    setUserIds(exist.getUserIds());

    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());
  }

}
