package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.service.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

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
  public WorkflowTypeStep getByIdentity(final String identity) {

    return this.workflowStepDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowTypeIdentity(final String workflowTypeIdentity) {

    final WorkflowType type = workflowTypeDao.getByIdentity(workflowTypeIdentity);
    return type.getSteps();
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
  public List<WorkflowTypeStep> getListByIdentityList(final Set<String> idList) {
    return this.workflowStepDao.getListByIdentityList(idList);
  }

}
