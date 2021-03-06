package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IInvoiceWorkflowService extends ICoreModelEdoMapperService<InvoiceWorkflowEntity, InvoiceWorkflowEdo> {

  public InvoiceWorkflowEntity save(InvoiceWorkflowEntity model);

  public InvoiceWorkflowEntity getByIdentity(String identity);

  public List<InvoiceWorkflowEntity> getListForUser(final String email, final int status);

  public List<InvoiceWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
