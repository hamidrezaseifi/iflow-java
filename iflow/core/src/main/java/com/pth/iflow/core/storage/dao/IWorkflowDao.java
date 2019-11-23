package com.pth.iflow.core.storage.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.workflow.IWorkflow;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao<W extends IWorkflow> {

  W create(W model) throws IFlowStorageException;

  W update(W model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  W getById(Long id) throws IFlowStorageException;

  W getByIdentity(String identity) throws IFlowStorageException;

  List<W> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<W> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<W> getListByIdentityList(Collection<String> idList);
}
