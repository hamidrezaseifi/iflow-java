package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.helper.CoreDataHelper;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.workflow.IInvoiceWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@Service
public class InvoiceWorkflowService extends CoreModelEdoMapperService<InvoiceWorkflowEntity, InvoiceWorkflowEdo>
    implements IInvoiceWorkflowService {

  private final IInvoiceWorkflowDao invoiceWorkflowDao;

  private final IWorkflowService    workflowService;

  public InvoiceWorkflowService(@Autowired final IInvoiceWorkflowDao singleTaskorkflowDao, @Autowired final IWorkflowService workflowService) {
    this.invoiceWorkflowDao = singleTaskorkflowDao;
    this.workflowService = workflowService;
  }

  @Override
  public InvoiceWorkflowEntity save(final InvoiceWorkflowEntity model) {

    if (model.isNew()) {

      return invoiceWorkflowDao.create(model);
    }

    model.setWorkflowId(model.getWorkflowId() == null ? model.getWorkflow().getId() : model.getWorkflowId());
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

  @Override
  public InvoiceWorkflowEntity fromEdo(final InvoiceWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final InvoiceWorkflowEntity model = new InvoiceWorkflowEntity();

    model.setWorkflow(workflowService.fromEdo(edo.getWorkflow()));

    model.setDiscountDate(CoreDataHelper.fromLocalDate(edo.getDiscountDate()));
    model.setDiscountDeadline(edo.getDiscountDeadline());
    model.setDiscountEnterDate(CoreDataHelper.fromLocalDate(edo.getDiscountEnterDate()));
    model.setDiscountRate(edo.getDiscountRate());
    model.setInvoiceDate(CoreDataHelper.fromLocalDate(edo.getInvoiceDate()));
    model.setInvoiceType(edo.getInvoiceType());
    model.setIsDirectDebitPermission(edo.getIsDirectDebitPermission());
    model.setPartnerCode(edo.getPartnerCode());
    model.setPaymentAmount(edo.getPaymentAmount());
    model.setRegisterNumber(edo.getRegisterNumber());
    model.setSender(edo.getSender());
    model.setVendorName(edo.getVendorName());
    model.setVendorNumber(edo.getVendorNumber());

    return model;
  }

  @Override
  public InvoiceWorkflowEdo toEdo(final InvoiceWorkflowEntity model) {
    final InvoiceWorkflowEdo edo = new InvoiceWorkflowEdo();
    edo.setWorkflow(workflowService.toEdo(model.getWorkflow()));

    edo.setDiscountDate(CoreDataHelper.toLocalDate(model.getDiscountDate()));
    edo.setDiscountDeadline(model.getDiscountDeadline());
    edo.setDiscountEnterDate(CoreDataHelper.toLocalDate(model.getDiscountEnterDate()));
    edo.setDiscountRate(model.getDiscountRate());
    edo.setInvoiceDate(CoreDataHelper.toLocalDate(model.getInvoiceDate()));
    edo.setInvoiceType(model.getInvoiceType());
    edo.setIsDirectDebitPermission(model.getIsDirectDebitPermission());
    edo.setPartnerCode(model.getPartnerCode());
    edo.setPaymentAmount(model.getPaymentAmount());
    edo.setRegisterNumber(model.getRegisterNumber());
    edo.setSender(model.getSender());
    edo.setVendorName(model.getVendorName());
    edo.setVendorNumber(model.getVendorNumber());

    return edo;
  }
}
