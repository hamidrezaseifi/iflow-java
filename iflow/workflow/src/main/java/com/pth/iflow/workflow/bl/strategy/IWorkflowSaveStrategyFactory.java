package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public interface IWorkflowSaveStrategyFactory<W extends IWorkflow> {

  IWorkflowSaveStrategy<W> selectSaveWorkStrategy(IWorkflowSaveRequest<W> workflowSaveRequest, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  IWorkflowSaveStrategy<W> selectValidationWorkStrategy(IWorkflowSaveRequest<W> workflowSaveRequest, Authentication authentication)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
