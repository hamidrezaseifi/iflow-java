package com.pth.iflow.core.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class WorkflowTypeService implements IWorkflowTypeService {

  private final IWorkflowTypeDao workflowTypeDao;

  public WorkflowTypeService(@Autowired final IWorkflowTypeDao workflowDao) {
    this.workflowTypeDao = workflowDao;
  }

  @Override
  public WorkflowType getById(final Long id) {
    return this.workflowTypeDao.getById(id);
  }

  @Override
  public Set<WorkflowTypeStep> getStepsById(final Long id) {
    final WorkflowType workflow = getById(id);
    return workflow.getSteps();
  }

  @Override
  public Set<WorkflowType> getListByIdCompanyId(final Long id) {
    return this.workflowTypeDao.getListByCompanyId(id);
  }

  @Override
  public Set<WorkflowType> getListByIdList(final Set<Long> idList) {
    return this.workflowTypeDao.getListByIdList(idList);
  }

  @Override
  public Set<WorkflowType> getListByIdentityList(final Set<String> idList) {
    return this.workflowTypeDao.getListByIdentityList(idList);
  }

  @Override
  public WorkflowType save(final WorkflowType model) {
    if (model.isNew()) {
      model.increaseVersion();
      return workflowTypeDao.create(model);
    }

    final WorkflowType exists = workflowTypeDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("WorkflowType with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return workflowTypeDao.update(model);
  }

}
