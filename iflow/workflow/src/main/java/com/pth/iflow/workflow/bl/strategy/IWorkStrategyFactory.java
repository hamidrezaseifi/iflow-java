package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public interface IWorkStrategyFactory {

  IWorkflowSaveStrategy selectSaveWorkStrategy(final IWorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  IWorkflowSaveStrategy selectValidationWorkStrategy(final IWorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
