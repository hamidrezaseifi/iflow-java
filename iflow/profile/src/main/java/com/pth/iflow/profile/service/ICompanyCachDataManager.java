package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.WorkflowMessage;

public interface ICompanyCachDataManager {

  public void addWorkflowMessage(final Long companyId, final Long userId, final WorkflowMessage workflowMessage);

  public void setWorkflowMessages(final Long companyId, final Long userId, final List<WorkflowMessage> workflowMessageList);

  public void addWorkflowMessageList(final Long companyId, final Long userId, final List<WorkflowMessage> workflowMessageList);

  public List<WorkflowMessage> getUserWorkflowMessages(Long compnayId, Long userId);

  public void resetUserData(Long compnayId, Long userId) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetUserListData(Long compnayId, Set<Long> userIdList) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
