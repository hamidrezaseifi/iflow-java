package com.pth.iflow.core.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.service.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class WorkflowTypeStepService implements IWorkflowTypeStepService {

  private final IWorkflowTypeStepDao workflowStepDao;

  public WorkflowTypeStepService(@Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.workflowStepDao = workflowStepDao;
  }

  @Override
  public WorkflowTypeStep getById(final Long id) {

    return this.workflowStepDao.getById(id);
  }

  @Override
  public Set<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId) {

    return this.workflowStepDao.getListByWorkflowTypeId(workflowId);
  }

  @Override
  public Set<WorkflowTypeStep> getListByIdList(final Set<Long> idList) {

    return this.workflowStepDao.getListByIdList(idList);
  }

  @Override
  public CoreModelHelper save(final WorkflowTypeStep model) {
    if (model.isNew()) {
      model.increaseVersion();
      return workflowStepDao.create(model, true);
    }

    final WorkflowTypeStep exists = workflowStepDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("WorkflowTypeStep with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return workflowStepDao.update(model);
  }

  @Override
  public Set<WorkflowTypeStep> getListByIdentityList(final Set<String> idList) {
    return this.workflowStepDao.getListByIdentityList(idList);
  }

}
