package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.WorkflowMessageListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;

@Service
public class WorkflowMessageAccess implements IWorkflowMessageAccess {

  private static final Logger                              logger = LoggerFactory.getLogger(WorkflowMessageAccess.class);

  private final IRestTemplateCall                          restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig moduleAccessConfig;

  public WorkflowMessageAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public List<WorkflowMessage> readUserMessages(final String companyIdentity, final String userId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("read messages for user");

    final WorkflowMessageListEdo responseListEdo = this.restTemplate.callRestGet(
        this.moduleAccessConfig.getReadUserWorkflowMessageListUri(companyIdentity, userId), EModule.WORKFLOW,
        WorkflowMessageListEdo.class, token, true);

    return GuiModelEdoMapper.fromWorkflowMessageEdoList(responseListEdo.getWorkflowMessages());
  }

  @Override
  public void callUserMessageReset(final String companyIdentity, final String userId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("reset messages for user");

    this.restTemplate.callRestGet(this.moduleAccessConfig.getCalUserWorkflowMessageResetUri(companyIdentity, userId), EModule.WORKFLOW,
        Void.class, token, true);

  }

}
