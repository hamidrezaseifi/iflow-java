package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface IWorkflowSaveStrategy {

  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
