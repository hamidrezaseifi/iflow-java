package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface ICreateWorkflowStrategy {

  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
