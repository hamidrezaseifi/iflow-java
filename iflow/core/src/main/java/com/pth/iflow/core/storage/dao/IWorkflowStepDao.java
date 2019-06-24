package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowStepDao {
  
  public WorkflowTypeStep getById(Long id) throws IFlowStorageException;
  
  public List<WorkflowTypeStep> getListByIdList(List<Long> idList) throws IFlowStorageException;
  
  public List<WorkflowTypeStep> getListByWorkflowId(Long workflowId) throws IFlowStorageException;
  
}
