package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;

public class CreateOfferlAssignWorkflowStrategy extends AbstractCreateWorkflowStrategy {

  public CreateOfferlAssignWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory, final IDepartmentDataService departmentDataService,
      final IWorkflowMessageDataService workflowMessageDataService, final ICachDataDataService cachDataDataService,
      final WorkflowType workflowType) {
    super(workflowCreateRequest, token, workStrategyFactory, departmentDataService, workflowMessageDataService, cachDataDataService,
        workflowType);

  }

  @Override
  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow workflow = this.getWorkflowCreateRequest().getWorkflow();
    workflow.setStatus(EWorkflowStatus.OFFERING);

    verifyAssigns();

    workflow.setAssignTo(null);
    final WorkflowSaveRequest saveRequest = creaeNotAssignedWorkflowSaveRequest(workflow);

    final Workflow savedWorkflow = this.saveWorkflow(saveRequest);

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

      if (assign.getItemType() == EAssignType.DEPARTMENTGROUP) {
        final List<User> departmentUserIds = this.getDepartmentDataService().getUserListByDepartmentGroupId(assign.getItemId(),
            this.getToken());
        assignedUsers.addAll(departmentUserIds.stream().map(u -> u.getId()).collect(Collectors.toSet()));
      }
    }

    for (final Long userId : assignedUsers) {

      createWorkflowMessage(savedWorkflow.getId(), savedWorkflow.getCreatedBy(), userId);

    }

    resetUserListCachData(getWorkflowType().getCompanyId(), assignedUsers);
    return Arrays.asList(savedWorkflow);
  }

}
