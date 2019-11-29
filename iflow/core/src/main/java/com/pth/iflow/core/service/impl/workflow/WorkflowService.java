package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class WorkflowService implements IWorkflowService {

  private final IWorkflowDao workflowDao;

  public WorkflowService(@Autowired final IWorkflowDao invoiceWorkflowDao) {
    this.workflowDao = invoiceWorkflowDao;
  }

  @Override
  public WorkflowEntity save(final WorkflowEntity model) {

    if (model.isNew()) {
      model.increaseVersion();
      return workflowDao.create(model);
    }

    final WorkflowEntity exists = workflowDao.getById(model.getId());
    model.verifyVersion(exists);

    return workflowDao.update(model);

  }

  @Override
  public WorkflowEntity getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowEntity> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

}
