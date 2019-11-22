package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class WorkflowMessageDataService implements IWorkflowMessageDataService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowMessageDataService.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public WorkflowMessageDataService(@Autowired final IRestTemplateCall restTemplate,
                                    @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public List<WorkflowMessage> getListForUser(final String userIdentity, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow message list for user id {}", userIdentity);

    final WorkflowMessageListEdo edoList = this.restTemplate.callRestGet(
                                                                         this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOWMESSAGE_READ_BY_USER(userIdentity,
                                                                                                                                                                             status)),
                                                                         token,
                                                                         EModule.CORE,
                                                                         WorkflowMessageListEdo.class,
                                                                         true);

    return WorkflowModelEdoMapper.fromWorkflowMessageEdoList(edoList.getWorkflowMessages());
  }

  @Override
  public WorkflowMessage save(final WorkflowMessage message, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow message ");

    final WorkflowMessageEdo edo = this.restTemplate.callRestPost(
                                                                  this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule.SAVE_WORKFLOWMESSAGE()),
                                                                  token,
                                                                  EModule.CORE,
                                                                  WorkflowModelEdoMapper.toEdo(message),
                                                                  WorkflowMessageEdo.class,
                                                                  true);

    return WorkflowModelEdoMapper.fromEdo(edo);
  }

  @Override
  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow message ");

    this.restTemplate.callRestGet(
                                  this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule
                                                                                                   .CHANGE_WORKFLOWMESSAGE_WORKFLOWMESSAGE_STAUS(workflowIdentity,
                                                                                                                                                 stepIdentity,
                                                                                                                                                 EWorkflowIdentity.NOT_SET.getIdentity(),
                                                                                                                                                 status.getValue())),
                                  token,
                                  EModule.CORE,
                                  Void.class,
                                  true);

  }

  @Override
  public void updateUserAndWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String userIdentity, final EWorkflowMessageStatus status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Save workflow message ");

    this.restTemplate.callRestGet(
                                  this.moduleAccessConfig.generateCoreUrl(IflowRestPaths.CoreModule
                                                                                                   .CHANGE_WORKFLOWMESSAGE_WORKFLOWMESSAGE_STAUS(workflowIdentity,
                                                                                                                                                 stepIdentity,
                                                                                                                                                 userIdentity,
                                                                                                                                                 status.getValue())),
                                  token,
                                  EModule.CORE,
                                  Void.class,
                                  true);

  }

}
