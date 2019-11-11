package com.pth.iflow.core.storage.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.InvoiceWorkflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IInvoiceWorkflowDao {

  InvoiceWorkflow create(InvoiceWorkflow model) throws IFlowStorageException;

  InvoiceWorkflow update(InvoiceWorkflow model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  InvoiceWorkflow getById(Long id) throws IFlowStorageException;

  InvoiceWorkflow getByIdentity(String identity) throws IFlowStorageException;

  List<InvoiceWorkflow> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<InvoiceWorkflow> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter);

  List<InvoiceWorkflow> getListByIdentityList(Collection<String> idList);
}
