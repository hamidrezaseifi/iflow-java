package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IInvoiceWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@Service
public class InvoiceWorkflowService implements IInvoiceWorkflowService {

  private final IInvoiceWorkflowDao invoiceWorkflowDao;

  private final IWorkflowService    workflowService;

  public InvoiceWorkflowService(@Autowired final IInvoiceWorkflowDao singleTaskorkflowDao,
      @Autowired final IWorkflowService workflowService) {
    this.invoiceWorkflowDao = singleTaskorkflowDao;
    this.workflowService = workflowService;
  }

  @Override
  public InvoiceWorkflowEntity save(final InvoiceWorkflowEntity model) {

    if (model.isNew()) {

      return invoiceWorkflowDao.create(model);
    }

    final InvoiceWorkflowEntity exists = invoiceWorkflowDao.getById(model.getWorkflowId());
    model.verifyVersion(exists);

    return invoiceWorkflowDao.update(model);

  }

  @Override
  public InvoiceWorkflowEntity getByIdentity(final String identity) {
    return this.invoiceWorkflowDao.getByIdentity(identity);
  }

  @Override
  public List<InvoiceWorkflowEntity> getListForUser(final String email, final int status) {

    return this.invoiceWorkflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<InvoiceWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.invoiceWorkflowDao.getListByIdentityList(idList);
  }

  protected InvoiceWorkflowEntity prepareSavingModel(final InvoiceWorkflowEntity model) {
    workflowService.prepareSavingModel(model.getWorkflow());
    return model;
  }
}
