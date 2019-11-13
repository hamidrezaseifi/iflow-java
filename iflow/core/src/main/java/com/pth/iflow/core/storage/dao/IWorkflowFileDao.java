package com.pth.iflow.core.storage.dao;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowFileDao {

  public WorkflowFile create(WorkflowFile model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFile update(WorkflowFile model, final boolean withTransaction) throws IFlowStorageException;

  public WorkflowFile getById(Long id) throws IFlowStorageException;

  public WorkflowFile getByIdentity(String identity) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteByWorkflowId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public List<WorkflowFile> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowFile> getListByWorkflowId(Long id) throws IFlowStorageException;

  public List<WorkflowFile> getListByWorkflowIdentity(String workflowIdentity) throws IFlowStorageException;

}
