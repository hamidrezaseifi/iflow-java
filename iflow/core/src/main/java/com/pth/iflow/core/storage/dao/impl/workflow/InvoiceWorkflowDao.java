package com.pth.iflow.core.storage.dao.impl.workflow;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.storage.dao.impl.base.WorkflowParentEntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@Repository
public class InvoiceWorkflowDao extends WorkflowParentEntityDaoBase<InvoiceWorkflowEntity> implements IInvoiceWorkflowDao {

  @Override
  protected Class<InvoiceWorkflowEntity> entityClass() {
    return InvoiceWorkflowEntity.class;
  }

}
