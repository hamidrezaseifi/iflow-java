package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.cach.CompanyCachData;
import com.pth.iflow.gui.models.cach.UserCachData;
import com.pth.iflow.gui.services.ICompanyCachDataManager;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;

@Service
public class CompanyDataManager implements ICompanyCachDataManager {

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  private final IWorkflowMessageAccess workflowMessageService;

  private final Map<String, CompanyCachData> companiesCachData = new HashMap<>();

  public CompanyDataManager(@Autowired final IWorkflowMessageAccess workflowMessageService) {

    this.workflowMessageService = workflowMessageService;
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

  public List<String> setWorkflowWorkflowMessages(final String companyId, final String workflowId,
      final List<WorkflowMessage> workflowMessageList) {

    return this.getCompanyCachData(companyId, true).setWorkflowWorkflowMessages(workflowId, workflowMessageList, this);

  }

  @Override
  public List<WorkflowMessage> getUserWorkflowMessages(final String companyId, final String userId) {

    return this.getUserCachData(companyId, userId).getWorkflowMessagesList();
  }

  @Override
  public void resetUserData(final String companyId, final String userIdentity, final String token, final boolean fromController)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<
        WorkflowMessage> messageList = this.workflowMessageService
            .getWorkflowMessageListByUser(userIdentity, token);

    this.removeUserMessages(companyId, userIdentity);
    this.setUserWorkflowMessages(companyId, userIdentity, messageList);

    if (fromController) {
      this.sendResetMessageToSocket(userIdentity);
    }

  }

  @Override
  public void resetWorkflowStepData(final String compnayId, final String workflowId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowMessage> messageList = this.workflowMessageService
        .getWorkflowMessageListByWorkflow(workflowId, token);

    final List<String> userIdentityList = this.removeWorkflowMessages(compnayId, workflowId);

    final List<String> resetUserIdentityList = this.setWorkflowWorkflowMessages(compnayId, workflowId, messageList);

    userIdentityList.removeAll(resetUserIdentityList);

    for (final String userIdentity : userIdentityList) {
      this.sendResetMessageToSocket(userIdentity);
    }
  }

  @Override
  public void resetUserListData(final String compnayId, final Collection<String> userIdList, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    for (final String userIdentity : userIdList) {
      final List<
          WorkflowMessage> messageList = this.workflowMessageService.getWorkflowMessageListByUser(userIdentity, token);

      this.setUserWorkflowMessages(compnayId, userIdentity, messageList);
      this.sendResetMessageToSocket(userIdentity);
    }
  }

  public void addCompanyCachData(final CompanyCachData companyCachData) {

    this.companiesCachData.put(companyCachData.getCompanyId(), companyCachData);
  }

  @Override
  public void sendResetMessageToSocket(final String userIdentity) {

    final Map<String, Object> map = new HashMap<>();
    map.put("command", "message-reload");
    map.put("status", "done");

    this.simpMessagingTemplate.convertAndSendToUser(userIdentity, "/socket/messages", map);
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

  private void removeUserMessages(final String companyId, final String userId) {

    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    companyCachData.removeUserCachData(userId);

  }

  private List<String> removeWorkflowMessages(final String companyId, final String workflowId) {

    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    return companyCachData.removeWorkflowCachData(workflowId);

  }

  private UserCachData getUserCachData(final String companyId, final String userId) {

    final CompanyCachData companyCachData = this.getCompanyCachData(companyId, true);

    return companyCachData.getUserCachData(userId, true);
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

}
