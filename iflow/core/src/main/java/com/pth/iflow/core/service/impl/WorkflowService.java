package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class WorkflowService implements IWorkflowService {

  private final IWorkflowDao workflowDao;

  public WorkflowService(@Autowired final IWorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }

  @Override
  public Workflow save(final Workflow model) {
    if (model.isNew()) {
      model.increaseVersion();
      return this.workflowDao.create(model);
    }

    final Workflow exists = this.workflowDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Workflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowDao.update(model);
  }

  @Override
  public Workflow getById(final Long id) {
    return this.workflowDao.getById(id);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id) {

    return this.workflowDao.getListByWorkflowTypeId(id);
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) {

    return this.workflowDao.getListByIdList(idList);
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status) {

    return this.workflowDao.getListForUser(id, status);
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter) {

    return this.workflowDao.search(workflowSearchFilter);
  }

}
