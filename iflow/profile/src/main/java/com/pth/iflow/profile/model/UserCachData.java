package com.pth.iflow.profile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserCachData {

  private final Map<Long, WorkflowMessage> workflowMessages = new HashMap<>();
  private Long                             userId;

  public UserCachData(final Long userId) {
    this.userId = userId;
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
      this.workflowMessages
          .putAll(workflowMessages.stream().filter(wm -> wm.isNotExpired()).collect(Collectors.toMap(wm -> wm.getId(), wm -> wm)));
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

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public boolean isUserId(final Long userId) {
    return this.userId == userId;
  }

  private void removeAllExpired() {

    final List<Long> expireds = this.workflowMessages.keySet().stream().filter(id -> this.workflowMessages.get(id).isExpired())
        .collect(Collectors.toList());

    for (final Long id : expireds) {
      this.workflowMessages.remove(id);
    }
  }
}
