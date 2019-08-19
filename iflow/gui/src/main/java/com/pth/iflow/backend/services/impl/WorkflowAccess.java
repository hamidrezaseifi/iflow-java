package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.configurations.GuiConfiguration;
import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuiWorkflow;
import com.pth.iflow.backend.models.GuiWorkflowCreateRequest;
import com.pth.iflow.backend.models.GuiWorkflowSearchFilter;
import com.pth.iflow.backend.models.GuiWorkflowType;
import com.pth.iflow.backend.models.ui.GuiSessionUserInfo;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.backend.services.IWorkflowAccess;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;

@Service
public class WorkflowAccess implements IWorkflowAccess {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowAccess.class);

  private final IRestTemplateCall                   restTemplate;
  private final GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  private final GuiSessionUserInfo sessionUserInfo;

  final Map<Long, GuiWorkflowType> workflowTypeMap = new HashMap<>();

  public WorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
                        @Autowired final GuiConfiguration.ModuleAccessConfig moduleAccessConfig,
                        @Autowired final GuiSessionUserInfo sessionUserInfo,
                        @Autowired final IUserAccess userAccess) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public GuiWorkflow readWorkflow(final Long workflowId) throws GuiCustomizedException, MalformedURLException {
    logger.debug("Read workflow for id {}", workflowId);

    final WorkflowEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadWorkflowUri(workflowId),
                                                                  EModule.WORKFLOW,
                                                                  WorkflowEdo.class,
                                                                  this.sessionUserInfo.getToken(),
                                                                  true);

    return GuiWorkflow.fromEdo(responseEdo);
  }

  @Override
  public List<GuiWorkflow> createWorkflow(final GuiWorkflowCreateRequest createRequest)
                                                                                        throws GuiCustomizedException,
                                                                                        MalformedURLException {
    logger.debug("Create workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getCreateWorkflowUri(),
                                                                           EModule.WORKFLOW,
                                                                           createRequest.toEdo(),
                                                                           WorkflowListEdo.class,
                                                                           this.sessionUserInfo.getToken(),
                                                                           true);

    return GuiWorkflow.fromEdoList(responseListEdo.getWorkflows());
  }

  @Override
  public GuiWorkflow saveWorkflow(final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GuiWorkflow> readWorkflowList(final Long companyId) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GuiWorkflowType> readWorkflowTypeList(final Long companyId)
                                                                          throws GuiCustomizedException,
                                                                          MalformedURLException {
    logger.debug("Read workflow-type for company-id {}", companyId);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
                                                                          this.moduleAccessConfig.getReadWorkflowTypeListUri(companyId),
                                                                          EModule.WORKFLOW,
                                                                          WorkflowTypeListEdo.class,
                                                                          this.sessionUserInfo.getToken(),
                                                                          true);

    return new GuiWorkflowType().fromEdoList(responseEdo.getWorkflowTypes());
  }

  @Override
  public List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException,
                                                                                              MalformedURLException {
    logger.debug("Search workflow");

    final WorkflowListEdo responseListEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getSearchWorkflowUri(),
                                                                           EModule.WORKFLOW,
                                                                           workflowSearchFilter.toEdo(),
                                                                           WorkflowListEdo.class,
                                                                           this.sessionUserInfo.getToken(),
                                                                           true);

    return GuiWorkflow.fromEdoList(responseListEdo.getWorkflows());
  }

}
