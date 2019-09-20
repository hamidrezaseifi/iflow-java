package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface ISaveWorkflowStrategy {

  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
