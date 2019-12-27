package com.pth.iflow.gui.models.cach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pth.iflow.gui.models.WorkflowMessage;

public class CompanyCachData {

  private final Map<String, UserCachData> userCachList = new HashMap<>();
  private String companyId;

  public CompanyCachData(final String companyId) {

    this.companyId = companyId;
  }

  public String getCompanyId() {

    return this.companyId;
  }

  public void setCompanyId(final String companyId) {

    this.companyId = companyId;
  }

  public boolean isCompanyId(final String companyId) {

    return this.companyId == companyId;
  }

  public Map<String, UserCachData> getUserCachList() {

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

  public UserCachData getUserCachData(final String userId, final boolean initialUserCachData) {

    if (this.userCachList.containsKey(userId) == false && initialUserCachData) {
      this.initialUserCachData(userId);
    }
    if (this.userCachList.containsKey(userId)) {
      return this.userCachList.get(userId);
    }
    return null;
  }

  public void removeUserCachData(final String userId) {

    if (this.userCachList.containsKey(userId)) {
      this.userCachList.remove(userId);
    }
  }

  public boolean hasUserCachData(final String userId) {

    return this.userCachList.containsKey(userId);
  }

  public List<WorkflowMessage> getUserWorkflowMessages(final String userId) {

    return this.getUserCachData(userId, true).getWorkflowMessagesList();
  }

  private void initialUserCachData(final String userId) {

    if (this.hasUserCachData(userId) == false) {
      final UserCachData userCachData = new UserCachData(userId);
      this.addUserCachData(userCachData);
    }
  }

  public void setWorkflowWorkflowMessages(final String workflowId, final List<WorkflowMessage> workflowMessageList) {

    for (final UserCachData userCachData : this.userCachList.values()) {
      if (userCachData.hasWorkflowCachData(workflowId)) {

        final WorkflowCachData workflowCachData = userCachData.getWorkflowCachData(workflowId, false);
        workflowCachData.setWorkflowMessages(workflowMessageList);
      }
    }

  }

}
