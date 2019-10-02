package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class CreateManualAssignWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public CreateManualAssignWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest,
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
  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow workflow = this.processingWorkflowSaveRequest.getWorkflow();
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    verifyAssigns();

    final List<Workflow> result = new ArrayList<>();

    final Set<Long> assignedUsers = new HashSet<>();

    for (final AssignItem assign : this.processingWorkflowSaveRequest.getAssigns()) {

      if (assign.getItemType() == EAssignType.USER) {
        assignedUsers.add(assign.getItemId());
      }

      if (assign.getItemType() == EAssignType.DEPARTMENT) {
        final List<User> departmentUserIds = this.getDepartmentDataService()
                                                 .getUserListByDepartmentId(assign.getItemId(),
                                                                            this.getToken());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }

      if (assign.getItemType() == EAssignType.DEPARTMENTGROUP) {
        final List<User> departmentUserIds = this.getDepartmentDataService()
                                                 .getUserListByDepartmentGroupId(assign.getItemId(),
                                                                                 this.getToken());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }
    }

    for (final Long userId : assignedUsers) {
      workflow.setActiveActionAssignTo(userId);

      final WorkflowSaveRequest saveRequest = creaeOneAssignedWorkflowSaveRequest(workflow, userId);
      result.addAll(this.saveWorkflow(saveRequest));
    }

    return result;
  }

}
