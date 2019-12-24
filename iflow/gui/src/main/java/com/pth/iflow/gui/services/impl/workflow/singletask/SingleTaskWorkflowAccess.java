package com.pth.iflow.gui.services.impl.workflow.singletask;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class SingleTaskWorkflowAccess implements IWorkflowAccess<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> {

  private static final Logger                               logger = LoggerFactory.getLogger(SingleTaskWorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public SingleTaskWorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public SingleTaskWorkflow readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final SingleTaskWorkflowEdo responseEdo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.getReadSingleTaskWorkflowUri(workflowIdentity), EModule.WORKFLOW, SingleTaskWorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<SingleTaskWorkflow> createWorkflow(final SingleTaskWorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    final SingleTaskWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateSingleTaskWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(createRequest), SingleTaskWorkflowListEdo.class, token, true);

    return GuiModelEdoMapper.fromSingleTaskWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public SingleTaskWorkflow saveWorkflow(final SingleTaskWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    final SingleTaskWorkflowEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSaveSingleTaskWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(request), SingleTaskWorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public void validateWorkflow(final SingleTaskWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    this.restTemplate.callRestPost(this.moduleAccessConfig.getValidateSingleTaskWorkflowUri(), EModule.WORKFLOW,
        GuiModelEdoMapper.toEdo(request), Void.class, token, true);

  }

  @Override
  public List<SingleTaskWorkflow> readWorkflowList(final Set<String> workflowIdentityList, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflow by identity list");

    final IdentityListEdo           listEdo         = new IdentityListEdo(workflowIdentityList);
    final SingleTaskWorkflowListEdo responseListEdo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.getReadSingleTaskWorkflowListByIdentityListUri(), EModule.WORKFLOW, listEdo, SingleTaskWorkflowListEdo.class,
        token, true);

    final List<SingleTaskWorkflow>  list            = GuiModelEdoMapper.fromSingleTaskWorkflowEdoList(responseListEdo.getWorkflows());

    return list;
  }

}
