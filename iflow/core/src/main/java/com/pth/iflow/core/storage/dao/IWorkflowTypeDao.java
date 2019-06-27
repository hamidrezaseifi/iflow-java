package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeDao {
  
  public WorkflowType getById(Long id) throws IFlowStorageException;
  
  public List<WorkflowType> getListByIdList(List<Long> idList) throws IFlowStorageException;
  
  public List<WorkflowType> getListByCompanyId(Long id) throws IFlowStorageException;
  
}
