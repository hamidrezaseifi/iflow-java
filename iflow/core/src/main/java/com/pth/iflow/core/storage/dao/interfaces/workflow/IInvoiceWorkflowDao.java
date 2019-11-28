package com.pth.iflow.core.storage.dao.interfaces.workflow;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IInvoiceWorkflowDao {

  InvoiceWorkflowEntity create(InvoiceWorkflowEntity model) throws IFlowStorageException;

  InvoiceWorkflowEntity update(InvoiceWorkflowEntity model) throws IFlowStorageException;

  void deleteWorkflow(final Long workflowId) throws IFlowStorageException;

  InvoiceWorkflowEntity getById(Long id) throws IFlowStorageException;

  InvoiceWorkflowEntity getByIdentity(String identity) throws IFlowStorageException;

  List<InvoiceWorkflowEntity> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  List<InvoiceWorkflowEntity> getListForUserEmail(String email, int status) throws IFlowStorageException;

  List<InvoiceWorkflowEntity> getListByIdentityList(Collection<String> idList);
}
