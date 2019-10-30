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
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Service
public class WorkflowMessageHanlder implements IWorkflowMessageHanlder {

  private final IWorkflowMessageAccess workflowMessageAccess;

  private final SessionUserInfo        sessionUserInfo;

  private final IWorkflowHandler       workflowHandler;

  public WorkflowMessageHanlder(@Autowired final IWorkflowMessageAccess workflowMessageAccess,
      @Autowired final SessionUserInfo sessionUserInfo, final IWorkflowHandler workflowHandler) {
    this.workflowMessageAccess = workflowMessageAccess;
    this.workflowHandler = workflowHandler;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    this.workflowMessageAccess.callUserMessageReset(this.sessionUserInfo.getCompany().getIdentity(),
        this.sessionUserInfo.getUser().getIdentity(), this.sessionUserInfo.getToken());
  }

  @Override
  public List<WorkflowMessage> readUserMessages()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowMessage> readList = this.workflowMessageAccess.readUserMessages(this.sessionUserInfo.getCompany().getIdentity(),
        this.sessionUserInfo.getUser().getIdentity(), this.sessionUserInfo.getToken());

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

}
