package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowMessage;

@Service
public class WorkflowMessageProcessService implements IWorkflowMessageProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowMessageDataService workflowMessageDataService;

  private final ITokenValidator tokenValidator;

  public WorkflowMessageProcessService(@Autowired final IWorkflowMessageDataService workflowMessageDataService,
                                       @Autowired final ITokenValidator tokenValidator) {

    this.workflowMessageDataService = workflowMessageDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public List<WorkflowMessage> getListForUser(final Long userId, final Long lastId, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Load workflow-messages for user {} with token {}", userId, token);

    this.tokenValidator.isTokenValid(token);
    return this.workflowMessageDataService.getListForUser(userId, lastId, status, token);
  }

}
