package com.pth.iflow.core.storage.dao;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowActionDao {

  public WorkflowAction create(WorkflowAction model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowAction update(WorkflowAction model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowAction getById(Long id) throws IFlowStorageException;

  public WorkflowAction getByIdentity(String identity) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteByWorkflowId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public List<WorkflowAction> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowAction> getListByWorkflowId(Long id) throws IFlowStorageException;

  public List<WorkflowAction> getListByWorkflowIdentity(String workflowIdentity) throws IFlowStorageException;

}
