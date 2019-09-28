package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

public class CreateOfferlAssignWorkflowStrategy extends AbstractCreateWorkflowStrategy {

  public CreateOfferlAssignWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory, final IDepartmentDataService departmentDataService) {
    super(workflowCreateRequest, token, workStrategyFactory, departmentDataService);

  }

  @Override
  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow workflow = this.getWorkflowCreateRequest().getWorkflow();
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    verifyAssigns();

    final List<Workflow> result = new ArrayList<>();

    final Set<Long> assignedUsers = new HashSet<>();

    for (final AssignItem assign : this.getWorkflowCreateRequest().getAssigns()) {

      if (assign.getItemType() == EAssignType.USER) {
        assignedUsers.add(assign.getItemId());
      }

      if (assign.getItemType() == EAssignType.DEPARTMENT) {
        final List<User> departmentUserIds = this.getDepartmentDataService().getUserListByDepartmentId(assign.getItemId(),
            this.getToken());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }
    }

    for (final Long userId : assignedUsers) {
      workflow.setAssignTo(userId);
      result.add(this.saveWorkflow(workflow));
    }

    return result;
  }

}
