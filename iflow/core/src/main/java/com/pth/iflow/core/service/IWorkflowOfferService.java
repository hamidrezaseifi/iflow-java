package com.pth.iflow.core.service;

import java.util.List;
import com.pth.iflow.core.model.WorkflowOffer;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IWorkflowOfferService {

  public WorkflowOffer save(WorkflowOffer model) throws IFlowStorageException;

  public void updateStatusByWorkflow(Long workflowId, Integer status) throws IFlowStorageException;

  public WorkflowOffer getById(Long id) throws IFlowStorageException;

  public List<WorkflowOffer> getListByUserId(final Long userId, final Long lastid, Integer status) throws IFlowStorageException;

  public List<WorkflowOffer> getListByWorkflowId(final Long workflowId, final Long lastid, final Integer status) throws IFlowStorageException;
}
