package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowTypeStep;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowTypeStepDataService implements IWorkflowTypeStepDataService {
  
  private static final Logger logger = LoggerFactory.getLogger(WorkflowTypeStepDataService.class);
  
  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;
  
  public WorkflowTypeStepDataService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }
  
  @Override
  public WorkflowTypeStep getById(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    
    logger.debug("Request workflow-step data for id {}", id);
    
    final WorkflowTypeStepEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPESTEP_READ_BY_ID).toString(), EModule.CORE,
        WorkflowTypeStepEdo.class, true, id);
    
    return new WorkflowTypeStep().fromEdo(edo);
  }
  
  @Override
  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", workflowId);
    
    final ParameterizedTypeReference<List<WorkflowTypeStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowTypeStepEdo>>() {
    };
    
    final List<WorkflowTypeStepEdo> edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW).toString(),
        EModule.CORE, typeRef, true, workflowId);
    
    return new WorkflowTypeStep().fromEdoList(edoList);
  }
  
  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for id list {}", idList);
    
    final ParameterizedTypeReference<List<WorkflowTypeStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowTypeStepEdo>>() {
    };
    
    final List<WorkflowTypeStepEdo> edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPESTEP_READ_LIST).toString(), EModule.CORE, idList,
        typeRef, true);
    
    return new WorkflowTypeStep().fromEdoList(edoList);
  }
  
}
