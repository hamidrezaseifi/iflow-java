package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.InvoiceWorkflow;
import com.pth.iflow.workflow.models.InvoiceWorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;

public interface IInvoiceWorkflowProcessService {

  public List<InvoiceWorkflow> create(InvoiceWorkflowSaveRequest model, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public InvoiceWorkflow save(InvoiceWorkflowSaveRequest request, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public InvoiceWorkflow getByIdentity(String identity, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<InvoiceWorkflow> getListForUser(final String identity, int status, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<InvoiceWorkflow> getListByIdentityList(final Set<String> identityList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<InvoiceWorkflow> search(final WorkflowSearchFilter workflowSearchFilter, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void validate(InvoiceWorkflowSaveRequest model, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
