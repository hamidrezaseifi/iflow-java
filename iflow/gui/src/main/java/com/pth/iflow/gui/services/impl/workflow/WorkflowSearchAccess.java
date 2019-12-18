package com.pth.iflow.gui.services.impl.workflow;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.IWorkflowSearchAccess;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowAccess;

@Service
public class WorkflowSearchAccess implements IWorkflowSearchAccess {

  private static final Logger                                                             logger = LoggerFactory
      .getLogger(TestThreeTaskWorkflowAccess.class);

  private final IRestTemplateCall                                                         restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig                               moduleAccessConfig;
  private final SessionUserInfo                                                           sessionUserInfo;

  private final IWorkflowHandler<InvoiceWorkflow, InvoiceWorkflowSaveRequest>             invoiceWorkflowHandler;

  private final IWorkflowHandler<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest>       singleTaskWorkflowHandler;

  private final IWorkflowHandler<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> testThreeTaskWorkflowHandler;

  public WorkflowSearchAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig, @Autowired final SessionUserInfo sessionUserInfo,
      @Autowired final IWorkflowHandler<InvoiceWorkflow, InvoiceWorkflowSaveRequest> invoiceWorkflowHandler,
      @Autowired final IWorkflowHandler<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> singleTaskWorkflowHandler,
      @Autowired final IWorkflowHandler<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> testThreeTaskWorkflowHandler) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
    this.invoiceWorkflowHandler = invoiceWorkflowHandler;
    this.singleTaskWorkflowHandler = singleTaskWorkflowHandler;
    this.testThreeTaskWorkflowHandler = testThreeTaskWorkflowHandler;
  }

  @Override
  public List<Workflow> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Search workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchWorkflowUri(), EModule.WORKFLOW,
        GuiModelEdoMapper.toEdo(workflowSearchFilter), WorkflowListEdo.class, this.sessionUserInfo.getToken(), true);

    final List<Workflow>  list            = GuiModelEdoMapper.fromWorkflowEdoList(responseListEdo.getWorkflows());
    for (final Workflow resultWorkflow : list) {

      this.prepareResult(resultWorkflow);
    }

    return list;

  }

  @Override
  public List<Workflow> readByIdentityList(final Set<String> identityList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflowresult by identity list");

    final IdentityListEdo listEdo         = new IdentityListEdo(identityList);
    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadWorkflowListByIdentityListUri(),
        EModule.WORKFLOW, listEdo, WorkflowListEdo.class, this.sessionUserInfo.getToken(), true);

    final List<Workflow>  list            = GuiModelEdoMapper.fromWorkflowEdoList(responseListEdo.getWorkflows());
    for (final Workflow resultWorkflow : list) {

      this.prepareResult(resultWorkflow);
    }

    return list;
  }

  private IWorkflowHandler getHandlerByWorkflowType(final EWorkflowType eEorkflowType) {
    if (eEorkflowType == EWorkflowType.INVOICE_WORKFLOW_TYPE) {
      return this.invoiceWorkflowHandler;
    }
    if (eEorkflowType == EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE) {
      return this.singleTaskWorkflowHandler;
    }
    if (eEorkflowType == EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE) {
      return this.testThreeTaskWorkflowHandler;
    }
    return null;
  }

  private void prepareResult(final Workflow resultWorkflow)
      throws IFlowMessageConversionFailureException, GuiCustomizedException, MalformedURLException {
    resultWorkflow.setWorkflowType(this.sessionUserInfo.getWorkflowTypeByIdentity(resultWorkflow.getWorkflowTypeIdentity()));
    resultWorkflow.setCurrentStep(
        this.sessionUserInfo.getWorkflowStepTypeByIdentity(resultWorkflow.getWorkflowTypeIdentity(), resultWorkflow.getCurrentStepIdentity()));

    final IWorkflowHandler handler      = this.getHandlerByWorkflowType(resultWorkflow.getWorkflowType().getTypeEnum());
    final IWorkflow        readWorkflow = handler.readWorkflow(resultWorkflow.getIdentity());
    resultWorkflow.setActions(readWorkflow.getActions());
    resultWorkflow.setFiles(readWorkflow.getFiles());

    resultWorkflow.setCurrentUserIdentity(this.sessionUserInfo.getUser().getIdentity());
  }

}
