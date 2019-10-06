package com.pth.iflow.profile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkflowTypeStepCachData {

  private final Map<Long, WorkflowMessage> workflowMessages = new HashMap<>();
  private Long                             stepId;

  public WorkflowTypeStepCachData(final Long stepId) {
    this.stepId = stepId;
  }

  public Map<Long, WorkflowMessage> getWorkflowMessages() {
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
        this.workflowMessages.put(workflowMessage.getId(), workflowMessage);
      }

    }
    this.removeAllExpired();
  }

  public void addWorkflowMessage(final WorkflowMessage workflowMessage) {

    if (workflowMessage.isNotExpired()) {
      this.workflowMessages.put(workflowMessage.getId(), workflowMessage);
    }
  }

  public void addWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {
    this.removeAllExpired();
    for (final WorkflowMessage workflowMessage : workflowMessageList) {
      this.addWorkflowMessage(workflowMessage);
    }
  }

  public Long getStepId() {
    return this.stepId;
  }

  public void setStepId(final Long stepId) {
    this.stepId = stepId;
  }

  public boolean isStepId(final Long stepId) {
    return this.stepId == stepId;
  }

  public void removeAllExpired() {

    final List<Long> expireds = this.workflowMessages.keySet().stream().filter(id -> this.workflowMessages.get(id).isExpired())
        .collect(Collectors.toList());

    for (final Long id : expireds) {
      this.workflowMessages.remove(id);
    }
  }
}
