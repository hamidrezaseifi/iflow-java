package com.pth.iflow.gui.services.impl.workflow.invoice;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.IdentityListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class InvoiceWorkflowAccess implements IWorkflowAccess<InvoiceWorkflow, InvoiceWorkflowSaveRequest> {

  private static final Logger                               logger = LoggerFactory.getLogger(InvoiceWorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public InvoiceWorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public InvoiceWorkflow readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final InvoiceWorkflowEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadInvoiceWorkflowUri(workflowIdentity),
        EModule.WORKFLOW, InvoiceWorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<InvoiceWorkflow> createWorkflow(final InvoiceWorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    final InvoiceWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateInvoiceWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(createRequest), InvoiceWorkflowListEdo.class, token, true);

    return GuiModelEdoMapper.fromInvoiceWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public InvoiceWorkflow saveWorkflow(final InvoiceWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    final InvoiceWorkflowEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSaveInvoiceWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(request), InvoiceWorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public void validateWorkflow(final InvoiceWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    this.restTemplate.callRestPost(this.moduleAccessConfig.getValidateInvoiceWorkflowUri(), EModule.WORKFLOW, GuiModelEdoMapper.toEdo(request),
        Void.class, token, true);

  }

  @Override
  public List<InvoiceWorkflow> readWorkflowList(final Set<String> workflowIdentityList, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflow by identity list");

    final IdentityListEdo        listEdo         = new IdentityListEdo(workflowIdentityList);
    final InvoiceWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.getReadInvoiceWorkflowListByIdentityListUri(), EModule.WORKFLOW, listEdo, InvoiceWorkflowListEdo.class, token,
        true);

    final List<InvoiceWorkflow>  list            = GuiModelEdoMapper.fromInvoiceWorkflowEdoList(responseListEdo.getWorkflows());

    return list;
  }

}
