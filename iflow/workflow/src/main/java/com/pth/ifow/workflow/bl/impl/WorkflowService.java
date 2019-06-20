package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowStepEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;
import com.pth.ifow.workflow.models.WorkflowStep;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowService implements IWorkflowService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowService.class);

  private final IRestTemplateCall restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  WorkflowService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public Workflow getById(final Long id) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Request workflow data for id {}", id);

    final WorkflowEdo edo = restTemplate.callRestGet(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_BY_ID).toString(), EModule.CORE,
        WorkflowEdo.class, true, id);

    return new Workflow().fromEdo(edo);
  }

  @Override
  public List<Workflow> getListByIdCompanyId(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);

    final ParameterizedTypeReference<List<WorkflowEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowEdo>>() {
    };

    final List<WorkflowEdo> edoList = restTemplate.callRestGet(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_LIST_BY_COMPANY).toString(), EModule.CORE,
        typeRef, true, id);

    return new Workflow().fromEdo(edoList);
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);

    final ParameterizedTypeReference<List<WorkflowEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowEdo>>() {
    };

    final List<WorkflowEdo> edoList = restTemplate.callRestPost(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_LIST).toString(), EModule.CORE, idList,
        typeRef, true);

    return new Workflow().fromEdo(edoList);
  }

  @Override
  public List<WorkflowStep> getStepsById(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", id);

    final ParameterizedTypeReference<List<WorkflowStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowStepEdo>>() {
    };

    final List<WorkflowStepEdo> edoList = restTemplate.callRestGet(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOWSTEP_READ_LIST_BY_WORKFLOW).toString(), EModule.CORE,
        typeRef, true, id);

    return new WorkflowStep().fromEdo(edoList);
  }

}
