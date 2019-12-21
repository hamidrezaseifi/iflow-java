package com.pth.iflow.core.storage.dao.interfaces;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageDao {

  public WorkflowMessageEntity getById(Long id) throws IFlowStorageException;

  public WorkflowMessageEntity create(WorkflowMessageEntity model) throws IFlowStorageException;

  public WorkflowMessageEntity update(WorkflowMessageEntity model) throws IFlowStorageException;

  public List<WorkflowMessageEntity> findMessageListForWorkflowAndStep(String workflowIdentity, String stepIdentity);

  public WorkflowMessageEntity findMessageForWorkflowAndStepAnUser(String workflowIdentity, String stepIdentity, String userIdentity);

  void deleteById(final Long messageId) throws IFlowStorageException;

  public void updateStatusByWorkflowIdentity(String workflowIdentity, final String stepIdentity, EWorkflowMessageStatus status)
      throws IFlowStorageException;

  public void updateStatusByWorkflowAndUser(String workflowIdentity, final String stepIdentity, final String userIdentity,
      EWorkflowMessageStatus status) throws IFlowStorageException;

  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserIdentity(final String userIdentity) throws IFlowStorageException;

  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowIdentity(final String workflowIdentity) throws IFlowStorageException;

}
