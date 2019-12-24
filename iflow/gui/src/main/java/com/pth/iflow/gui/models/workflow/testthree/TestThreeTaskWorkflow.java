package com.pth.iflow.gui.models.workflow.testthree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.base.WorkflowBase;

@JsonIgnoreProperties(value = { "isAssignTo" })
public class TestThreeTaskWorkflow extends WorkflowBase implements IWorkflow {

  @Override
  public EWorkflowType getWorkflowTypeEnum() {
    return EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE;
  }

  @Override
  public String getWorkflowTypeIdentity() {
    return this.getWorkflowTypeEnum().getIdentity();
  }

  public static TestThreeTaskWorkflow generateInitial(final String creatorId) {
    final TestThreeTaskWorkflow newWorkflow = new TestThreeTaskWorkflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setCreatedByIdentity(creatorId);
    newWorkflow.setControllerIdentity("");
    newWorkflow.setCurrentStepIdentity("");
    newWorkflow.setVersion(0);
    newWorkflow.setComments("");
    newWorkflow.setIdentity(EIdentity.NOT_SET.getIdentity());

    return newWorkflow;
  }

}
