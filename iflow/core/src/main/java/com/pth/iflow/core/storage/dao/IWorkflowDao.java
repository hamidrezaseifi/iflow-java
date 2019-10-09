package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  Workflow create(Workflow model) throws IFlowStorageException;

  Workflow update(Workflow model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  Workflow getById(Long id) throws IFlowStorageException;

  Workflow getByIdentity(String identity) throws IFlowStorageException;

  Set<Workflow> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  Set<Workflow> getListByWorkflowTypeId(Long id) throws IFlowStorageException;

  Set<Workflow> getListForUser(Long id, int status) throws IFlowStorageException;

  Set<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);

  Set<Workflow> getListByIdentityList(Set<String> idList);
}
