package com.pth.iflow.gui.controller.page.workflow.invoice;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.page.workflow.WorkflowPageControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.INVOICEWORKFLOW_PAGE_BASE + "-old")
public class InvoiceWorkflowPageController extends WorkflowPageControllerBase<InvoiceWorkflow, InvoiceWorkflowSaveRequest> {

  @Override
  protected String getCreateView() {

    return "workflow/invoice/invoice_assign";
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  protected String showCreateWorkflow(final Model model, @PathVariable(required = false) final String workflowTypeIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    model.addAttribute("UserAssign", EAssignType.USER.getIdentity());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getIdentity());

    final Map<EInvoiceType, String> invoiceTypes = new HashMap<>();// EInvoiceType.nameValueMap();
    // invoiceTypes.remove(EInvoiceType.NO_TYPE.getValue());
    for (final EInvoiceType key : EInvoiceType.values()) {
      if (key == EInvoiceType.NO_TYPE) {
        continue;
      }
      invoiceTypes.put(key, this.messagesHelper.get("invoice-invoicetype-" + key.toString().toLowerCase()));
    }

    model.addAttribute("invoiceTypes", invoiceTypes);

    return this.getCreateView();

  }

}
