package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

public interface IWorkStrategyFactory {

  ISaveWorkflowStrategy selectSaveWorkStrategy(final Workflow workflow, final String token)
      throws WorkflowCustomizedException, MalformedURLException;

  ICreateWorkflowStrategy selectCreateWorkStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException;

}