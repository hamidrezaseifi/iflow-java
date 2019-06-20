package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowStepEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowStepService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowStep;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowStepService implements IWorkflowStepService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowStepService.class);

  private final IRestTemplateCall restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  WorkflowStepService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public WorkflowStep getById(final Long id) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Request workflow-step data for id {}", id);

    final WorkflowStepEdo edo = restTemplate.callRestGet(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOWSTEP_READ_BY_ID).toString(), EModule.CORE,
        WorkflowStepEdo.class, true, id);

    return new WorkflowStep().fromEdo(edo);
  }

  @Override
  public List<WorkflowStep> getListByWorkflowId(final Long workflowId) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", workflowId);

    final ParameterizedTypeReference<List<WorkflowStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowStepEdo>>() {
    };

    final List<WorkflowStepEdo> edoList = restTemplate.callRestGet(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOWSTEP_READ_LIST_BY_WORKFLOW).toString(), EModule.CORE,
        typeRef, true, workflowId);

    return new WorkflowStep().fromEdo(edoList);
  }

  @Override
  public List<WorkflowStep> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for id list {}", idList);

    final ParameterizedTypeReference<List<WorkflowStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowStepEdo>>() {
    };

    final List<WorkflowStepEdo> edoList = restTemplate.callRestPost(
        moduleAccessConfig.generateCoreSunUrlUrl(IflowRestPaths.CoreModul.WORKFLOWSTEP_READ_LIST).toString(), EModule.CORE, idList,
        typeRef, true);

    return new WorkflowStep().fromEdo(edoList);
  }

}
