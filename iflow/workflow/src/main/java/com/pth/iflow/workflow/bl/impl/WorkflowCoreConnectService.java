package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowCoreConnectService implements IWorkflowDataService {

  private static final Logger                            logger = LoggerFactory.getLogger(WorkflowCoreConnectService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public Workflow getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow data for identity {}", identity);

    final WorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOW_BY_IDENTITY(identity)), token, EModule.CORE,
        WorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<Workflow> getListByIdentityList(final Set<String> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for id list {}", idList);

    final WorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOW_LIST()), token, EModule.CORE, idList,
        WorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public Workflow save(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request save workflow");

    final WorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SAVE_WORKFLOW()), token, EModule.CORE,
        WorkflowModelEdoMapper.toEdo(model), WorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<Workflow> getListByTypeIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company identity {}", identity);

    final WorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOW_LIST_BY_WORKFLOWTYPEIDENTITY(identity)), token,
        EModule.CORE, WorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public List<Workflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company identity {}", identity);

    final WorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOW_LIST_BY_USERIDENTITY(identity, status)), token,
        EModule.CORE, WorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Search workflow");

    final WorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SEARCH_WORKFLOW()), token, EModule.CORE,
        WorkflowModelEdoMapper.toEdo(workflowSearchFilter), WorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowEdoList(edoList.getWorkflows());
  }

}
