package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;

public interface ICompanyCachDataManager {

  public void setUserWorkflowMessages(final String companyId, final String userId, final List<WorkflowMessage> workflowMessageList);

  public List<WorkflowMessage> getUserWorkflowMessages(String compnayId, String userId);

  public void resetUserData(String compnayId, String userId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetWorkflowStepData(String compnayId, String workflowId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public void resetUserListData(String compnayId, Collection<String> userIdList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
