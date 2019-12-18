package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.WorkflowMessageEdo;
import com.pth.iflow.common.models.helper.IdentityModel;
import com.pth.iflow.core.helper.CoreDataHelper;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IWorkflowMessageService;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class WorkflowMessageService extends CoreModelEdoMapperService<WorkflowMessageEntity, WorkflowMessageEdo>
    implements IWorkflowMessageService {

  private final IWorkflowMessageDao  workflowMessageDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;
  private final IUserDao             usersDao;
  private final IWorkflowDao         workflowDao;

  public WorkflowMessageService(@Autowired final IWorkflowMessageDao workflowMessageDao,
      @Autowired final IWorkflowTypeStepDao workflowTypeStepDao, @Autowired final IUserDao usersDao,
      @Autowired final IWorkflowDao workflowDao) {
    this.workflowMessageDao = workflowMessageDao;
    this.workflowTypeStepDao = workflowTypeStepDao;
    this.usersDao = usersDao;
    this.workflowDao = workflowDao;
  }

  @Override
  public WorkflowMessageEntity save(final WorkflowMessageEntity model) throws IFlowStorageException {

    if (model.isNew()) {

      final WorkflowMessageEntity savedModel = this.workflowMessageDao.create(model);
      return savedModel;
    }

    final WorkflowMessageEntity exists = this.workflowMessageDao.getById(model.getId());
    model.verifyVersion(exists);

    final WorkflowMessageEntity savedModel = this.workflowMessageDao.update(model);
    return savedModel;
  }

  @Override
  public void updateStatusByWorkflow(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status)
      throws IFlowStorageException {

    this.workflowMessageDao.updateStatusByWorkflowIdentity(workflowIdentity, stepIdentity, status);
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserEmail(final String email) throws IFlowStorageException {

    return this.workflowMessageDao.getNotClosedNotExpiredListByUserIdentity(email);
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowId(final String workflowIdentity) throws IFlowStorageException {

    return this.workflowMessageDao.getNotClosedNotExpiredListByWorkflowIdentity(workflowIdentity);
  }

  @Override
  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String email,
      final EWorkflowMessageStatus status) throws IFlowStorageException {

    if (IdentityModel.isIdentityNew(email)) {
      this.workflowMessageDao.updateStatusByWorkflowIdentity(workflowIdentity, stepIdentity, status);
    } else {
      this.workflowMessageDao.updateStatusByWorkflowAndUser(workflowIdentity, stepIdentity, email, status);
    }
  }

  @Override
  public WorkflowMessageEntity fromEdo(final WorkflowMessageEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowMessageEntity model = new WorkflowMessageEntity();

    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setMessageType(edo.getMessageType());
    model.setExpireDays(edo.getExpireDays());
    model.setMessage(edo.getMessage());
    model.setUserId(usersDao.getByIdentity(edo.getUserIdentity()).getId());
    model.setCreatedById(usersDao.getByIdentity(edo.getCreatedByIdentity()).getId());
    model.setWorkflowId(workflowDao.getByIdentity(edo.getWorkflowIdentity()).getId());
    model.setStepId(workflowTypeStepDao.getByIdentity(edo.getStepIdentity()).getId());

    return model;
  }

  @Override
  public WorkflowMessageEdo toEdo(final WorkflowMessageEntity model) {
    final WorkflowMessageEdo edo = new WorkflowMessageEdo();
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setMessageType(model.getMessageType());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(CoreDataHelper.toLocalDateTime(model.getCreatedAt()));
    edo.setUserIdentity(usersDao.getById(model.getUserId()).getIdentity());
    edo.setCreatedByIdentity(usersDao.getById(model.getCreatedById()).getIdentity());
    edo.setWorkflowIdentity(workflowDao.getById(model.getWorkflowId()).getIdentity());
    edo.setStepIdentity(workflowTypeStepDao.getById(model.getStepId()).getIdentity());

    return edo;
  }
}
