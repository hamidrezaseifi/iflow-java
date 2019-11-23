package com.pth.iflow.workflow.bl.impl.workflowservice.testthreetask;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class TestThreeTaskWorkflowCoreConnectService implements IWorkflowDataService<TestThreeTaskWorkflow> {

  private final Logger                                   logger = LoggerFactory.getLogger(getClass());

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public TestThreeTaskWorkflowCoreConnectService(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public TestThreeTaskWorkflow getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow data for identity {}", identity);

    final TestThreeTaskWorkflowEdo edo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_TESTTHREETASKWORKFLOW_BY_IDENTITY(identity)), token,
        EModule.CORE, TestThreeTaskWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListByIdentityList(final Set<String> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for id list {}", idList);

    final TestThreeTaskWorkflowListEdo edoList = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_TESTTHREETASKWORKFLOW_LIST()), token, EModule.CORE,
        idList, TestThreeTaskWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromTestThreeTaskWorkflowEdoList(edoList.getWorkflows());
  }

  @Override
  public TestThreeTaskWorkflow save(final TestThreeTaskWorkflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request save workflow");

    final TestThreeTaskWorkflowEdo edo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SAVE_TESTTHREETASKWORKFLOW()), token, EModule.CORE,
        WorkflowModelEdoMapper.toEdo(model), TestThreeTaskWorkflowEdo.class, true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company identity {}", identity);

    final TestThreeTaskWorkflowListEdo edoList = this.restTemplate.callRestGet(
        this.moduleAccessConfig
            .generateCoreUrl(IflowRestPaths.CoreModule.READ_TESTTHREETASKWORKFLOW_LIST_BY_USERIDENTITY(identity, status)),
        token, EModule.CORE, TestThreeTaskWorkflowListEdo.class, true);

    return WorkflowModelEdoMapper.fromTestThreeTaskWorkflowEdoList(edoList.getWorkflows());
  }

}
