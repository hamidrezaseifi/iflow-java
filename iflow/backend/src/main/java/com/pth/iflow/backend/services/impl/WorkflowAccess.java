package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.configurations.BackendConfiguration;
import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendWorkflow;
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IWorkflowAccess;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;

@Service
public class WorkflowAccess implements IWorkflowAccess {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final BackendConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
                        @Autowired final BackendConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public BackendWorkflow readWorkflow(final Long workflowId, final String token) throws BackendCustomizedException, MalformedURLException {
    logger.debug("Read workflow for id {}", workflowId);

    final TokenProfileRequestEdo profileRequest = new TokenProfileRequestEdo();
    profileRequest.setToken(token);

    final WorkflowEdo responseEdo = this.restTemplate.callRestGet(
                                                                  this.moduleAccessConfig.generateWorkflowUrl(IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_ID),
                                                                  token,
                                                                  EModule.PROFILE,
                                                                  WorkflowEdo.class,
                                                                  true,
                                                                  workflowId);

    return new BackendWorkflow().fromEdo(responseEdo);
  }

  @Override
  public BackendWorkflow saveWorkflow(final BackendWorkflow workflow, final String token) throws BackendCustomizedException,
                                                                                          MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendWorkflow> readWorkflowList(final Long companyId, final String token)
                                                                                          throws BackendCustomizedException,
                                                                                          MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendWorkflowType> readWorkflowTypeList(final Long companyId, final String token)
                                                                                                  throws BackendCustomizedException,
                                                                                                  MalformedURLException {
    logger.debug("Read workflow-type for company-id {}", companyId);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
                                                                          this.moduleAccessConfig.generateWorkflowUrl(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST_BY_COMPANY),
                                                                          token,
                                                                          EModule.PROFILE,
                                                                          WorkflowTypeListEdo.class,
                                                                          true,
                                                                          companyId);

    return new BackendWorkflowType().fromEdoList(responseEdo.getWorkflowTypes());
  }

}
