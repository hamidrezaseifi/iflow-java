package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
import com.pth.iflow.workflow.models.WorkflowMessage;

public class CreateOfferlAssignWorkflowStrategy extends AbstractCreateWorkflowStrategy {

  public CreateOfferlAssignWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory, final IDepartmentDataService departmentDataService,
      final IWorkflowMessageDataService workflowMessageDataService) {
    super(workflowCreateRequest, token, workStrategyFactory, departmentDataService, workflowMessageDataService);

  }

  @Override
  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow workflow = this.getWorkflowCreateRequest().getWorkflow();
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    verifyAssigns();

    workflow.setAssignTo(null);
    final Workflow savedWorkflow = this.saveWorkflow(workflow);

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

      final WorkflowMessage message = new WorkflowMessage();
      message.setCreatedBy(savedWorkflow.getCreatedBy());
      message.setExpireDays(this.getWorkflowCreateRequest().getExpireDays());
      message.setMessage("Offering Workflow Message");
      message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
      message.setStatus(EWorkflowMessageStatus.OFFERING);
      message.setUserId(userId);
      message.setWorkflowId(savedWorkflow.getId());
      getWorkflowMessageDataService().save(message, this.getToken());

    }

    getWorkflowMessageDataService();

    return Arrays.asList(savedWorkflow);
  }

}
