package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.workflow.InvoiceWorkflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class InvoiceWorkflowService implements IWorkflowService<InvoiceWorkflow> {

  private final IWorkflowDao<InvoiceWorkflow> workflowDao;

  public InvoiceWorkflowService(@Autowired final IWorkflowDao<InvoiceWorkflow> invoiceWorkflowDao) {
    this.workflowDao = invoiceWorkflowDao;
  }

  @Override
  public InvoiceWorkflow save(final InvoiceWorkflow model) {
    InvoiceWorkflow exists = null;
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
      throw new IFlowOptimisticLockException("InvoiceWorkflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.workflowDao.update(model);
  }

  @Override
  public InvoiceWorkflow getByIdentity(final String identity) {
    return this.workflowDao.getByIdentity(identity);
  }

  @Override
  public List<InvoiceWorkflow> getListForUser(final String email, final int status) {

    return this.workflowDao.getListForUserEmail(email, status);
  }

  @Override
  public List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter) {

    return this.workflowDao.search(workflowSearchFilter);
  }

  @Override
  public List<InvoiceWorkflow> getListByIdentityList(final Collection<String> idList) {

    return this.workflowDao.getListByIdentityList(idList);
  }

}
