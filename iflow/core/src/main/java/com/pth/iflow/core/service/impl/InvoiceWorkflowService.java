package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.InvoiceWorkflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.service.IInvoiceWorkflowService;
import com.pth.iflow.core.storage.dao.IInvoiceWorkflowDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class InvoiceWorkflowService implements IInvoiceWorkflowService {

  private final IInvoiceWorkflowDao invoiceWorkflowDao;

  public InvoiceWorkflowService(@Autowired final IInvoiceWorkflowDao invoiceWorkflowDao) {
    this.invoiceWorkflowDao = invoiceWorkflowDao;
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
      return this.invoiceWorkflowDao.create(model);
    }

    exists = exists != null ? exists : this.invoiceWorkflowDao.getById(model.getId());

    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("InvoiceWorkflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.invoiceWorkflowDao.update(model);
  }

  @Override
  public InvoiceWorkflow getByIdentity(final String identity) {
    return this.invoiceWorkflowDao.getByIdentity(identity);
  }

  @Override
  public List<InvoiceWorkflow> getListForUser(final String email, final int status) {

    return this.invoiceWorkflowDao.getListForUserEmail(email, status);
  }

  @Override
  public List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter) {

    return this.invoiceWorkflowDao.search(workflowSearchFilter);
  }

  @Override
  public List<InvoiceWorkflow> getListByIdentityList(final Collection<String> idList) {

    return this.invoiceWorkflowDao.getListByIdentityList(idList);
  }

}
