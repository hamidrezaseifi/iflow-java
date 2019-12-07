package com.pth.iflow.workflow.bl.impl.workflowservice.workflow;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.Workflow;

@Service
public class WorkflowProcessService implements IWorkflowProcessService<Workflow> {

  private final Logger                         logger = LoggerFactory.getLogger(getClass());

  private final IWorkflowDataService<Workflow> invoiceWorkflowDataService;

  private final ITokenValidator                tokenValidator;

  private final IWorkflowPrepare<Workflow>     workflowPrepare;

  public WorkflowProcessService(@Autowired final IWorkflowDataService<Workflow> invoiceWorkflowDataService,
      @Autowired final ITokenValidator tokenValidator, @Autowired final IWorkflowPrepare<Workflow> workflowPrepare) {

    this.invoiceWorkflowDataService = invoiceWorkflowDataService;
    this.tokenValidator = tokenValidator;
    this.workflowPrepare = workflowPrepare;
  }

  @Override
  public List<Workflow> create(final IWorkflowSaveRequest<Workflow> request, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    throw new WorkflowCustomizedException("not implemented", EIFlowErrorType.SERVICE_NOT_IMPLEMENTED);
  }

  @Override
  public Workflow save(final IWorkflowSaveRequest<Workflow> request, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    throw new WorkflowCustomizedException("not implemented", EIFlowErrorType.SERVICE_NOT_IMPLEMENTED);
  }

  @Override
  public void validate(final IWorkflowSaveRequest<Workflow> request, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    throw new WorkflowCustomizedException("not implemented", EIFlowErrorType.SERVICE_NOT_IMPLEMENTED);
  }

  @Override
  public Workflow getByIdentity(final String identity, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by id {} with token {}", identity, token);

    this.tokenCanReadWorkflow(identity, token);
    final Workflow workflow = this.invoiceWorkflowDataService.getByIdentity(identity, token);

    return workflowPrepare.prepareWorkflow(token, workflow);
  }

  @Override
  public List<Workflow> getListForUser(final String identity, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", identity, status, token);

    final List<Workflow> list = this.invoiceWorkflowDataService.getListForUser(identity, status, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getIdentity()).collect(Collectors.toSet()), token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListByIdentityList(final Set<String> identityList, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow list by id list with token {}", token);

    this.tokenCanReadWorkflowList(identityList, token);

    final List<Workflow> list = this.invoiceWorkflowDataService.getListByIdentityList(identityList, token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  private boolean tokenCanReadWorkflow(final String workflowId, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented

    this.tokenValidator.isTokenValid(token);

    return true;
  }

  private boolean tokenCanSaveWorkflow(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token save access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanReadWorkflowList(final Set<String> list, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanSearchWorkflowList(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

}
