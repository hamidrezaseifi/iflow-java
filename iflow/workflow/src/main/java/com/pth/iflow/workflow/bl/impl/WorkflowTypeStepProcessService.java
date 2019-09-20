package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

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
  public WorkflowTypeStep getById(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow-step data for id {}", id);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getById(id, token);
  }

  @Override
  public List<WorkflowTypeStep> getListByWorkflowId(final Long workflowId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for workflow id {}", workflowId);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getListByWorkflowId(workflowId, token);
  }

  @Override
  public List<WorkflowTypeStep> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for id list {}", idList);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeStepDataService.getListByIdList(idList, token);
  }

}
