package com.pth.iflow.gui.models.cach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.services.ICompanyCachDataManager;

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

      this.userCachList.putAll(userCachDataList.stream().collect(Collectors.toMap(ud -> ud.getUserIdentity(), ud -> ud)));

    }
  }

  public void addUserCachData(final UserCachData userCachData) {

    this.userCachList.put(userCachData.getUserIdentity(), userCachData);
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

  public List<String> setWorkflowWorkflowMessages(final String workflowId, final List<WorkflowMessage> workflowMessageList,
      final ICompanyCachDataManager companyCachDataManager) {

    final List<String> userIdentityList = new ArrayList<>();
    final Set<String> messageUserIdentityList = workflowMessageList.stream().map(m -> m.getUserIdentity()).collect(Collectors.toSet());

    for (final String userIdentity : messageUserIdentityList) {
      if (this.userCachList.containsKey(userIdentity) == false) {
        this.initialUserCachData(userIdentity);
      }

    }

    for (final UserCachData userCachData : this.userCachList.values()) {
      if (userCachData.hasWorkflowCachData(workflowId)) {

        final WorkflowCachData workflowCachData = userCachData.getWorkflowCachData(workflowId, false);
        workflowCachData.setWorkflowMessages(workflowMessageList);
        companyCachDataManager.sendResetMessageToSocket(userCachData.getUserIdentity());
        userIdentityList.add(userCachData.getUserIdentity());
      }
      else {
        if (messageUserIdentityList.contains(userCachData.getUserIdentity())) {

          final List<WorkflowMessage> userMessageList = workflowMessageList
              .stream()
              .filter(m -> m.getUserIdentity().equals(userCachData.getUserIdentity()))
              .collect(Collectors.toList());

          userCachData.setWorkflowMessageList(userMessageList);
          companyCachDataManager.sendResetMessageToSocket(userCachData.getUserIdentity());
          userIdentityList.add(userCachData.getUserIdentity());
        }

      }
    }

    return userIdentityList;

  }

  public List<String> removeWorkflowCachData(final String workflowId) {

    final List<String> userIdentityList = new ArrayList<>();

    for (final UserCachData userCachData : this.userCachList.values()) {
      if (userCachData.removeWorkflowCachData(workflowId)) {
        userIdentityList.add(userCachData.getUserIdentity());
      }
    }

    return userIdentityList;
  }

}
