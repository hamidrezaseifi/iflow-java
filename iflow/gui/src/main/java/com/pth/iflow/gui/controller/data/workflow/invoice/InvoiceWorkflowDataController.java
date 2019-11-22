package com.pth.iflow.gui.controller.data.workflow.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.data.workflow.WorkflowDataControllerBase;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.INVOICEWORKFLOW_DATA_BASE)
public class InvoiceWorkflowDataController extends WorkflowDataControllerBase<InvoiceWorkflow, InvoiceWorkflowSaveRequest> {

  @Override
  protected InvoiceWorkflow generateInitialWorkflow(final String userIdentity) {
    return InvoiceWorkflow.generateInitial(userIdentity);
  }

  @Override
  protected InvoiceWorkflowSaveRequest generateInitialWorkflowSaveRequest(final InvoiceWorkflow workflow, final int expireDays) {
    return InvoiceWorkflowSaveRequest.generateNewWihExpireDays(workflow, expireDays);
  }

}
