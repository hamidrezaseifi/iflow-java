package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.InvoiceWorkflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;

public interface IInvoiceWorkflowService {

  public InvoiceWorkflow save(InvoiceWorkflow model);

  public InvoiceWorkflow getByIdentity(String identity);

  public List<InvoiceWorkflow> getListForUser(final String email, final int status);

  public List<InvoiceWorkflow> getListByIdentityList(final Collection<String> idList);

  public List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter);
}
