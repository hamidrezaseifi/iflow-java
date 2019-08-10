package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowTypeCoreConnectService implements IWorkflowTypeDataService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowTypeCoreConnectService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowTypeCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public WorkflowType getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Request workflow data for id {}", id);

    final WorkflowTypeEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_BY_ID), token, EModule.CORE,
        WorkflowTypeEdo.class, true, id);

    return new WorkflowType().fromEdo(edo);
  }

  @Override
  public List<WorkflowType> getListByIdCompanyId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);

    final WorkflowTypeListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST_BY_COMPANY), token, EModule.CORE,
        WorkflowTypeListEdo.class, true, id);

    return new WorkflowType().fromEdoList(edoList.getWorkflowTypes());
  }

  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);

    final WorkflowTypeListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST), token, EModule.CORE, idList,
        WorkflowTypeListEdo.class, true);

    return new WorkflowType().fromEdoList(edoList.getWorkflowTypes());
  }

  @Override
  public List<WorkflowTypeStep> getStepsById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", id);

    final WorkflowTypeStepListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModul.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW), token,
        EModule.CORE, WorkflowTypeStepListEdo.class, true, id);

    return new WorkflowTypeStep().fromEdoList(edoList.getWorkflowTypeSteps());
  }

}