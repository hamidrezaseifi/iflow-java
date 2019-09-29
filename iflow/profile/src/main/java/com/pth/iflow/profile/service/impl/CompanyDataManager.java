package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.CompanyCachData;
import com.pth.iflow.profile.model.UserCachData;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.service.ICompanyCachDataManager;
import com.pth.iflow.profile.service.IWorkflowMessageService;

@Service
public class CompanyDataManager implements ICompanyCachDataManager {

  private final IWorkflowMessageService workflowMessageService;

  private final Map<Long, CompanyCachData> companiesCachData = new HashMap<>();

  public CompanyDataManager(@Autowired final IWorkflowMessageService workflowMessageService) {
    this.workflowMessageService = workflowMessageService;
  }

  public Map<Long, CompanyCachData> getCompaniesCachData() {
    return this.companiesCachData;
  }

  public void setCompaniesCachData(final List<CompanyCachData> companiesCachData) {
    this.companiesCachData.clear();
    if (companiesCachData != null) {
      this.companiesCachData.putAll(companiesCachData.stream().collect(Collectors.toMap(cd -> cd.getCompanyId(), cd -> cd)));
    }

  }

  @Override
  public void addWorkflowMessage(final Long companyId, final Long userId, final WorkflowMessage workflowMessage) {
    this.getUserCachData(companyId, userId).addWorkflowMessage(workflowMessage);

  }

  @Override
  public void setWorkflowMessages(final Long companyId, final Long userId, final List<WorkflowMessage> workflowMessageList) {
    this.getUserCachData(companyId, userId).setWorkflowMessages(workflowMessageList);

  }

  @Override
  public void addWorkflowMessageList(final Long companyId, final Long userId, final List<WorkflowMessage> workflowMessageList) {
    this.getUserCachData(companyId, userId).addWorkflowMessageList(workflowMessageList);
  }

  @Override
  public List<WorkflowMessage> getUserWorkflowMessages(final Long companyId, final Long userId) {

    return this.getUserCachData(companyId, userId).getWorkflowMessagesList();
  }

  @Override
  public void resetUserData(final Long compnayId, final Long userId) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final List<WorkflowMessage> messageList = this.workflowMessageService.getWorkflowMessageListByUser(userId);

    this.setWorkflowMessages(compnayId, userId, messageList);
  }

  @Override
  public void resetUserListData(final Long compnayId, final Set<Long> userIdList) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    for (final Long userId : userIdList) {
      final List<WorkflowMessage> messageList = this.workflowMessageService.getWorkflowMessageListByUser(userId);

      this.setWorkflowMessages(compnayId, userId, messageList);
    }
  }

  private boolean hasCompanyCachData(final Long companyId) {
    return this.companiesCachData.containsKey(companyId);
  }

  private void initialCompanyCachData(final Long companyId) {
    if (this.hasCompanyCachData(companyId) == false) {
      final CompanyCachData companyCachData = new CompanyCachData(companyId);
      this.addCompanyCachData(companyCachData);
    }
  }

  public void addCompanyCachData(final CompanyCachData companyCachData) {
    this.companiesCachData.put(companyCachData.getCompanyId(), companyCachData);
  }

  private CompanyCachData getCompanyCachData(final Long companyId, final boolean initialCompanyCachData) {
    if (this.companiesCachData.containsKey(companyId) == false && initialCompanyCachData) {
      this.initialCompanyCachData(companyId);
    }
    if (this.companiesCachData.containsKey(companyId)) {
      return this.companiesCachData.get(companyId);
    }
    return null;

  }

  private UserCachData getUserCachData(final Long companyId, final Long userId) {
    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    return companyCachData.getUserCachData(userId, true);
  }

}
