package com.pth.iflow.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.WorkflowOffer;
import com.pth.iflow.core.service.IWorkflowOfferService;
import com.pth.iflow.core.storage.dao.IWorkflowOfferDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Service
public class WorkflowOfferService implements IWorkflowOfferService {

  private final IWorkflowOfferDao workflowOfferDao;

  public WorkflowOfferService(@Autowired final IWorkflowOfferDao workflowOfferDao) {
    this.workflowOfferDao = workflowOfferDao;
  }

  @Override
  public WorkflowOffer save(final WorkflowOffer model) throws IFlowStorageException {
    if (model.isNew()) {
      model.increaseVersion();
      return this.workflowOfferDao.create(model);
    }

    final WorkflowOffer exists = this.workflowOfferDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Workflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowOfferDao.update(model);
  }

  @Override
  public void updateStatusByWorkflow(final Long workflowId, final Integer status) throws IFlowStorageException {
    this.workflowOfferDao.updateStatusByWorkflow(workflowId, status);
  }

  @Override
  public WorkflowOffer getById(final Long id) throws IFlowStorageException {
    return this.workflowOfferDao.getById(id);
  }

  @Override
  public List<WorkflowOffer> getListByUserId(final Long userId, final Long lastid, final Integer status) throws IFlowStorageException {

    return this.workflowOfferDao.getListByUserId(userId, lastid, status);
  }

  @Override
  public List<WorkflowOffer> getListByWorkflowId(final Long workflowId, final Long lastid, final Integer status) throws IFlowStorageException {

    return this.workflowOfferDao.getListByWorkflowId(workflowId, lastid, status);
  }

}
