package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IInvoiceWorkflowDao {

  InvoiceWorkflowEntity create(InvoiceWorkflowEntity model) throws IFlowStorageException;

  InvoiceWorkflowEntity update(InvoiceWorkflowEntity model) throws IFlowStorageException;

  void deleteById(final Long workflowId) throws IFlowStorageException;

  InvoiceWorkflowEntity getById(Long id) throws IFlowStorageException;

  InvoiceWorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<InvoiceWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException;

  List<InvoiceWorkflowEntity> getListByIdentityList(Collection<String> idList);
}
