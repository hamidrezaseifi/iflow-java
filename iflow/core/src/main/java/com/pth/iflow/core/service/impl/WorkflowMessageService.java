package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
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
    prepareSavingModel(model);
    if (model.isNew()) {

      final WorkflowMessageEntity savedModel = this.workflowMessageDao.create(model);
      return savedModel;
    }

    final WorkflowMessageEntity exists = this.workflowMessageDao.findMessageForWorkflowAndStepAnUser(model.getWorkflowIdentity(),
        model.getStepIdentity(), model.getUserIdentity());
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
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowId(final String workflowIdentity)
      throws IFlowStorageException {

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

  protected WorkflowMessageEntity prepareSavingModel(final WorkflowMessageEntity model) {

    if (model.getCreatedBy() == null || model.getCreatedBy() <= 0) {
      model.setCreatedByUser(usersDao.getByIdentity(model.getCreatedByIdentity()));
      model.setCreatedBy(model.getCreatedByUser().getId());
    }

    if (model.getUserId() == null || model.getUserId() <= 0) {
      model.setUser(usersDao.getByIdentity(model.getUserIdentity()));
      model.setUserId(model.getUser().getId());
    }

    if (model.getStepId() == null || model.getStepId() <= 0) {
      model.setStep(workflowTypeStepDao.getByIdentity(model.getStepIdentity()));
      model.setStepId(model.getStep().getId());
    }

    if (model.getWorkflowId() == null || model.getWorkflowId() <= 0) {
      model.setWorkflow(workflowDao.getByIdentity(model.getWorkflowIdentity()));
      model.setWorkflowId(model.getWorkflow().getId());
    }

    return model;
  }

  @Override
  public WorkflowMessageEntity fromEdo(final WorkflowMessageEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final WorkflowMessageEntity model = new WorkflowMessageEntity();

    model.setStatus(edo.getStatus());
    model.getUser().setIdentity(edo.getUserIdentity());
    model.getCreatedByUser().setIdentity(edo.getCreatedByIdentity());
    model.setVersion(edo.getVersion());
    model.getWorkflow().setIdentity(edo.getWorkflowIdentity());
    model.setMessageType(edo.getMessageType());
    model.setExpireDays(edo.getExpireDays());
    model.setMessage(edo.getMessage());
    model.getStep().setIdentity(edo.getStepIdentity());

    return model;
  }

  @Override
  public WorkflowMessageEdo toEdo(final WorkflowMessageEntity model) {
    final WorkflowMessageEdo edo = new WorkflowMessageEdo();
    edo.setStatus(model.getStatus());
    edo.setUserIdentity(model.getUserIdentity());
    edo.setCreatedByIdentity(model.getCreatedByIdentity());
    edo.setVersion(model.getVersion());
    edo.setWorkflowIdentity(model.getWorkflowIdentity());
    edo.setMessageType(model.getMessageType());
    edo.setExpireDays(model.getExpireDays());
    edo.setMessage(model.getMessage());
    edo.setCreatedAt(CoreDataHelper.toLocalDateTime(model.getCreatedAt()));
    edo.setStepIdentity(model.getStepIdentity());

    return edo;
  }
}
