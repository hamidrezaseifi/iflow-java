package com.pth.iflow.profile.model;

import java.util.HashMap;
import java.util.Map;

public class UserCachData {

  private final Map<Long, WorkflowMessage> workflowMessages = new HashMap<>();
  private final Long                       userId;

  public UserCachData(final Long userId) {
    this.userId = userId;
  }

}
