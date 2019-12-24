package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.steps.CollectAssignedUserIdListStep;
import com.pth.iflow.workflow.bl.strategy.steps.InitializeWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.InitializeWorkflowInitialActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.SaveWorkflowForAssignedUseresInCoreStep;
import com.pth.iflow.workflow.bl.strategy.steps.SendWorkflowOffersToProfileStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateAssignInSaveRequestStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateCurrentStepExistsInWorkflowTypeStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowActiveActionStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowDetailStrategyStep;
import com.pth.iflow.workflow.bl.strategy.steps.ValidateWorkflowTypeStepStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public class CreateManualAssignWorkflowStrategy<W extends IWorkflow> extends AbstractWorkflowSaveStrategy<W> {

  public CreateManualAssignWorkflowStrategy(final IWorkflowSaveRequest<W> workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IProfileCachDataDataService cachDataDataService, final IWorkflowDataService<W> workflowDataService,
      final IWorkflowPrepare<W> workflowPrepare)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    super(workflowCreateRequest, token, departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService,
        workflowPrepare);

  }

  @Override
  public void setup() {
    steps.add(new ValidateWorkflowDetailStrategyStep<W>(this));
    steps.add(new ValidateAssignInSaveRequestStrategyStep<W>(this));
    steps.add(new CollectAssignedUserIdListStep<W>(this));
    steps.add(new ValidateWorkflowTypeStepStrategyStep<W>(this));
    steps.add(new ValidateCurrentStepExistsInWorkflowTypeStrategyStep<W>(this));
    steps.add(new InitializeWorkflowInitialActionStrategyStep<W>(this));
    steps.add(new InitializeWorkflowActiveActionStrategyStep<W>(this));
    steps.add(new ValidateWorkflowActiveActionStrategyStep<W>(this));
    steps.add(new CollectAssignedUserIdListStep<W>(this));
    steps.add(new SaveWorkflowForAssignedUseresInCoreStep<W>(this));
    steps.add(new SendWorkflowOffersToProfileStep<W>(this));

  }

}
