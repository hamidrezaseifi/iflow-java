package com.pth.iflow.workflow.bl.impl.workflowservice.workflow;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.workflow.WorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.Workflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowCoreConnectService implements IWorkflowDataService<Workflow> {

  private final Logger                                   logger = LoggerFactory.getLogger(getClass());

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
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOWLIST()), token, EModule.CORE, idList,
        WorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public Workflow save(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    throw new WorkflowCustomizedException("not implemented", EIFlowErrorType.SERVICE_NOT_IMPLEMENTED);
  }

  @Override
  public List<Workflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    throw new WorkflowCustomizedException("not implemented", EIFlowErrorType.SERVICE_NOT_IMPLEMENTED);
  }

}
