package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageService {

  public WorkflowMessage save(WorkflowMessage model) throws IFlowStorageException;

  public void updateStatusByWorkflow(String workflowIdentity, String stepIdentity, EWorkflowMessageStatus status)
      throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByUserEmail(final String email) throws IFlowStorageException;

  public List<WorkflowMessage> getNotClosedNotExpiredListByWorkflowId(final String workflowIdentity) throws IFlowStorageException;

  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String email,
      final EWorkflowMessageStatus status) throws IFlowStorageException;
}
