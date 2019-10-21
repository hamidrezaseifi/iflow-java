package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;
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
  public WorkflowType getByIdentity(final String identity) {
    return this.workflowTypeDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStep> getStepsByIdentity(final String identity) {
    final WorkflowType workflow = getByIdentity(identity);
    return workflow.getSteps();
  }

  @Override
  public List<WorkflowType> getListByIdCompanyId(final String identity) {
    return this.workflowTypeDao.getListByCompanyIdentity(identity);
  }

  @Override
  public List<WorkflowType> getListByIdentityList(final Collection<String> idList) {
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
