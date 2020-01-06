package com.pth.iflow.workflow.bl.impl.workflowservice.singletask;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class SingleTaskWorkflowCoreConnectService implements IWorkflowDataService<SingleTaskWorkflow> {

  private final Logger                                   logger = LoggerFactory.getLogger(getClass());

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public SingleTaskWorkflowCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public SingleTaskWorkflow getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow data for identity {}", identity);

    final SingleTaskWorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_SINGLETASKWORKFLOW_BY_IDENTITY(identity)), token, EModule.CORE,
        SingleTaskWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<SingleTaskWorkflow> getListByIdentityList(final Set<String> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for id list {}", idList);

    final SingleTaskWorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_SINGLETASKWORKFLOWLIST_BY_IDENTITYLIST()), token, EModule.CORE,
        idList, SingleTaskWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromSingleTaskWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public SingleTaskWorkflow save(final SingleTaskWorkflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request save workflow");

    final SingleTaskWorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SAVE_SINGLETASKWORKFLOW()), token, EModule.CORE,
        WorkflowModelEdoMapper.toEdo(model), SingleTaskWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<SingleTaskWorkflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company identity {}", identity);

    final SingleTaskWorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_SINGLETASKWORKFLOW_LIST_BY_USERIDENTITY(identity, status)),
        token, EModule.CORE, SingleTaskWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromSingleTaskWorkflowEdoList(edoList.getWorkflows());
  }

}
