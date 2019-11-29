package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class WorkflowService implements IWorkflowService {

  private final IWorkflowDao         workflowDao;
  private final IWorkflowTypeDao     workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;
  private final IUserDao             usersDao;

  public WorkflowService(@Autowired final IWorkflowDao workflowDao, @Autowired final IWorkflowTypeDao workflowTypeDao,
      @Autowired final IWorkflowTypeStepDao workflowTypeStepDao, @Autowired final IUserDao usersDao) {
    this.workflowDao = workflowDao;
    this.workflowTypeDao = workflowTypeDao;
    this.workflowTypeStepDao = workflowTypeStepDao;
    this.usersDao = usersDao;
  }

  @Override
  public WorkflowEntity save(final WorkflowEntity model) {

    prepareSavingModel(model);
    if (model.isNew()) {
      return workflowDao.create(model);
    }

    final WorkflowEntity exists = workflowDao.getById(model.getId());
    model.verifyVersion(exists);

    return workflowDao.update(model);

  }

  @Override
  public WorkflowEntity getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowEntity> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

  @Override
  public WorkflowEntity prepareSavingModel(final WorkflowEntity model) {
    model.setControllerId(usersDao.getByIdentity(model.getControllerIdentity()).getId());

    model.setCreatedById(usersDao.getByIdentity(model.getCreatedByIdentity()).getId());

    model.setCurrentStepId(workflowTypeStepDao.getByIdentity(model.getCurrentStepIdentity()).getId());

    model.setWorkflowTypeId(workflowTypeDao.getByIdentity(model.getWorkflowType().getIdentity()).getId());

    return model;
  }
}
