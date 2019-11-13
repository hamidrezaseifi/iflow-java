package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.workflow.SingleTaskWorkflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class SingleTaskWorkflowService implements IWorkflowService<SingleTaskWorkflow> {

  private final IWorkflowDao<SingleTaskWorkflow> workflowDao;

  public SingleTaskWorkflowService(@Autowired final IWorkflowDao<SingleTaskWorkflow> invoiceWorkflowDao) {
    this.workflowDao = invoiceWorkflowDao;
  }

  @Override
  public SingleTaskWorkflow save(final SingleTaskWorkflow model) {
    SingleTaskWorkflow exists = null;
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
      throw new IFlowOptimisticLockException("SingleTaskWorkflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowDao.update(model);
  }

  @Override
  public SingleTaskWorkflow getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<SingleTaskWorkflow> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserEmail(email, status);
  }

  @Override
  public List<SingleTaskWorkflow> search(final WorkflowSearchFilter workflowSearchFilter) {

    return this.workflowDao.search(workflowSearchFilter);
  }

  @Override
  public List<SingleTaskWorkflow> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

}
