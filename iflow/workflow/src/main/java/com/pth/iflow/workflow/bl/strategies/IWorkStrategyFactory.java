package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public interface IWorkStrategyFactory {

  IWorkflowStrategy selectWorkStrategy(final Workflow workflow, final String token)
      throws WorkflowCustomizedException, MalformedURLException;

}