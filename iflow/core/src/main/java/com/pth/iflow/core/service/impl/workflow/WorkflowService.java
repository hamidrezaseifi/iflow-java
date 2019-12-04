package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.WorkflowEdo;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowFileVersionEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class WorkflowService extends CoreModelEdoMapperService<WorkflowEntity, WorkflowEdo> implements IWorkflowService {

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

    if (EIdentity.isNotSet(model.getIdentity()) == false) {
      final WorkflowEntity exists = workflowDao.getByIdentity(model.getIdentity());
      model.setId(exists.getId());
    }

    model.setControllerId(usersDao.getByIdentity(model.getControllerIdentity()).getId());

    model.setCreatedById(usersDao.getByIdentity(model.getCreatedByIdentity()).getId());

    model.setCurrentStepId(workflowTypeStepDao.getByIdentity(model.getCurrentStepIdentity()).getId());

    model.setWorkflowTypeId(workflowTypeDao.getByIdentity(model.getWorkflowTypeIdentity()).getId());

    for (final WorkflowActionEntity action : model.getActions()) {

      if (EIdentity.isNotSet(action.getAssignToIdentity()) == false) {
        action.setAssignToId(usersDao.getByIdentity(action.getAssignToIdentity()).getId());
      }

      if (EIdentity.isNotSet(action.getCurrentStepIdentity()) == false) {
        action.setCurrentStepId(workflowTypeStepDao.getByIdentity(action.getCurrentStepIdentity()).getId());
      }

    }

    for (final WorkflowFileEntity file : model.getFiles()) {

      if (EIdentity.isNotSet(file.getCreatedByIdentity()) == false) {
        file.setCreatedByUserId(usersDao.getByIdentity(file.getCreatedByIdentity()).getId());
      }

      for (final WorkflowFileVersionEntity fileVersion : file.getFileVersions()) {

        if (EIdentity.isNotSet(fileVersion.getCreatedByIdentity()) == false) {
          fileVersion.setCreatedByUserId(usersDao.getByIdentity(fileVersion.getCreatedByIdentity()).getId());
        }

      }

    }

    return model;
  }

  @Override
  public WorkflowEntity fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowEntity model = new WorkflowEntity();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setControllerIdentity(edo.getControllerIdentity());
    model.setCurrentStepIdentity(edo.getCurrentStepIdentity());
    model.setCreatedByIdentity(edo.getCreatedByIdentity());
    model.setWorkflowTypeIdentity(edo.getWorkflowTypeIdentity());
    model.setIdentity(edo.getIdentity());

    model.setFiles(fromWorkflowFileEdoList(edo.getFiles()));
    model.setActions(fromWorkflowActionEdoList(edo.getActions()));

    return model;
  }

  @Override
  public WorkflowEdo toEdo(final WorkflowEntity model) {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setComments(model.getComments());
    edo.setStatus(model.getStatus());
    edo.setControllerIdentity(model.getControllerIdentity());
    edo.setCurrentStepIdentity(model.getCurrentStepIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setWorkflowTypeIdentity(model.getWorkflowTypeIdentity());

    edo.setFiles(toWorkflowFileEdoList(model.getFiles()));
    edo.setActions(toWorkflowActionEdoList(model.getActions()));

    return edo;
  }
}
