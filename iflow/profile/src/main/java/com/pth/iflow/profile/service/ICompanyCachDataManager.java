package com.pth.iflow.profile.service;

import java.util.List;

import com.pth.iflow.profile.model.WorkflowMessage;

public interface ICompanyCachDataManager {

  public void addWorkflowMessage(final Long companyId, final Long userId, final WorkflowMessage workflowMessage);

  public void addWorkflowMessageList(final Long companyId, final Long userId, final List<WorkflowMessage> workflowMessageList);

  public List<WorkflowMessage> getUserWorkflowMessages(Long compnayId, Long userId);
}
