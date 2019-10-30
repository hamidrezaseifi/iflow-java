package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowTypeStepProcessService implements IWorkflowTypeStepProcessService {

  private static final Logger                logger = LoggerFactory.getLogger(WorkflowTypeStepProcessService.class);

  private final IWorkflowTypeStepDataService workflowTypeStepDataService;

  private final ITokenValidator              tokenValidator;

  public WorkflowTypeStepProcessService(@Autowired final IWorkflowTypeStepDataService workflowTypeStepDataService,
      @Autowired final ITokenValidator tokenValidator) {
    this.workflowTypeStepDataService = workflowTypeStepDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public WorkflowTypeStep getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow-step data for id {}", identity);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getByIdentity(identity, token);
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowIdentity(final String workflowIdentity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for workflow id {}", workflowIdentity);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getListByWorkflowIdentity(workflowIdentity, token);
  }

  @Override
  public List<WorkflowTypeStep> getListByIdentityList(final Set<String> identityList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for id list");

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getListByIdentityList(identityList, token);
  }

}
