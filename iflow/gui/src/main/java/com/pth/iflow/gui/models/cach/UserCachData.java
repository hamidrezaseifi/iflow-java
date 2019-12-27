package com.pth.iflow.gui.models.cach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pth.iflow.gui.models.WorkflowMessage;

public class UserCachData {

  private final Map<String, WorkflowCachData> workflowDataList = new HashMap<>();
  private String userId;

  public UserCachData(final String userId) {

    this.userId = userId;
  }

  public Map<String, WorkflowCachData> getWorkflowDatas() {

    this.removeAllExpired();
    return this.workflowDataList;
  }

  public List<WorkflowCachData> getWorkflowDataList() {

    this.removeAllExpired();
    return this.workflowDataList.values().stream().collect(Collectors.toList());
  }

  public void setWorkflowMessages(final String workflowId, final List<WorkflowMessage> workflowMessages) {

    final WorkflowCachData workflowCachData = this.getWorkflowCachData(workflowId, true);
    workflowCachData.removeAllExpired();
    if (workflowMessages != null) {

      workflowCachData.setWorkflowMessages(workflowMessages);

    }
    this.removeAllExpired();
  }

  public WorkflowCachData getWorkflowCachData(final String workflowId, final boolean initialUserCachData) {

    if (this.workflowDataList.containsKey(workflowId) == false && initialUserCachData) {
      this.initialWorkflowCachData(workflowId);
    }
    if (this.workflowDataList.containsKey(workflowId)) {
      return this.workflowDataList.get(workflowId);
    }
    return null;
  }

  private void initialWorkflowCachData(final String workflowId) {

    if (this.hasWorkflowCachData(workflowId) == false) {
      final WorkflowCachData workflowCachData = new WorkflowCachData(workflowId);
      this.addWorkflowCachData(workflowCachData);
    }
  }

  private void addWorkflowCachData(final WorkflowCachData workflowCachData) {

    this.workflowDataList.put(workflowCachData.getWorkflowId(), workflowCachData);
  }

  public boolean hasWorkflowCachData(final String workflowId) {

    return this.workflowDataList.containsKey(workflowId);
  }

  public String getUserId() {

    return this.userId;
  }

  public void setUserId(final String userId) {

    this.userId = userId;
  }

  public boolean isUserId(final String userId) {

    return this.userId == userId;
  }

  private void removeAllExpired() {

    for (final WorkflowCachData data : this.workflowDataList.values()) {
      data.removeAllExpired();
    }
  }

  public void setWorkflowMessageList(final List<WorkflowMessage> workflowMessageList) {

    final Map<String, List<WorkflowMessage>> workflowMap = new HashMap<>();
    for (final WorkflowMessage message : workflowMessageList) {
      if (workflowMap.containsKey(message.getWorkflowIdentity()) == false) {
        workflowMap.put(message.getWorkflowIdentity(), new ArrayList<>());
      }
      workflowMap.get(message.getWorkflowIdentity()).add(message);
    }

    for (final String workflowId : workflowMap.keySet()) {
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
