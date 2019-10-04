package com.pth.iflow.profile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkflowCachData {

  private final Map<Long, WorkflowMessage> workflowMessages = new HashMap<>();
  private Long                             workflowId;

  public WorkflowCachData(final Long workflowId) {
    this.workflowId = workflowId;
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

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public boolean isWorkflowId(final Long workflowId) {
    return this.workflowId == workflowId;
  }

  public void removeAllExpired() {

    final List<Long> expireds = this.workflowMessages.keySet().stream().filter(id -> this.workflowMessages.get(id).isExpired())
        .collect(Collectors.toList());

    for (final Long id : expireds) {
      this.workflowMessages.remove(id);
    }
  }
}
