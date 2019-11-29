package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowMessageService;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;

@Service
public class WorkflowMessageService implements IWorkflowMessageService {

  private final IWorkflowMessageDao workflowMessageDao;

  public WorkflowMessageService(@Autowired final IWorkflowMessageDao workflowMessageDao) {
    this.workflowMessageDao = workflowMessageDao;
  }

  @Override
  public WorkflowMessageEntity save(final WorkflowMessageEntity model) throws IFlowStorageException {
    if (model.isNew()) {

      return this.workflowMessageDao.create(model);
    }

    final WorkflowMessageEntity exists = this.workflowMessageDao.getById(model.getId());
    model.verifyVersion(exists);

    return this.workflowMessageDao.update(model);
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

}
