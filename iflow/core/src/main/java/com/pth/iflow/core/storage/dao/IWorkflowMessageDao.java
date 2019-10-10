package com.pth.iflow.core.storage.dao;

import java.util.List;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageDao {

  public WorkflowMessage create(WorkflowMessage model) throws IFlowStorageException;

  public WorkflowMessage update(WorkflowMessage model) throws IFlowStorageException;

  public void updateStatusByWorkflow(Long workflowId, final Long stepId, EWorkflowMessageStatus status) throws IFlowStorageException;

  public void updateStatusByWorkflowAndUser(Long workflowId, final Long stepId, final Long userid, EWorkflowMessageStatus status) throws IFlowStorageException;

  public WorkflowMessage getById(Long id) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByUserId(final Long userId) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByWorkflowId(final Long workflowId) throws IFlowStorageException;

  void deleteWorkflowMessage(final Long messageId) throws IFlowStorageException;

}
