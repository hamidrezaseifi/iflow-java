package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.ifow.workflow.bl.IWorkflowTypeDataService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowTypeDataService implements IWorkflowTypeDataService {
  
  private static final Logger logger = LoggerFactory.getLogger(WorkflowTypeDataService.class);
  
  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;
  
  public WorkflowTypeDataService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }
  
  @Override
  public WorkflowType getById(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    
    logger.debug("Request workflow data for id {}", id);
    
    final WorkflowTypeEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_BY_ID).toString(), EModule.CORE,
        WorkflowTypeEdo.class, true, id);
    
    return new WorkflowType().fromEdo(edo);
  }
  
  @Override
  public List<WorkflowType> getListByIdCompanyId(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);
    
    final ParameterizedTypeReference<List<WorkflowTypeEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowTypeEdo>>() {
    };
    
    final List<WorkflowTypeEdo> edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST_BY_COMPANY).toString(), EModule.CORE,
        typeRef, true, id);
    
    return new WorkflowType().fromEdoList(edoList);
  }
  
  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);
    
    final ParameterizedTypeReference<List<WorkflowTypeEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowTypeEdo>>() {
    };
    
    final List<WorkflowTypeEdo> edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST).toString(), EModule.CORE, idList,
        typeRef, true);
    
    return new WorkflowType().fromEdoList(edoList);
  }
  
  @Override
  public List<WorkflowTypeStep> getStepsById(final Long id) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", id);
    
    final ParameterizedTypeReference<List<WorkflowTypeStepEdo>> typeRef = new ParameterizedTypeReference<List<WorkflowTypeStepEdo>>() {
    };
    
    final List<WorkflowTypeStepEdo> edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW).toString(),
        EModule.CORE, typeRef, true, id);
    
    return new WorkflowTypeStep().fromEdoList(edoList);
  }
  
}
