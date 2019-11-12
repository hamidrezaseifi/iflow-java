package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;

public interface IWorkflowSaveStrategy<W extends IWorkflow> {

  public void setup();

  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public W getSingleProceedWorkflow();

  public List<W> getProceedWorkflowList();
}
