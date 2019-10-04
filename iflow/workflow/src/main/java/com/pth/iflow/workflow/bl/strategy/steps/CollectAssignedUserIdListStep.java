package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;

public class CollectAssignedUserIdListStep extends AbstractWorkflowSaveStrategyStep {

  public CollectAssignedUserIdListStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();

    final Set<Long> assignedUsers = new HashSet<>();

    for (final AssignItem assign : processingWorkflowSaveRequest.getAssigns()) {

      if (assign.getItemType() == EAssignType.USER) {
        assignedUsers.add(assign.getItemId());
      }

      if (assign.getItemType() == EAssignType.DEPARTMENT) {
        final List<User> departmentUserIds = this.getWorkflowSaveStrategy().getDepartmentUserList(assign.getItemId());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }

      if (assign.getItemType() == EAssignType.DEPARTMENTGROUP) {
        final List<User> departmentUserIds = this.getWorkflowSaveStrategy().getDepartmentGroupUserList(assign.getItemId());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }
    }

    this.getWorkflowSaveStrategy().setAssignedUsers(assignedUsers);

  }

  @Override
  public boolean shouldProcess() {
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    return this.getWorkflowSaveStrategy().IsWorkflowCurrectStepChanged() && processingWorkflowType.isAssignTypeOffering();
  }

}
