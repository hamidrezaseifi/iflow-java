package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeStepDao {

  public WorkflowTypeStepEntity create(WorkflowTypeStepEntity model, final boolean withTransaction) throws IFlowStorageException;

  public CoreModelHelper update(WorkflowTypeStepEntity model) throws IFlowStorageException;

  public WorkflowTypeStepEntity getById(Long id) throws IFlowStorageException;

  public WorkflowTypeStepEntity getByIdentity(String identity) throws IFlowStorageException;

  public void deleteByWorkflowTypeId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public List<WorkflowTypeStepEntity> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowTypeStepEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  public List<WorkflowTypeStepEntity> getListByWorkflowTypeId(Long workflowId) throws IFlowStorageException;

}
