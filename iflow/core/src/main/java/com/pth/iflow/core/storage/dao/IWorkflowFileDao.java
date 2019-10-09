package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowFileDao {

  public WorkflowFile create(WorkflowFile model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFile update(WorkflowFile model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFile getById(Long id) throws IFlowStorageException;

  public WorkflowFile getByIdentity(String identity) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteByWorkflowId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public Set<WorkflowFile> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public Set<WorkflowFile> getListByWorkflowId(Long id) throws IFlowStorageException;

}
