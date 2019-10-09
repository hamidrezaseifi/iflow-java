package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeStepDao {

  public WorkflowTypeStep create(WorkflowTypeStep model, final boolean withTransaction) throws IFlowStorageException;

  public CoreModelHelper update(WorkflowTypeStep model) throws IFlowStorageException;

  public WorkflowTypeStep getById(Long id) throws IFlowStorageException;

  public WorkflowTypeStep getByIdentity(String identity) throws IFlowStorageException;

  public void deleteByWorkflowTypeId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public Set<WorkflowTypeStep> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public Set<WorkflowTypeStep> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public Set<WorkflowTypeStep> getListByWorkflowTypeId(Long workflowId) throws IFlowStorageException;

}
