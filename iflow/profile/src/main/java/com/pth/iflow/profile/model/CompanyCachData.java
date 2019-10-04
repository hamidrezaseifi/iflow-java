package com.pth.iflow.profile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyCachData {

  private final Map<Long, UserCachData> userCachList = new HashMap<>();
  private Long                          companyId;

  public CompanyCachData(final Long companyId) {
    this.companyId = companyId;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public boolean isCompanyId(final Long companyId) {
    return this.companyId == companyId;
  }

  public Map<Long, UserCachData> getUserCachList() {
    return this.userCachList;
  }

  public void setUserCachDataList(final List<UserCachData> userCachDataList) {
    this.userCachList.clear();
    this.addUserCachDataList(userCachDataList);
  }

  public void addUserCachDataList(final List<UserCachData> userCachDataList) {

    if (userCachDataList != null) {

      this.userCachList.putAll(userCachDataList.stream().collect(Collectors.toMap(ud -> ud.getUserId(), ud -> ud)));

    }
  }

  public void addUserCachData(final UserCachData userCachData) {
    this.userCachList.put(userCachData.getUserId(), userCachData);
  }

  public UserCachData getUserCachData(final Long userId, final boolean initialUserCachData) {
    if (this.userCachList.containsKey(userId) == false && initialUserCachData) {
      this.initialUserCachData(userId);
    }
    if (this.userCachList.containsKey(userId)) {
      return this.userCachList.get(userId);
    }
    return null;
  }

  public boolean hasUserCachData(final Long userId) {
    return this.userCachList.containsKey(userId);
  }

  public List<WorkflowMessage> getUserWorkflowMessages(final Long userId) {
    return this.getUserCachData(userId, true).getWorkflowMessagesList();
  }

  private void initialUserCachData(final Long userId) {
    if (this.hasUserCachData(userId) == false) {
      final UserCachData userCachData = new UserCachData(userId);
      this.addUserCachData(userCachData);
    }
  }

  public void setWorkflowWorkflowMessages(final Long workflowId, final List<WorkflowMessage> workflowMessageList) {

    for (final UserCachData userCachData : this.userCachList.values()) {
      if (userCachData.hasWorkflowCachData(workflowId)) {

        final WorkflowCachData workflowCachData = userCachData.getWorkflowCachData(workflowId, false);
        workflowCachData.setWorkflowMessages(workflowMessageList);
      }
    }

  }

}
