package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowFileDao {

  public WorkflowFile create(WorkflowFile model) throws IFlowStorageException;

  public WorkflowFile update(WorkflowFile model) throws IFlowStorageException;

  public WorkflowFile getById(Long id) throws IFlowStorageException;

  public List<WorkflowFile> getListByIdList(List<Long> idList) throws IFlowStorageException;

  public List<WorkflowFile> getListByWorkflowId(Long id) throws IFlowStorageException;

}
