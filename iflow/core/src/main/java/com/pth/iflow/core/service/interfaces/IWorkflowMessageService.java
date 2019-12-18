package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.models.WorkflowMessageEdo;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowMessageService extends ICoreModelEdoMapperService<WorkflowMessageEntity, WorkflowMessageEdo> {

  public WorkflowMessageEntity save(WorkflowMessageEntity model) throws IFlowStorageException;

  public void updateStatusByWorkflow(String workflowIdentity, String stepIdentity, EWorkflowMessageStatus status)
      throws IFlowStorageException;

  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserEmail(final String email) throws IFlowStorageException;

  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowId(final String workflowIdentity)
      throws IFlowStorageException;

  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String email,
      final EWorkflowMessageStatus status) throws IFlowStorageException;
}
