package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowTypeProcessService implements IWorkflowTypeProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowTypeProcessService.class);

  private final IWorkflowTypeDataService workflowTypeDataService;

  private final ITokenValidator tokenValidator;

  public WorkflowTypeProcessService(@Autowired final IWorkflowTypeDataService workflowTypeDataService,
      @Autowired final ITokenValidator tokenValidator) {
    this.workflowTypeDataService = workflowTypeDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public WorkflowType getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Request workflow data for id {}", id);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getById(id, token);

  }

  @Override
  public List<WorkflowType> getListByIdCompanyId(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for company id {}", id);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getListByIdCompanyId(id, token);
  }

  @Override
  public List<WorkflowType> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow list for id list {}", idList);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getListByIdList(idList, token);
  }

  @Override
  public List<WorkflowTypeStep> getStepsById(final Long id, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Request workflow-step list for workflow id {}", id);

    this.tokenValidator.isTokenValid(token);

    return this.workflowTypeDataService.getStepsById(id, token);
  }

}
