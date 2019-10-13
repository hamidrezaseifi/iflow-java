package com.pth.iflow.profile.model.cach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pth.iflow.profile.model.WorkflowMessage;

public class WorkflowCachData {

  private final Map<String, WorkflowTypeStepCachData> workflowSteps = new HashMap<>();
  private String                                      workflowId;

  public WorkflowCachData(final String workflowId) {
    this.workflowId = workflowId;
  }

  public Map<String, WorkflowTypeStepCachData> getWorkflowSteps() {
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
    final Map<String, List<WorkflowMessage>> mapped = this.getStepMappedMessageList(workflowMessages);

    for (final String stepId : mapped.keySet()) {
      final WorkflowTypeStepCachData data = this.getWorkflowTypeStepCachData(stepId, true);
      data.setWorkflowMessages(mapped.get(stepId));

    }

    this.removeAllExpired();

  }

  private Map<String, List<WorkflowMessage>> getStepMappedMessageList(final List<WorkflowMessage> workflowMessages) {

    final Map<String, List<WorkflowMessage>> mapped = new HashMap<>();

    for (final WorkflowMessage message : workflowMessages) {

      if (message.isExpired()) {
        continue;
      }
      if (mapped.keySet().contains(message.getStepIdentity()) == false) {
        mapped.put(message.getStepIdentity(), new ArrayList<>());
      }
      mapped.get(message.getStepIdentity()).add(message);

    }
    return mapped;
  }

  public WorkflowTypeStepCachData getWorkflowTypeStepCachData(final String stepId, final boolean initial) {
    if (initial && !this.hasWorkflowTypeStepCachData(stepId)) {
      final WorkflowTypeStepCachData data = new WorkflowTypeStepCachData(stepId);
      this.workflowSteps.put(stepId, data);
    }
    return !this.hasWorkflowTypeStepCachData(stepId) ? null : this.workflowSteps.get(stepId);
  }

  public boolean hasWorkflowTypeStepCachData(final String stepId) {
    return this.workflowSteps.keySet().contains(stepId);
  }

  public void addWorkflowMessage(final WorkflowMessage workflowMessage) {

    if (workflowMessage.isNotExpired()) {
      final WorkflowTypeStepCachData cachData = this.getWorkflowTypeStepCachData(workflowMessage.getStepIdentity(), true);
      cachData.addWorkflowMessage(workflowMessage);
    }
  }

  public void addWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {

    final Map<String, List<WorkflowMessage>> mapped = this.getStepMappedMessageList(workflowMessageList);

    for (final String stepId : mapped.keySet()) {
      final WorkflowTypeStepCachData data = this.getWorkflowTypeStepCachData(stepId, true);
      data.addWorkflowMessageList(mapped.get(stepId));

    }

    this.removeAllExpired();
  }

  public String getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final String workflowId) {
    this.workflowId = workflowId;
  }

  public boolean isWorkflowId(final String workflowId) {
    return this.workflowId == workflowId;
  }

  public void removeAllExpired() {

    for (final WorkflowTypeStepCachData cachData : this.workflowSteps.values()) {
      cachData.removeAllExpired();
    }

  }
}
