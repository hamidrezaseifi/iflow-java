package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.service.IWorkflowMessageService;
import com.pth.iflow.core.storage.dao.IWorkflowMessageDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Service
public class WorkflowMessageService implements IWorkflowMessageService {

  private final IWorkflowMessageDao workflowMessageDao;

  public WorkflowMessageService(@Autowired final IWorkflowMessageDao workflowMessageDao) {
    this.workflowMessageDao = workflowMessageDao;
  }

  @Override
  public WorkflowMessage save(final WorkflowMessage model) throws IFlowStorageException {
    if (model.isNew()) {
      model.increaseVersion();
      return this.workflowMessageDao.create(model);
    }

    final WorkflowMessage exists = this.workflowMessageDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Workflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowMessageDao.update(model);
  }

  @Override
  public void updateStatusByWorkflow(final Long workflowId, final Integer status) throws IFlowStorageException {
    this.workflowMessageDao.updateStatusByWorkflow(workflowId, status);
  }

  @Override
  public WorkflowMessage getById(final Long id) throws IFlowStorageException {
    return this.workflowMessageDao.getById(id);
  }

  @Override
  public List<WorkflowMessage> getListByUserId(final Long userId, final Integer status) throws IFlowStorageException {

    return this.workflowMessageDao.getNotExpiredListByUserId(userId, status);
  }

  @Override
  public List<WorkflowMessage> getListByWorkflowId(final Long workflowId, final Long lastid, final Integer status)
      throws IFlowStorageException {

    return this.workflowMessageDao.getListByWorkflowId(workflowId, lastid, status);
  }

  @Override
  public void changeWorkflowMessageStatus(final Long workflowId, final EWorkflowMessageStatus status) throws IFlowStorageException {
    this.workflowMessageDao.updateStatusByWorkflow(workflowId, status.getValue());
  }

}
