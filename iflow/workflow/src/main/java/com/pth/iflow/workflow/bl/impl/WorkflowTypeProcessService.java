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
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowTypeProcessService implements IWorkflowTypeProcessService {

  private static final Logger            logger = LoggerFactory.getLogger(WorkflowTypeProcessService.class);

  private final IWorkflowTypeDataService workflowTypeDataService;

  private final ITokenValidator          tokenValidator;

  public WorkflowTypeProcessService(@Autowired final IWorkflowTypeDataService workflowTypeDataService,
      @Autowired final ITokenValidator tokenValidator) {
    this.workflowTypeDataService = workflowTypeDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public WorkflowType getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request workflow data for id {}", identity);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getByIdentity(identity, token);

  }

  @Override
  public List<WorkflowType> getListByCompanyIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for company id {}", identity);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getListByCompanyIdentity(identity, token);
  }

  @Override
  public List<WorkflowType> getListByIdentityList(final Set<String> identityList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow list for id list {}");

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getListByIdentityList(identityList, token);
  }

  @Override
  public List<WorkflowTypeStep> getStepsByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request workflow-step list for workflow id {}", identity);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getStepsByIdentity(identity, token);
  }

}
