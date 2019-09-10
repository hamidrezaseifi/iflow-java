package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;

import com.pth.iflow.workflow.bl.strategies.ICreateWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

public abstract class AbstractCreateWorkflowStrategy implements ICreateWorkflowStrategy {

  protected final WorkflowCreateRequest workflowCreateRequest;
  protected final String                token;
  private final IWorkStrategyFactory    workStrategyFactory;

  public AbstractCreateWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory) {
    super();
    this.workflowCreateRequest = workflowCreateRequest;
    this.token = token;
    this.workStrategyFactory = workStrategyFactory;
  }

  protected Workflow saveWorkflow(final Workflow workflow) throws WorkflowCustomizedException, MalformedURLException {
    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.token);

    final Workflow savedWorkflow = saveWorkflowStrategy.process();

    return savedWorkflow;
  }
}
