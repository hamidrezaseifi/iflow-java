package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowDao {

  WorkflowEntity create(WorkflowEntity model) throws IFlowStorageException;

  WorkflowEntity update(WorkflowEntity model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  WorkflowEntity getById(Long id) throws IFlowStorageException;

  WorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<WorkflowEntity> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<WorkflowEntity> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<WorkflowEntity> getListByIdentityList(Collection<String> idList);
}
