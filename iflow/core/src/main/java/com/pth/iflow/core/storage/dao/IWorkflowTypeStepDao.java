package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowTypeStepDao {

  public WorkflowTypeStep create(WorkflowTypeStep model) throws IFlowStorageException;

  public WorkflowTypeStep update(WorkflowTypeStep model) throws IFlowStorageException;

  public WorkflowTypeStep getById(Long id) throws IFlowStorageException;

  public List<WorkflowTypeStep> getListByIdList(List<Long> idList) throws IFlowStorageException;

  public List<WorkflowTypeStep> getListByWorkflowTypeId(Long workflowId) throws IFlowStorageException;

}
