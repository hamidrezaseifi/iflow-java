package com.pth.iflow.core.service.impl;

import java.util.Collection;
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
    Workflow exists = null;
    if (model.isIdentityNotSet() == false) {
      exists = this.getByIdentity(model.getIdentity());
      model.setId(exists.getId());
    }

    if (model.isNew()) {
      model.increaseVersion();
      return this.workflowDao.create(model);
    }

    exists = exists != null ? exists : this.workflowDao.getById(model.getId());

    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Workflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowDao.update(model);
  }

  @Override
  public Workflow getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<Workflow> getListByTypeId(final String identity) {

    return this.workflowDao.getListByWorkflowTypeIdentity(identity);
  }

  @Override
  public List<Workflow> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserEmail(email, status);
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter) {

    return this.workflowDao.search(workflowSearchFilter);
  }

  @Override
  public List<Workflow> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

}
