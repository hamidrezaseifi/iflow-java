package com.pth.iflow.core.storage.dao;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.workflow.sub.WorkflowFileVersion;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowFileVersionDao {

  public WorkflowFileVersion create(WorkflowFileVersion model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFileVersion update(WorkflowFileVersion model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFileVersion getById(Long id) throws IFlowStorageException;

  public void deleteById(Long id) throws IFlowStorageException;

  public void deleteByWorkflowFileId(Long id, final boolean withTransaction, final boolean checkDeleted) throws IFlowStorageException;

  public List<WorkflowFileVersion> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowFileVersion> getListByWorkflowFileId(Long id) throws IFlowStorageException;

}
