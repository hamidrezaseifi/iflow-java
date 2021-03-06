package com.pth.iflow.workflow.bl.impl.workflowservice.invoice;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class InvoiceWorkflowCoreConnectService implements IWorkflowDataService<InvoiceWorkflow> {

  private final Logger                                   logger = LoggerFactory.getLogger(getClass());

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public InvoiceWorkflowCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public InvoiceWorkflow getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow data for identity {}", identity);

    final InvoiceWorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_INVOICEWORKFLOW_BY_IDENTITY(identity)), token, EModule.CORE,
        InvoiceWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<InvoiceWorkflow> getListByIdentityList(final Set<String> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for id list {}", idList);

    final InvoiceWorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_INVOICEWORKFLOWLIST_BY_IDENTITYLIST()), token, EModule.CORE,
        idList, InvoiceWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromInvoiceWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public InvoiceWorkflow save(final InvoiceWorkflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request save workflow");

    final InvoiceWorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SAVE_INVOICEWORKFLOW()), token, EModule.CORE,
        WorkflowModelEdoMapper.toEdo(model), InvoiceWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<InvoiceWorkflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company identity {}", identity);

    final InvoiceWorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_INVOICEWORKFLOW_LIST_BY_USERIDENTITY(identity, status)), token,
        EModule.CORE, InvoiceWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromInvoiceWorkflowEdoList(edoList.getWorkflows());
  }

}
