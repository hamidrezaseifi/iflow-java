package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
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

    model.setControllerUser(usersDao.getByIdentity(model.getControllerIdentity()));
    model.setControllerId(model.getControllerUser().getId());

    model.setCreatedByUser(usersDao.getByIdentity(model.getCreatedByIdentity()));
    model.setCreatedById(model.getCreatedByUser().getId());

    model.setCurrentStep(workflowTypeStepDao.getByIdentity(model.getCurrentStepIdentity()));
    model.setCurrentStepId(model.getCurrentStep().getId());

    model.setWorkflowType(workflowTypeDao.getByIdentity(model.getWorkflowType().getIdentity()));
    model.setWorkflowTypeId(model.getWorkflowType().getId());

    for (final WorkflowActionEntity action : model.getActions()) {

      action.setAssignToUser(usersDao.getByIdentity(action.getAssignToIdentity()));
      action.setAssignTo(action.getAssignToUser() == null ? 0 : action.getAssignToUser().getId());
      action.setCurrentStep(workflowTypeStepDao.getByIdentity(action.getCurrentStepIdentity()));
      action.setCurrentStepId(action.getCurrentStep().getId());

    }

    for (final WorkflowFileEntity file : model.getFiles()) {

      file.setCreatedByUser(usersDao.getByIdentity(file.getCreatedByUser().getIdentity()));
      file.setCreatedById(file.getCreatedByUser().getId());

      for (final WorkflowFileVersionEntity fileVersion : file.getFileVersions()) {

        fileVersion.setCreatedByUser(usersDao.getByIdentity(fileVersion.getCreatedByUser().getIdentity()));
        fileVersion.setCreatedById(fileVersion.getCreatedByUser().getId());

      }

    }

    return model;
  }
}
