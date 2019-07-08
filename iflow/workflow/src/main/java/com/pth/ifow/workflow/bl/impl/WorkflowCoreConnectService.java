package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowDataService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowCoreConnectService implements IWorkflowDataService {
  
  private static final Logger logger = LoggerFactory.getLogger(WorkflowCoreConnectService.class);
  
  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;
  
  public WorkflowCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }
  
  @Override
  public Workflow getById(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    
    logger.debug("Request workflow data for id {}", id);
    
    final WorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_BY_ID).toString(), EModule.CORE, WorkflowEdo.class,
        true, id);
    
    return new Workflow().fromEdo(edo);
  }
  
  @Override
  public List<Workflow> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);
    
    final ParameterizedTypeReference<List<WorkflowEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowEdo>>() {
    };
    
    final List<WorkflowEdo> edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_LIST).toString(), EModule.CORE, idList, typeRef,
        true);
    
    return new Workflow().fromEdoList(edoList);
  }
  
  @Override
  public Workflow save(final Workflow model) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request save workflow {}", model.getTitle());
    
    final WorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOW_SAVE).toString(), EModule.CORE, model, WorkflowEdo.class,
        true);
    
    return new Workflow().fromEdo(edo);
  }
  
  @Override
  public List<Workflow> getListByTypeId(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);
    
    final ParameterizedTypeReference<List<WorkflowEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowEdo>>() {
    };
    
    final List<WorkflowEdo> edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_LIST_BY_TYPE).toString(), EModule.CORE, typeRef,
        true, id);
    
    return new Workflow().fromEdoList(edoList);
  }
  
  @Override
  public List<Workflow> getListForUser(final Long id, final int status) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);
    
    final ParameterizedTypeReference<List<WorkflowEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowEdo>>() {
    };
    
    final List<WorkflowEdo> edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOW_READ_LIST_BY_USER).toString(), EModule.CORE, typeRef,
        true, id, status);
    
    return new Workflow().fromEdoList(edoList);
  }
  
}
