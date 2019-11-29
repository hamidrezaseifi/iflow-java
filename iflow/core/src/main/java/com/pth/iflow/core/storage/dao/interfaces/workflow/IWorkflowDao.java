package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  WorkflowEntity create(WorkflowEntity model) throws IFlowStorageException;

  WorkflowEntity update(WorkflowEntity model) throws IFlowStorageException;

  void deleteById(final Long workflowId) throws IFlowStorageException;

  void deleteAllSubItemsById(final Long workflowId) throws IFlowStorageException;

  WorkflowEntity getById(Long id) throws IFlowStorageException;

  WorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<WorkflowEntity> getListForUserIdentity(String userIdentity, int status) throws IFlowStorageException;

  List<WorkflowEntity> getListByIdentityList(Collection<String> idList);
}
