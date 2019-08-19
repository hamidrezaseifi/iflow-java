package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  Workflow create(Workflow model) throws IFlowStorageException;

  Workflow update(Workflow model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  Workflow getById(Long id) throws IFlowStorageException;

  List<Workflow> getListByIdList(List<Long> idList) throws IFlowStorageException;

  List<Workflow> getListByWorkflowTypeId(Long id) throws IFlowStorageException;

  List<Workflow> getListForUser(Long id, int status) throws IFlowStorageException;

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);
}
