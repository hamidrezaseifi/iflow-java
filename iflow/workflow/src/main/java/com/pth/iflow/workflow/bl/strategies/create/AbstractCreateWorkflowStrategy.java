package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.strategies.ICreateWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

public abstract class AbstractCreateWorkflowStrategy implements ICreateWorkflowStrategy {

  private final WorkflowCreateRequest  workflowCreateRequest;
  private final String                 token;
  private final IWorkStrategyFactory   workStrategyFactory;
  private final IDepartmentDataService departmentDataService;

  public AbstractCreateWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory, final IDepartmentDataService departmentDataService) {
    super();
    this.workflowCreateRequest = workflowCreateRequest;
    this.token = token;
    this.workStrategyFactory = workStrategyFactory;
    this.departmentDataService = departmentDataService;
  }

  protected Workflow saveWorkflow(final Workflow workflow)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.token);

    final Workflow savedWorkflow = saveWorkflowStrategy.process();

    return savedWorkflow;
  }

  public WorkflowCreateRequest getWorkflowCreateRequest() {
    return workflowCreateRequest;
  }

  public String getToken() {
    return token;
  }

  public IWorkStrategyFactory getWorkStrategyFactory() {
    return workStrategyFactory;
  }

  public IDepartmentDataService getDepartmentDataService() {
    return departmentDataService;
  }

}
