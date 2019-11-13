package com.pth.iflow.core.storage.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.workflow.sub.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeStepDao {

  public WorkflowTypeStep create(WorkflowTypeStep model, final boolean withTransaction) throws IFlowStorageException;

  public CoreModelHelper update(WorkflowTypeStep model) throws IFlowStorageException;

  public WorkflowTypeStep getById(Long id) throws IFlowStorageException;

  public WorkflowTypeStep getByIdentity(String identity) throws IFlowStorageException;

  public void deleteByWorkflowTypeId(Long id, final boolean withTransaction) throws IFlowStorageException;

  public void deleteById(Long id, final boolean withTransaction) throws IFlowStorageException;

  public List<WorkflowTypeStep> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public List<WorkflowTypeStep> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  public List<WorkflowTypeStep> getListByWorkflowTypeId(Long workflowId) throws IFlowStorageException;

}
