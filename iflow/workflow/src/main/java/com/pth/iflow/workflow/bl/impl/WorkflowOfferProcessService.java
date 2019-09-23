package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowOfferDataService;
import com.pth.iflow.workflow.bl.IWorkflowOfferProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowOffer;

@Service
public class WorkflowOfferProcessService implements IWorkflowOfferProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowOfferDataService workflowOfferDataService;

  private final ITokenValidator tokenValidator;

  public WorkflowOfferProcessService(@Autowired final IWorkflowOfferDataService workflowOfferDataService,
                                     @Autowired final ITokenValidator tokenValidator) {

    this.workflowOfferDataService = workflowOfferDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public List<WorkflowOffer> getListForUser(final Long userId, final Long lastId, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Load workflow-offers for user {} with token {}", userId, token);

    this.tokenValidator.isTokenValid(token);
    return this.workflowOfferDataService.getListForUser(userId, lastId, status, token);
  }

}
