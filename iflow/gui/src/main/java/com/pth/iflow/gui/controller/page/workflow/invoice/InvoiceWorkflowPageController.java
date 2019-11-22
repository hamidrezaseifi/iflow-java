package com.pth.iflow.gui.controller.page.workflow.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.page.workflow.WorkflowPageControllerBase;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.INVOICEWORKFLOW_PAGE_BASE)
public class InvoiceWorkflowPageController extends WorkflowPageControllerBase<InvoiceWorkflow, InvoiceWorkflowSaveRequest> {

  @Override
  protected String getCreateView() {
    return "workflow/invoice/invoice_assign";
  }

  @Override
  protected String getEditView() {
    return "workflow/invoice/edit";
  }

}
