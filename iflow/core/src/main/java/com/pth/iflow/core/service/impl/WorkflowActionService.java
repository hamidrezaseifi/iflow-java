package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.storage.dao.IWorkflowActionDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class WorkflowActionService implements IWorkflowActionService {

  private final IWorkflowActionDao workflowActionDao;

  public WorkflowActionService(@Autowired final IWorkflowActionDao workflowActionDao) {
    this.workflowActionDao = workflowActionDao;
  }

  @Override
  public WorkflowAction save(final WorkflowAction model) {
    if (model.isNew()) {
      model.setVersion(0);
      return workflowActionDao.create(model);
    }

    final WorkflowAction exists = workflowActionDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("WorkflowAction with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return workflowActionDao.update(model);
  }

  @Override
  public WorkflowAction getById(final Long id) {
    return workflowActionDao.getById(id);
  }

  @Override
  public List<WorkflowAction> getListByIdWorkflowId(final Long id) {
    return workflowActionDao.getListByWorkflowId(id);
  }

}