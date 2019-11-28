package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.workflow.sub.WorkflowType;
import com.pth.iflow.core.model.workflow.sub.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
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
  public List<WorkflowTypeStep> getListByIdentityList(final Collection<String> idList) {
    return this.workflowStepDao.getListByIdentityList(idList);
  }

}
