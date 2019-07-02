package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class UserGroup extends ModelMapperBase<UserGroupEdo, UserGroup> {
  
  private Long          id;
  private Long          companyId;
  private String        title;
  private Integer       status;
  private Integer       version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public Long getCompanyId() {
    return this.companyId;
  }
  
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  public Integer getStatus() {
    return this.status;
  }
  
  public void setStatus(final Integer status) {
    this.status = status;
  }
  
  public Integer getVersion() {
    return this.version;
  }
  
  public void setVersion(final Integer version) {
    this.version = version;
  }
  
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
  
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  
  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }
  
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
  
  @Override
  public UserGroupEdo toEdo() {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    
    return edo;
  }
  
  @Override
  public UserGroup fromEdo(final UserGroupEdo edo) {
    final UserGroup model = new UserGroup();
    
    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    
    return model;
  }
  
}
