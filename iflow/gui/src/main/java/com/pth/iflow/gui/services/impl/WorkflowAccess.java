package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class WorkflowAccess implements IWorkflowAccess {

  private static final Logger                               logger = LoggerFactory.getLogger(WorkflowAccess.class);

  private final IRestTemplateCall                           restTemplate;
  private final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig;

  public WorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.WorkflowModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public GuiWorkflow readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadWorkflowUri(workflowIdentity),
        EModule.WORKFLOW, WorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Create workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(createRequest), WorkflowListEdo.class, token, true);

    return GuiModelEdoMapper.fromWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    final WorkflowEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSaveWorkflowUri(), EModule.WORKFLOW,
        GuiModelEdoMapper.toEdo(request), WorkflowEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final String companyIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read workflow-type for company-id {}", companyIdentity);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.getReadWorkflowTypeListUri(companyIdentity), EModule.WORKFLOW, WorkflowTypeListEdo.class, token, true);

    return GuiModelEdoMapper.fromWorkflowTypeEdoList(responseEdo.getWorkflowTypes());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Search workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchWorkflowUri(),
        EModule.WORKFLOW, GuiModelEdoMapper.toEdo(workflowSearchFilter), WorkflowListEdo.class, token, true);

    return GuiModelEdoMapper.fromWorkflowEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public void validateWorkflow(final GuiWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("save workflow");

    this.restTemplate.callRestPost(this.moduleAccessConfig.getValidateWorkflowUri(), EModule.WORKFLOW,
        GuiModelEdoMapper.toEdo(request), Void.class, token, true);

  }

}
