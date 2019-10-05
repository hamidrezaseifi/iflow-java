package com.pth.iflow.profile.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowCachData {

  private final Map<Long, WorkflowTypeStepCachData> workflowSteps = new HashMap<>();
  private Long                                      workflowId;

  public WorkflowCachData(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public Map<Long, WorkflowTypeStepCachData> getWorkflowSteps() {
    this.removeAllExpired();
    return this.workflowSteps;
  }

  public List<WorkflowMessage> getWorkflowMessagesList() {
    this.removeAllExpired();

    final List<WorkflowMessage> list = new ArrayList<>();
    for (final WorkflowTypeStepCachData data : this.workflowSteps.values()) {
      list.addAll(data.getWorkflowMessagesList());
    }
    return list;
  }

  public void setWorkflowMessages(final List<WorkflowMessage> workflowMessages) {
    final Map<Long, List<WorkflowMessage>> mapped = this.getStepMappedMessageList(workflowMessages);

    for (final Long stepId : mapped.keySet()) {
      final WorkflowTypeStepCachData data = this.getWorkflowTypeStepCachData(stepId, true);
      data.setWorkflowMessages(mapped.get(stepId));

    }

    this.removeAllExpired();

  }

  private Map<Long, List<WorkflowMessage>> getStepMappedMessageList(final List<WorkflowMessage> workflowMessages) {

    final Map<Long, List<WorkflowMessage>> mapped = new HashMap<>();

    for (final WorkflowMessage message : workflowMessages) {

      if (message.isExpired()) {
        continue;
      }
      if (mapped.keySet().contains(message.getStepId()) == false) {
        mapped.put(message.getStepId(), new ArrayList<>());
      }
      mapped.get(message.getStepId()).add(message);

    }
    return mapped;
  }

  public WorkflowTypeStepCachData getWorkflowTypeStepCachData(final Long stepId, final boolean initial) {
    if (initial && !this.hasWorkflowTypeStepCachData(stepId)) {
      final WorkflowTypeStepCachData data = new WorkflowTypeStepCachData(stepId);
      this.workflowSteps.put(stepId, data);
    }
    return !this.hasWorkflowTypeStepCachData(stepId) ? null : this.workflowSteps.get(stepId);
  }

  public boolean hasWorkflowTypeStepCachData(final Long stepId) {
    return this.workflowSteps.keySet().contains(stepId);
  }

  public void addWorkflowMessage(final WorkflowMessage workflowMessage) {

    if (workflowMessage.isNotExpired()) {
      final WorkflowTypeStepCachData cachData = this.getWorkflowTypeStepCachData(workflowMessage.getStepId(), true);
      cachData.addWorkflowMessage(workflowMessage);
    }
  }

  public void addWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {

    final Map<Long, List<WorkflowMessage>> mapped = this.getStepMappedMessageList(workflowMessageList);

    for (final Long stepId : mapped.keySet()) {
      final WorkflowTypeStepCachData data = this.getWorkflowTypeStepCachData(stepId, true);
      data.addWorkflowMessageList(mapped.get(stepId));

    }

    this.removeAllExpired();
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

    for (final WorkflowTypeStepCachData cachData : this.workflowSteps.values()) {
      cachData.removeAllExpired();
    }

  }
}
