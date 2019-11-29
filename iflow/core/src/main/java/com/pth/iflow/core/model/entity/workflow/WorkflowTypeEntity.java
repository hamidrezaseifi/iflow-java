package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_type")
@EntityListeners(EntityListener.class)
public class WorkflowTypeEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                               id;

  @Column(name = "identity")
  private String                             identity;

  @Column(name = "company_id")
  private Long                               companyId;

  @Column(name = "workflow_base_type")
  private String                             baseTypeIdentity;

  @Column(name = "title")
  private String                             title;

  @Column(name = "commecnts")
  private String                             comments;

  @Column(name = "status")
  private Integer                            status;

  @Column(name = "send_to_controller")
  private Boolean                            sendToController;

  @Column(name = "assign_type")
  private EWorkflowTypeAssignType            assignType;

  @Column(name = "increase_step_automatic")
  private Boolean                            increaseStepAutomatic;

  @Column(name = "allow_assign")
  private Boolean                            allowAssign;

  @Column(name = "version")
  private Integer                            version;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                               createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                               updatedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "workflow_type_id")
  private final List<WorkflowTypeStepEntity> steps = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private CompanyEntity                      company;

  public WorkflowTypeEntity() {
    company = new CompanyEntity();
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getBaseTypeIdentity() {
    return baseTypeIdentity;
  }

  public void setBaseTypeIdentity(final String baseTypeIdentity) {
    this.baseTypeIdentity = baseTypeIdentity;
  }

  public EWorkflowTypeAssignType getAssignType() {
    return assignType;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Boolean getSendToController() {
    return this.sendToController;
  }

  public void setSendToController(final Boolean sendToController) {
    this.sendToController = sendToController;
  }

  public EWorkflowTypeAssignType geAssignType() {
    return this.assignType;
  }

  public void setAssignType(final EWorkflowTypeAssignType assignType) {
    this.assignType = assignType;
  }

  public Boolean getIncreaseStepAutomatic() {
    return this.increaseStepAutomatic;
  }

  public void setIncreaseStepAutomatic(final Boolean increaseStepAutomatic) {
    this.increaseStepAutomatic = increaseStepAutomatic;
  }

  public Boolean getAllowAssign() {
    return this.allowAssign;
  }

  public void setAllowAssign(final Boolean allowAssign) {
    this.allowAssign = allowAssign;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<WorkflowTypeStepEntity> getSteps() {
    return this.steps;
  }

  public void setSteps(final List<WorkflowTypeStepEntity> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final WorkflowTypeStepEntity stepId) {
    this.steps.add(stepId);
  }

  @Override
  public String getIdentityPreffix() {
    return "wtp";
  }

  public CompanyEntity getCompany() {
    return company;
  }

  public void setCompany(final CompanyEntity company) {
    this.company = company;
  }

}
