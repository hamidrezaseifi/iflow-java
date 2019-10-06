package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public interface IWorkflowSaveStrategyStep {

  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public boolean shouldProcess();
}
