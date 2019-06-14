package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  public Workflow getById(Long id) throws IFlowStorageException;

  public List<Workflow> getListByIdList(List<Long> idList) throws IFlowStorageException;

}
