package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;

public interface IWorkflowDataService<W extends IWorkflow> {

  public W save(W model, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public W getByIdentity(String identity, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListForUser(String identity, int status, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<W> getListByIdentityList(Set<String> idList, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
