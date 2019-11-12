package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public interface IWorkStrategyFactory<W extends IWorkflow> {

  IWorkflowSaveStrategy<W> selectSaveWorkStrategy(final IWorkflowSaveRequest<W> workflowSaveRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  IWorkflowSaveStrategy<W> selectValidationWorkStrategy(final IWorkflowSaveRequest<W> workflowSaveRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
