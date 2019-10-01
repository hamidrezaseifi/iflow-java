package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;

public interface IWorkflowProcessService {

  public List<Workflow> create(WorkflowSaveRequest model, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public Workflow save(WorkflowSaveRequest request, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public Workflow getById(Long id, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<Workflow> getListByTypeId(final Long id, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<Workflow> getListForUser(final Long id, int status, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<Workflow> getListByIdList(final List<Long> idList, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
