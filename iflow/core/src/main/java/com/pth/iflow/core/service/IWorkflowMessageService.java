package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageService {

  public WorkflowMessage save(WorkflowMessage model) throws IFlowStorageException;

  public void updateStatusByWorkflow(Long workflowId, Integer status) throws IFlowStorageException;

  public WorkflowMessage getById(Long id) throws IFlowStorageException;

  public List<WorkflowMessage> getListByUserId(final Long userId, Integer status) throws IFlowStorageException;

  public List<WorkflowMessage> getListByWorkflowId(final Long workflowId) throws IFlowStorageException;

  public void changeWorkflowMessageStatus(final Long workflowId, final EWorkflowMessageStatus status) throws IFlowStorageException;
}
