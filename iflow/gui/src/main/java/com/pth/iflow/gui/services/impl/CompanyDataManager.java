package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.cach.CompanyCachData;
import com.pth.iflow.gui.models.cach.UserCachData;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.ICompanyCachDataManager;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;

@Service
public class CompanyDataManager implements ICompanyCachDataManager {

  private final IWorkflowMessageAccess workflowMessageService;

  private final Map<String, CompanyCachData> companiesCachData = new HashMap<>();

  private final SessionUserInfo sessionUserInfo;

  public CompanyDataManager(@Autowired final IWorkflowMessageAccess workflowMessageService,
      @Autowired final SessionUserInfo sessionUserInfo) {

    this.workflowMessageService = workflowMessageService;
    this.sessionUserInfo = sessionUserInfo;
  }

  public Map<String, CompanyCachData> getCompaniesCachData() {

    return this.companiesCachData;
  }

  public void setCompaniesCachData(final List<CompanyCachData> companiesCachData) {

    this.companiesCachData.clear();
    if (companiesCachData != null) {
      this.companiesCachData.putAll(companiesCachData.stream().collect(Collectors.toMap(cd -> cd.getCompanyId(), cd -> cd)));
    }

  }

  @Override
  public void setUserWorkflowMessages(final String companyId, final String userId, final List<WorkflowMessage> workflowMessageList) {

    this.getUserCachData(companyId, userId).setWorkflowMessageList(workflowMessageList);

  }

  public void setWorkflowWorkflowMessages(final String companyId, final String workflowId,
      final List<WorkflowMessage> workflowMessageList) {

    this.getCompanyCachData(companyId, true).setWorkflowWorkflowMessages(workflowId, workflowMessageList);

  }

  @Override
  public List<WorkflowMessage> getUserWorkflowMessages(final String companyId, final String userId) {

    return this.getUserCachData(companyId, userId).getWorkflowMessagesList();
  }

  @Override
  public void resetUserData(final String companyId, final String userId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<
        WorkflowMessage> messageList = this.workflowMessageService.getWorkflowMessageListByUser(userId, this.sessionUserInfo.getToken());

    this.removeUserWorkflowMessages(companyId, userId);
    this.setUserWorkflowMessages(companyId, userId, messageList);
  }

  private void removeUserWorkflowMessages(final String companyId, final String userId) {

    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    companyCachData.removeUserCachData(userId);

  }

  @Override
  public void resetWorkflowStepData(final String compnayId, final String workflowId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowMessage> messageList = this.workflowMessageService
        .getWorkflowMessageListByWorkflow(workflowId, this.sessionUserInfo.getToken());

    this.setWorkflowWorkflowMessages(compnayId, workflowId, messageList);

  }

  @Override
  public void resetUserListData(final String compnayId, final Collection<String> userIdList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    for (final String userId : userIdList) {
      final List<
          WorkflowMessage> messageList = this.workflowMessageService.getWorkflowMessageListByUser(userId, this.sessionUserInfo.getToken());

      this.setUserWorkflowMessages(compnayId, userId, messageList);
    }
  }

  private boolean hasCompanyCachData(final String companyId) {

    return this.companiesCachData.containsKey(companyId);
  }

  private void initialCompanyCachData(final String companyId) {

    if (this.hasCompanyCachData(companyId) == false) {
      final CompanyCachData companyCachData = new CompanyCachData(companyId);
      this.addCompanyCachData(companyCachData);
    }
  }

  public void addCompanyCachData(final CompanyCachData companyCachData) {

    this.companiesCachData.put(companyCachData.getCompanyId(), companyCachData);
  }

  private CompanyCachData getCompanyCachData(final String companyId, final boolean initialCompanyCachData) {

    if (this.companiesCachData.containsKey(companyId) == false && initialCompanyCachData) {
      this.initialCompanyCachData(companyId);
    }
    if (this.companiesCachData.containsKey(companyId)) {
      return this.companiesCachData.get(companyId);
    }
    return null;

  }

  private UserCachData getUserCachData(final String companyId, final String userId) {

    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    return companyCachData.getUserCachData(userId, true);
  }

}