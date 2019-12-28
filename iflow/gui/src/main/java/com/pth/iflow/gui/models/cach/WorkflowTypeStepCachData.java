package com.pth.iflow.gui.models.cach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pth.iflow.gui.models.WorkflowMessage;

public class WorkflowTypeStepCachData {

  private final Map<String, WorkflowMessage> workflowMessages = new HashMap<>();
  private String stepId;

  public WorkflowTypeStepCachData(final String stepId) {

    this.stepId = stepId;
  }

  public Map<String, WorkflowMessage> getWorkflowMessages() {

    this.removeAllExpired();
    return this.workflowMessages;
  }

  public List<WorkflowMessage> getWorkflowMessagesList() {

    this.removeAllExpired();
    return this.workflowMessages.values().stream().collect(Collectors.toList());
  }

  public void setWorkflowMessages(final List<WorkflowMessage> workflowMessages) {

    this.workflowMessages.clear();
    if (workflowMessages != null) {

      for (final WorkflowMessage workflowMessage : workflowMessages) {
        this.workflowMessages.put(workflowMessage.getIdentityPath(), workflowMessage);
      }

    }
    this.removeAllExpired();
  }

  public void addWorkflowMessage(final WorkflowMessage workflowMessage) {

    if (workflowMessage.isNotExpired()) {
      this.workflowMessages.put(workflowMessage.getIdentityPath(), workflowMessage);
    }
  }

  public void addWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {

    this.removeAllExpired();
    for (final WorkflowMessage workflowMessage : workflowMessageList) {
      this.addWorkflowMessage(workflowMessage);
    }
  }

  public String getStepId() {

    return this.stepId;
  }

  public void setStepId(final String stepId) {

    this.stepId = stepId;
  }

  public boolean isStepId(final String stepId) {

    return this.stepId == stepId;
  }

  public void removeAllExpired() {

    final List<String> expireds = this.workflowMessages
        .keySet()
        .stream()
        .filter(id -> this.workflowMessages.get(id).isExpired())
        .collect(Collectors.toList());

    for (final String id : expireds) {
      this.workflowMessages.remove(id);
    }
  }
}
