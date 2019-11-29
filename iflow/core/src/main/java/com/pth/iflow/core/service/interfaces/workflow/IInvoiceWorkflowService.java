package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;

public interface IInvoiceWorkflowService {

  public InvoiceWorkflowEntity save(InvoiceWorkflowEntity model);

  public InvoiceWorkflowEntity getByIdentity(String identity);

  public List<InvoiceWorkflowEntity> getListForUser(final String email, final int status);

  public List<InvoiceWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
