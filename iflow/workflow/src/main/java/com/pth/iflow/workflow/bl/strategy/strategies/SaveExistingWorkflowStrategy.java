package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.steps.SaveWorkflowInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateCurrentStepExistsInWorkflowTypeStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowAssignedUserStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowTypeStepStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class SaveExistingWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public SaveExistingWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest,
                                      final String token,
                                      final IWorkStrategyFactory workStrategyFactory,
                                      final IDepartmentDataService departmentDataService,
                                      final IWorkflowMessageDataService workflowMessageDataService,
                                      final ICachDataDataService cachDataDataService,
                                      final IWorkflowDataService workflowDataService) {
    super(workflowCreateRequest,
          token,
          workStrategyFactory,
          departmentDataService,
          workflowMessageDataService,
          cachDataDataService,
          workflowDataService);

  }

  @Override
  public void setup() {
    steps.add(new ValidateWorkflowActiveActionStrategyStep(this));
    steps.add(new ValidateWorkflowTypeStepStrategyStep(this));
    steps.add(new ValidateCurrentStepExistsInWorkflowTypeStrategyStep(this));
    steps.add(new ValidateWorkflowAssignedUserStrategyStep(this));
    steps.add(new SaveWorkflowInCoreStep(this));

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    this.getFirstStep().process();
  }

  @Override
  public Workflow getSingleProceedWorkflow() {
    return getSavedSingleWorkflow();
  }

  @Override
  public List<Workflow> getProceedWorkflowList() {
    return savedWorkflowList;
  }

}
