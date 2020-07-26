package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public interface IWorkflowProcessService<W extends IWorkflow> {

  public List<W> create(IWorkflowSaveRequest<W> model, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public W save(IWorkflowSaveRequest<W> request, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public W getByIdentity(String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListForUser(final String identity, int status, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListByIdentityList(final Set<String> identityList, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void validate(IWorkflowSaveRequest<W> model, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
