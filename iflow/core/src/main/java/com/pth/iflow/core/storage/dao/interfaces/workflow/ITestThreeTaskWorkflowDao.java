package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ITestThreeTaskWorkflowDao {

  TestThreeTaskWorkflowEntity create(TestThreeTaskWorkflowEntity model) throws IFlowStorageException;

  TestThreeTaskWorkflowEntity update(TestThreeTaskWorkflowEntity model) throws IFlowStorageException;

  void deleteById(final Long workflowId) throws IFlowStorageException;

  TestThreeTaskWorkflowEntity getById(Long id) throws IFlowStorageException;

  TestThreeTaskWorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<TestThreeTaskWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException;

  List<TestThreeTaskWorkflowEntity> getListByIdentityList(Collection<String> idList);
}
