package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;

public class CreateManualAssignWorkflowStrategy extends AbstractCreateWorkflowStrategy {

  public CreateManualAssignWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory) {
    super(workflowCreateRequest, token, workStrategyFactory);

  }

  @Override
  public List<Workflow> process() throws WorkflowCustomizedException, MalformedURLException {
    final Workflow workflow = this.workflowCreateRequest.getWorkflow();
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    final List<Workflow> result = new ArrayList<>();

    for (final Long assignedId : this.workflowCreateRequest.getAssignedUsers()) {
      workflow.setAssignTo(assignedId);
      result.add(this.saveWorkflow(workflow));
    }

    return result;
  }

}
