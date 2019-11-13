package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.workflow.sub.WorkflowMessage;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageDao {

  public WorkflowMessage create(WorkflowMessage model) throws IFlowStorageException;

  public WorkflowMessage update(WorkflowMessage model) throws IFlowStorageException;

  public void updateStatusByWorkflowIdentity(String workflowIdentity, final String stepIdentity, EWorkflowMessageStatus status)
      throws IFlowStorageException;

  public void updateStatusByWorkflowAndUser(String workflowIdentity, final String stepIdentity, final String email,
      EWorkflowMessageStatus status) throws IFlowStorageException;

  public WorkflowMessage getById(Long id) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByUserEmail(final String email) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByWorkflowIdentity(final String workflowIdentity)
      throws IFlowStorageException;

  void deleteWorkflowMessage(final Long messageId) throws IFlowStorageException;

}
