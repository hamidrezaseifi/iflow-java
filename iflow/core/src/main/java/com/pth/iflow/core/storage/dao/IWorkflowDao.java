package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  public Workflow create(Workflow workflow) throws IFlowStorageException;

  public Workflow update(Workflow workflow) throws IFlowStorageException;

  public Workflow getById(Long id) throws IFlowStorageException;

  public List<Workflow> getListByIdList(List<Long> idList) throws IFlowStorageException;

  public List<Workflow> getListByWorkflowTypeId(Long id) throws IFlowStorageException;

}
