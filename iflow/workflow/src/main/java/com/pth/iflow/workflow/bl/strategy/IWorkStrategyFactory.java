package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public interface IWorkStrategyFactory {

  IWorkflowSaveStrategy selectWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
