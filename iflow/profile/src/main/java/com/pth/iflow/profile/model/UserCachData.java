package com.pth.iflow.profile.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserCachData {

  private final Map<Long, WorkflowCachData> workflowDataList = new HashMap<>();
  private Long                              userId;

  public UserCachData(final Long userId) {
    this.userId = userId;
  }

  public Map<Long, WorkflowCachData> getWorkflowDatas() {
    this.removeAllExpired();
    return this.workflowDataList;
  }

  public List<WorkflowCachData> getWorkflowDataList() {
    this.removeAllExpired();
    return this.workflowDataList.values().stream().collect(Collectors.toList());
  }

  public void setWorkflowMessages(final Long workflowId, final List<WorkflowMessage> workflowMessages) {
    final WorkflowCachData workflowCachData = this.getWorkflowCachData(workflowId, true);
    workflowCachData.removeAllExpired();
    if (workflowMessages != null) {

      workflowCachData.setWorkflowMessages(workflowMessages);

    }
    this.removeAllExpired();
  }

  public WorkflowCachData getWorkflowCachData(final Long workflowId, final boolean initialUserCachData) {
    if (this.workflowDataList.containsKey(workflowId) == false && initialUserCachData) {
      this.initialWorkflowCachData(workflowId);
    }
    if (this.workflowDataList.containsKey(this.userId)) {
      return this.workflowDataList.get(this.userId);
    }
    return null;
  }

  private void initialWorkflowCachData(final Long workflowId) {
    if (this.hasWorkflowCachData(workflowId) == false) {
      final WorkflowCachData workflowCachData = new WorkflowCachData(workflowId);
      this.addWorkflowCachData(workflowCachData);
    }
  }

  private void addWorkflowCachData(final WorkflowCachData workflowCachData) {
    this.workflowDataList.put(workflowCachData.getWorkflowId(), workflowCachData);
  }

  public boolean hasWorkflowCachData(final Long workflowId) {
    return this.workflowDataList.containsKey(workflowId);
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

    for (final WorkflowCachData data : this.workflowDataList.values()) {
      data.removeAllExpired();
    }
  }

  public void setWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {

    final Map<Long, List<WorkflowMessage>> workflowMap = new HashMap<>();
    for (final WorkflowMessage message : workflowMessageList) {
      if (workflowMap.containsKey(message.getWorkflowId()) == false) {
        workflowMap.put(message.getWorkflowId(), new ArrayList<>());
      }
      workflowMap.get(message.getWorkflowId()).add(message);
    }

    for (final Long workflowId : workflowMap.keySet()) {
      this.setWorkflowMessages(workflowId, workflowMap.get(workflowId));
    }
  }

  public List<WorkflowMessage> getWorkflowMessagesList() {
    final List<WorkflowMessage> list = new ArrayList<>();
    for (final WorkflowCachData data : this.workflowDataList.values()) {
      list.addAll(data.getWorkflowMessagesList());
    }
    return list;
  }

}
