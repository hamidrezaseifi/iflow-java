package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageService {

  public WorkflowMessage save(WorkflowMessage model) throws IFlowStorageException;

  public void updateStatusByWorkflow(Long workflowId, Long stepId, EWorkflowMessageStatus status) throws IFlowStorageException;

  public WorkflowMessage getById(Long id) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByUserId(final Long userId) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByWorkflowId(final Long workflowId) throws IFlowStorageException;

  public void updateWorkflowMessageStatus(final Long workflowId, final Long stepId, final Long userid,
      final EWorkflowMessageStatus status) throws IFlowStorageException;
}
