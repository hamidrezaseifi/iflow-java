package com.pth.iflow.gui.services.impl.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.models.workflow.workflow.WorkflowSaveRequest;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowAccess;

@Service
public class WorkflowHandlerSelect {

  private static final Logger                                                       logger = LoggerFactory
      .getLogger(TestThreeTaskWorkflowAccess.class);

  @Autowired
  private IWorkflowHandler<Workflow, WorkflowSaveRequest>                           workflowHandlerBase;

  @Autowired
  private IWorkflowHandler<InvoiceWorkflow, InvoiceWorkflowSaveRequest>             workflowHandlerInvoice;

  @Autowired
  private IWorkflowHandler<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest>       workflowHandlerSingleTask;

  @Autowired
  private IWorkflowHandler<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> workflowHandlerTestThreeTask;

  public IWorkflowHandler getHandlerByType(final EWorkflowType typeEnum) {
    if (typeEnum == EWorkflowType.NONE) {
      return this.workflowHandlerBase;
    }
    if (typeEnum == EWorkflowType.INVOICE_WORKFLOW_TYPE) {
      return this.workflowHandlerInvoice;
    }
    if (typeEnum == EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE) {
      return this.workflowHandlerSingleTask;
    }
    if (typeEnum == EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE) {
      return this.workflowHandlerTestThreeTask;
    }

    return null;
  }
}
