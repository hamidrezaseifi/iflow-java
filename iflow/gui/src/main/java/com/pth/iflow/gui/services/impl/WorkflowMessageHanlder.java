package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.models.workflow.workflow.WorkflowSaveRequest;
import com.pth.iflow.gui.services.ICompanyCachDataManager;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Service
public class WorkflowMessageHanlder implements IWorkflowMessageHanlder {

  private final SessionUserInfo sessionUserInfo;

  private final IWorkflowHandler<Workflow, WorkflowSaveRequest> workflowHandler;

  private final ICompanyCachDataManager companyCachDataManager;

  public WorkflowMessageHanlder(@Autowired final SessionUserInfo sessionUserInfo,
      @Autowired final IWorkflowHandler<Workflow, WorkflowSaveRequest> workflowHandler,
      @Autowired final ICompanyCachDataManager companyCachDataManager) {

    this.sessionUserInfo = sessionUserInfo;
    this.workflowHandler = workflowHandler;
    this.companyCachDataManager = companyCachDataManager;
  }

  @Override
  public void callUserMessageReset(final boolean fromController)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    this.companyCachDataManager
        .resetUserData(this.getCompanyIdentity(), this.getUserIdentity(), this.sessionUserInfo.getToken(), fromController);

  }

  @Override
  public List<WorkflowMessage> readUserMessages()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<
        WorkflowMessage> readList = this.companyCachDataManager.getUserWorkflowMessages(this.getCompanyIdentity(), this.getUserIdentity());

    readList.sort(new Comparator<WorkflowMessage>() {

      @Override
      public int compare(final WorkflowMessage message1, final WorkflowMessage message2) {

        return message1.getCreatedAt().isAfter(message2.getCreatedAt()) ? -1
            : message1.getCreatedAt().isBefore(message2.getCreatedAt()) ? 1 : 0;
      }
    });

    this.prepareWorkflowMessageList(readList);

    return readList;
  }

  private List<WorkflowMessage> prepareWorkflowMessageList(final List<WorkflowMessage> messageList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowMessage> resultList = new ArrayList<>();
    for (final WorkflowMessage message : messageList) {
      resultList.add(this.prepareWorkflowMessage(message));
    }
    return resultList;
  }

  private WorkflowMessage prepareWorkflowMessage(final WorkflowMessage message)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    message.setWorkflow(this.workflowHandler.readWorkflow(message.getWorkflowIdentity()));

    final WorkflowType type = message.getWorkflow().getWorkflowType();

    for (final WorkflowTypeStep step : type.getSteps()) {
      if (step.hasSameIdentity(message.getStepIdentity())) {
        message.setStep(step);
      }
    }

    return message;
  }

  private String getUserIdentity() {

    return this.sessionUserInfo.getUser().getIdentity();
  }

  private String getCompanyIdentity() {

    return this.sessionUserInfo.getCompany().getIdentity();
  }

}
