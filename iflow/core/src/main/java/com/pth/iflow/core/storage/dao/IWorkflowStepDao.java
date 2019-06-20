package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.WorkflowStep;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowStepDao {
  
  public WorkflowStep getById(Long id) throws IFlowStorageException;
  
  public List<WorkflowStep> getListByIdList(List<Long> idList) throws IFlowStorageException;
  
  public List<WorkflowStep> getListByWorkflowId(Long workflowId) throws IFlowStorageException;
  
}
