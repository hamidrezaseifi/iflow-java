package com.pth.iflow.gui.services.impl.workflow.testthree;

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
import com.pth.iflow.common.models.IdentityListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class TestThreeTaskWorkflowAccess implements IWorkflowAccess<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> {

  private static final Logger                               logger = LoggerFactory.getLogger(TestThreeTaskWorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public TestThreeTaskWorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public TestThreeTaskWorkflow readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final TestThreeTaskWorkflowEdo responseEdo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.getReadTestThreeTaskWorkflowUri(workflowIdentity), EModule.WORKFLOW, TestThreeTaskWorkflowEdo.class, token,
        true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<TestThreeTaskWorkflow> createWorkflow(final TestThreeTaskWorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    final TestThreeTaskWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.getCreateTestThreeTaskWorkflowUri(), EModule.WORKFLOW, GuiModelEdoMapper.toEdo(createRequest),
        TestThreeTaskWorkflowListEdo.class, token, true);

    return GuiModelEdoMapper.fromTestThreeTaskWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public TestThreeTaskWorkflow saveWorkflow(final TestThreeTaskWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    final TestThreeTaskWorkflowEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSaveTestThreeTaskWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(request), TestThreeTaskWorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public void validateWorkflow(final TestThreeTaskWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    this.restTemplate.callRestPost(this.moduleAccessConfig.getValidateTestThreeTaskWorkflowUri(), EModule.WORKFLOW,
        GuiModelEdoMapper.toEdo(request), Void.class, token, true);

  }

  @Override
  public List<TestThreeTaskWorkflow> readWorkflowList(final Set<String> workflowIdentityList, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflow by identity list");

    final IdentityListEdo              listEdo         = new IdentityListEdo(workflowIdentityList);
    final TestThreeTaskWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.getReadTestThreeTaskWorkflowListByIdentityListUri(), EModule.WORKFLOW, listEdo,
        TestThreeTaskWorkflowListEdo.class, token, true);

    final List<TestThreeTaskWorkflow>  list            = GuiModelEdoMapper.fromTestThreeTaskWorkflowEdoList(responseListEdo.getWorkflows());

    return list;
  }

}
