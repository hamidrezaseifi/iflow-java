package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowTypeStepCoreConnectService implements IWorkflowTypeStepDataService {

  private static final Logger                            logger = LoggerFactory.getLogger(WorkflowTypeStepCoreConnectService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowTypeStepCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public WorkflowTypeStep getById(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow-step data for id {}", id);

    final WorkflowTypeStepEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_BY_ID), token, EModule.CORE,
        WorkflowTypeStepEdo.class, true, id);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for workflow id {}", workflowId);

    final WorkflowTypeStepListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW), token, EModule.CORE,
        WorkflowTypeStepListEdo.class, true, workflowId);

    return WorkflowModelEdoMapper.fromWorkflowTypeStepEdoList(edoList.getWorkflowTypeSteps());
  }

  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for id list {}", idList);

    final WorkflowTypeStepListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST), token, EModule.CORE, idList,
        WorkflowTypeStepListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowTypeStepEdoList(edoList.getWorkflowTypeSteps());
  }

}
