package com.pth.iflow.profile.service;

import java.util.List;

import com.pth.iflow.profile.model.WorkflowMessage;

public interface ICompanyDataManager {
  public List<WorkflowMessage> getUserWorkflowMessages(Long compnayId, Long userId);
}
