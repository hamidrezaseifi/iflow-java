package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;

public interface ICompanyCachDataManager {

  public void setUserWorkflowMessages(final String companyId, final String userId, final List<WorkflowMessage> workflowMessageList);

  public List<WorkflowMessage> getUserWorkflowMessages(String compnayId, String userId);

  public void resetUserData(String compnayId, String userId, Authentication authentication, boolean fromController)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetWorkflowStepData(String compnayId, String workflowId, Authentication authentication)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetUserListData(String compnayId, Collection<String> userIdList, Authentication authentication)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  void sendResetMessageToSocket(final String userIdentity);
}
