package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.steps.AssignWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.CollectAssignedUserIdListStep;
import com.pth.iflow.workflow.bl.strategy.steps.InitializeWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.PrepareDoneActiveActionStep;
import com.pth.iflow.workflow.bl.strategy.steps.SaveWorkflowInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.SaveWorkflowOfferForAssignedUseresInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.SelectWorkflowNextStepStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.SelectWorkflowStatusStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.SendWorkflowOffersToProfileStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateAssignInSaveRequestStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateCurrentStepExistsInWorkflowTypeStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowAssignedUserStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowTypeStepStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class DoneExistingWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public DoneExistingWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IProfileCachDataDataService cachDataDataService, final IWorkflowDataService workflowDataService)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    super(workflowCreateRequest, token, departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);

  }

  @Override
  public void setup() {

    steps.add(new ValidateWorkflowActiveActionStrategyStep(this));
    steps.add(new ValidateWorkflowAssignedUserStrategyStep(this));
    steps.add(new ValidateAssignInSaveRequestStrategyStep(this));
    steps.add(new ValidateWorkflowTypeStepStrategyStep(this));
    steps.add(new ValidateCurrentStepExistsInWorkflowTypeStrategyStep(this));
    steps.add(new PrepareDoneActiveActionStep(this));
    steps.add(new SelectWorkflowNextStepStrategyStep(this));
    steps.add(new InitializeWorkflowActiveActionStrategyStep(this));
    steps.add(new SelectWorkflowStatusStrategyStep(this));
    steps.add(new CollectAssignedUserIdListStep(this));
    steps.add(new AssignWorkflowActiveActionStrategyStep(this));
    steps.add(new SaveWorkflowInCoreStep(this));
    steps.add(new ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep(this));
    steps.add(new SaveWorkflowOfferForAssignedUseresInCoreStep(this));
    steps.add(new SendWorkflowOffersToProfileStep(this));

  }

}
