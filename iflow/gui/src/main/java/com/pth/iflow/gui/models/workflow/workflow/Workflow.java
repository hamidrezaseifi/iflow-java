package com.pth.iflow.gui.models.workflow.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.base.WorkflowBase;

@JsonIgnoreProperties(value = { "isAssignTo" })
public class Workflow extends WorkflowBase implements IWorkflow {

  public static Workflow generateInitial(final String creatorId) {
    final Workflow newWorkflow = new Workflow();
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
