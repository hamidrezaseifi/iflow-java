package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;
import com.pth.iflow.profile.service.IWorkflowMessageService;

@Service
public class WorkflowMessageService implements IWorkflowMessageService {

  private static final Logger                 logger = LoggerFactory.getLogger(WorkflowMessageService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public WorkflowMessageService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public List<WorkflowMessage> getWorkflowMessageListByUser(final Long userId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user workflow messages");

    final WorkflowMessageListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_WORKFLOWMESSAGE_READ_BY_USER(userId, 0)).toString(),
        EModule.CORE, WorkflowMessageListEdo.class, true);

    return ProfileModelEdoMapper.fromWorkflowMessageEdoList(edo.getWorkflowMessages());
  }

}
