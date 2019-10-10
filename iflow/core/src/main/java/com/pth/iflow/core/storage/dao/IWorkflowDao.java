package com.pth.iflow.core.storage.dao;

import java.util.List;
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

  List<Workflow> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<Workflow> getListByWorkflowTypeIdentity(String identity) throws IFlowStorageException;

  List<Workflow> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);

  List<Workflow> getListByIdentityList(Set<String> idList);
}
