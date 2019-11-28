package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ISingleTaskWorkflowDao {

  SingleTaskWorkflowEntity create(SingleTaskWorkflowEntity model) throws IFlowStorageException;

  SingleTaskWorkflowEntity update(SingleTaskWorkflowEntity model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  SingleTaskWorkflowEntity getById(Long id) throws IFlowStorageException;

  SingleTaskWorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<SingleTaskWorkflowEntity> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<SingleTaskWorkflowEntity> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<SingleTaskWorkflowEntity> getListByIdentityList(Collection<String> idList);
}
