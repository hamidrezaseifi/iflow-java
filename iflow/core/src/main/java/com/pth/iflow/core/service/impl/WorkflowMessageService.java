package com.pth.iflow.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.workflow.sub.WorkflowMessage;
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
  public void updateStatusByWorkflow(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status) throws IFlowStorageException {
    this.workflowMessageDao.updateStatusByWorkflowIdentity(workflowIdentity, stepIdentity, status);
  }

  @Override
  public List<WorkflowMessage> getNotClosedNotExpiredListByUserEmail(final String email) throws IFlowStorageException {

    return this.workflowMessageDao.getNotClosedNotExpiredListByUserEmail(email);
  }

  @Override
  public List<WorkflowMessage> getNotClosedNotExpiredListByWorkflowId(final String workflowIdentity) throws IFlowStorageException {

    return this.workflowMessageDao.getNotClosedNotExpiredListByWorkflowIdentity(workflowIdentity);
  }

  @Override
  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String email, final EWorkflowMessageStatus status) throws IFlowStorageException {

    if (IdentityModel.isIdentityNew(email)) {
      this.workflowMessageDao.updateStatusByWorkflowIdentity(workflowIdentity, stepIdentity, status);
    }
    else {
      this.workflowMessageDao.updateStatusByWorkflowAndUser(workflowIdentity, stepIdentity, email, status);
    }
  }

}
