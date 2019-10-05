package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.steps.ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.PrepareArchivingWorkflowStep;
import com.pth.iflow.workflow.bl.strategy.steps.SaveWorkflowInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateCurrentStepExistsInWorkflowTypeStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowTypeStepStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ArchivingWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public ArchivingWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IProfileCachDataDataService cachDataDataService, final IWorkflowDataService workflowDataService)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    super(workflowCreateRequest, token, departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);

  }

  @Override
  public void setup() {
    steps.add(new PrepareArchivingWorkflowStep(this));
    steps.add(new ValidateWorkflowTypeStepStrategyStep(this));
    steps.add(new ValidateCurrentStepExistsInWorkflowTypeStrategyStep(this));
    steps.add(new SaveWorkflowInCoreStep(this));
    steps.add(new ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep(this));

  }

}
