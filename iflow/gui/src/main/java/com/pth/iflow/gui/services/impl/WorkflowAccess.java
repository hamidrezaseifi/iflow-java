package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Service
public class WorkflowAccess implements IWorkflowAccess {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowAccess.class);

  private final IRestTemplateCall                   restTemplate;
  private final GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
                        @Autowired final GuiConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId, final String token) throws GuiCustomizedException, MalformedURLException {
    logger.debug("Read workflow for id {}", workflowId);

    final WorkflowEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadWorkflowUri(workflowId),
                                                                  EModule.WORKFLOW,
                                                                  WorkflowEdo.class,
                                                                  token,
                                                                  true);

    return GuiWorkflow.fromEdo(responseEdo);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest, final String token)
                                                                                                            throws GuiCustomizedException,
                                                                                                            MalformedURLException {
    logger.debug("Create workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateWorkflowUri(),
                                                                           EModule.WORKFLOW,
                                                                           createRequest.toEdo(),
                                                                           WorkflowListEdo.class,
                                                                           token,
                                                                           true);

    return GuiWorkflow.fromEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflow workflow, final String token) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final Long companyId, final String token)
                                                                                              throws GuiCustomizedException,
                                                                                              MalformedURLException {
    logger.debug("Read workflow-type for company-id {}", companyId);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
                                                                          this.moduleAccessConfig.getReadWorkflowTypeListUri(companyId),
                                                                          EModule.WORKFLOW,
                                                                          WorkflowTypeListEdo.class,
                                                                          token,
                                                                          true);

    return new GuiWorkflowType().fromEdoList(responseEdo.getWorkflowTypes());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter,
                                          final String token) throws GuiCustomizedException,
                                                              MalformedURLException {
    logger.debug("Search workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchWorkflowUri(),
                                                                           EModule.WORKFLOW,
                                                                           workflowSearchFilter.toEdo(),
                                                                           WorkflowListEdo.class,
                                                                           token,
                                                                           true);

    return GuiWorkflow.fromEdoList(responseListEdo.getWorkflows());
  }

}