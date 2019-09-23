package com.pth.iflow.core.storage.dao;

import java.util.List;
import com.pth.iflow.core.model.WorkflowOffer;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowOfferDao {

  public WorkflowOffer create(WorkflowOffer model) throws IFlowStorageException;

  public WorkflowOffer update(WorkflowOffer model) throws IFlowStorageException;

  public void updateStatusByWorkflow(Long workflowId, Integer status) throws IFlowStorageException;

  public WorkflowOffer getById(Long id) throws IFlowStorageException;

  public List<WorkflowOffer> getListByUserId(Long userId, Integer status) throws IFlowStorageException;

  public List<WorkflowOffer> getListByWorkflowId(Long workflowId, Integer status) throws IFlowStorageException;

}
