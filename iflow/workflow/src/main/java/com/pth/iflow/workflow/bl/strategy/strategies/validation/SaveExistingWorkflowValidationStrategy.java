package com.pth.iflow.workflow.bl.strategy.strategies.validation;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateCurrentStepExistsInWorkflowTypeStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowAssignedUserStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowDetailStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowTypeStepStrategyStep;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class SaveExistingWorkflowValidationStrategy extends AbstractWorkflowSaveStrategy {

  public SaveExistingWorkflowValidationStrategy(final WorkflowSaveRequest workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IProfileCachDataDataService cachDataDataService, final IWorkflowDataService workflowDataService)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    super(workflowCreateRequest, token, departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);

  }

  @Override
  public void setup() {
    steps.add(new ValidateWorkflowDetailStrategyStep(this));
    steps.add(new ValidateWorkflowActiveActionStrategyStep(this));
    steps.add(new ValidateWorkflowTypeStepStrategyStep(this));
    steps.add(new ValidateCurrentStepExistsInWorkflowTypeStrategyStep(this));
    steps.add(new ValidateWorkflowAssignedUserStrategyStep(this));
  }

}
