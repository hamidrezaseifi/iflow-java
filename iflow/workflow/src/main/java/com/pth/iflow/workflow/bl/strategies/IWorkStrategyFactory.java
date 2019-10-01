package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public interface IWorkStrategyFactory {

  ISaveWorkflowStrategy selectSaveWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ICreateWorkflowStrategy selectCreateWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}