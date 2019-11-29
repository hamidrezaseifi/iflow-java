package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@Service
public class WorkflowTypeStepService implements IWorkflowTypeStepService {

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

    final WorkflowTypeStepEntity exists = workflowStepDao.getById(model.getId());
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
}
