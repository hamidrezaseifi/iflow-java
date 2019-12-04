package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@Service
public class WorkflowTypeStepService extends CoreModelEdoMapperService<WorkflowTypeStepEntity, WorkflowTypeStepEdo>
    implements IWorkflowTypeStepService {

  private final IWorkflowTypeStepDao workflowStepDao;
  private final IWorkflowTypeDao     workflowTypeDao;

  public WorkflowTypeStepService(@Autowired final IWorkflowTypeStepDao workflowStepDao,
      @Autowired final IWorkflowTypeDao workflowDao) {
    this.workflowStepDao = workflowStepDao;
    this.workflowTypeDao = workflowDao;
  }

  @Override
  public WorkflowTypeStepEntity getByIdentity(final String identity) {

    return this.workflowStepDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowTypeIdentity) {

    final WorkflowTypeEntity type = workflowTypeDao.getByIdentity(workflowTypeIdentity);
    return type.getSteps();
  }

  @Override
  public WorkflowTypeStepEntity save(final WorkflowTypeStepEntity model) {
    if (model.isNew()) {
      return workflowStepDao.create(model);
    }

    final WorkflowTypeStepEntity exists = workflowStepDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);

    return workflowStepDao.update(model);
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByIdentityList(final Collection<String> idList) {
    return this.workflowStepDao.getListByIdentityList(idList);
  }

  protected WorkflowTypeStepEntity prepareSavingModel(final WorkflowTypeStepEntity model) {

    return model;
  }

  @Override
  public WorkflowTypeStepEntity fromEdo(final WorkflowTypeStepEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowTypeStepEntity model = new WorkflowTypeStepEntity();

    model.setStepIndex(edo.getStepIndex());
    model.setViewName(edo.getViewName());
    model.setExpireDays(edo.getExpireDays());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());

    return model;
  }

  @Override
  public WorkflowTypeStepEdo toEdo(final WorkflowTypeStepEntity model) {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(model.getStepIndex());
    edo.setViewName(model.getViewName());
    edo.setExpireDays(model.getExpireDays());
    edo.setTitle(model.getTitle());
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }
}
