package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface IWorkflowSaveStrategy {

  public void setup();

  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public Workflow getSingleProceedWorkflow();

  public List<Workflow> getProceedWorkflowList();
}
