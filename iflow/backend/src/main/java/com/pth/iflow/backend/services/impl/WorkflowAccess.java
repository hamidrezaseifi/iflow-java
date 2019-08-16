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
import com.pth.iflow.backend.models.BackendWorkflowCreateRequest;
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.models.ui.BackendSessionUserInfo;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IWorkflowAccess;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;

@Service
public class WorkflowAccess implements IWorkflowAccess {

  private static final Logger                           logger = LoggerFactory.getLogger(WorkflowAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final BackendConfiguration.ModuleAccessConfig moduleAccessConfig;

  private final BackendSessionUserInfo                  sessionUserInfo;

  public WorkflowAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final BackendConfiguration.ModuleAccessConfig moduleAccessConfig,
      @Autowired final BackendSessionUserInfo sessionUserInfo) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public BackendWorkflow readWorkflow(final Long workflowId) throws BackendCustomizedException, MalformedURLException {
    logger.debug("Read workflow for id {}", workflowId);

    final WorkflowEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadWorkflowUri(workflowId),
        EModule.PROFILE, WorkflowEdo.class, this.sessionUserInfo.getSessionId(), true);

    return new BackendWorkflow().fromEdo(responseEdo);
  }

  @Override
  public BackendWorkflow createWorkflow(final BackendWorkflowCreateRequest createRequest)
      throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BackendWorkflow saveWorkflow(final BackendWorkflow workflow) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendWorkflow> readWorkflowList(final Long companyId) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendWorkflowType> readWorkflowTypeList(final Long companyId)
      throws BackendCustomizedException, MalformedURLException {
    logger.debug("Read workflow-type for company-id {}", companyId);

    final WorkflowTypeListEdo responseEdo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.getReadWorkflowTypeListUri(companyId), EModule.PROFILE, WorkflowTypeListEdo.class,
        this.sessionUserInfo.getToken(), true);

    return new BackendWorkflowType().fromEdoList(responseEdo.getWorkflowTypes());
  }

}
