package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
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
  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Request workflow data for id {}", id);

    final WorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_READ_BY_ID), token, EModule.CORE, WorkflowEdo.class,
        true, id);

    return new Workflow().fromEdo(edo);
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);

    final WorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_READ_LIST), token, EModule.CORE, idList,
        WorkflowListEdo.class, true);

    return new Workflow().fromEdoList(edoList.getWorkflows());
  }

  @Override
  public Workflow save(final Workflow model, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request save workflow {}", model.getTitle());

    final WorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_SAVE), token, EModule.CORE, model.toEdo(),
        WorkflowEdo.class, true);

    return new Workflow().fromEdo(edo);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);

    final WorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_READ_LIST_BY_TYPE), token, EModule.CORE,
        WorkflowListEdo.class, true, id);

    return new Workflow().fromEdoList(edoList.getWorkflows());
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);

    final WorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_READ_LIST_BY_USER), token, EModule.CORE,
        WorkflowListEdo.class, true, id, status);

    return new Workflow().fromEdoList(edoList.getWorkflows());
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Search workflow");

    final WorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOW_SEARCH), token, EModule.CORE,
        workflowSearchFilter.toEdo(), WorkflowListEdo.class, true);

    return new Workflow().fromEdoList(edoList.getWorkflows());
  }

}
