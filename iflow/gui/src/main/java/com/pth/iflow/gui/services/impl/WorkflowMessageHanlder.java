package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflowMessage;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiWorkflowTypeStep;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Service
public class WorkflowMessageHanlder implements IWorkflowMessageHanlder {

  private static final Logger          logger = LoggerFactory.getLogger(WorkflowMessageHanlder.class);

  private final IWorkflowMessageAccess workflowMessageAccess;

  private final GuiSessionUserInfo     sessionUserInfo;

  private final IWorkflowHandler       workflowHandler;

  public WorkflowMessageHanlder(@Autowired final IWorkflowMessageAccess workflowMessageAccess,
      @Autowired final GuiSessionUserInfo sessionUserInfo, final IWorkflowHandler workflowHandler) {
    this.workflowMessageAccess = workflowMessageAccess;
    this.workflowHandler = workflowHandler;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    this.workflowMessageAccess.callUserMessageReset(this.sessionUserInfo.getCompany().getId(), this.sessionUserInfo.getUser().getId(),
        this.sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflowMessage> readUserMessages()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<GuiWorkflowMessage> readList = this.workflowMessageAccess.readUserMessages(this.sessionUserInfo.getCompany().getId(),
        this.sessionUserInfo.getUser().getId(), this.sessionUserInfo.getToken());

    readList.sort(new Comparator<GuiWorkflowMessage>() {

      @Override
      public int compare(final GuiWorkflowMessage message1, final GuiWorkflowMessage message2) {

        return message1.getCreatedAt().isAfter(message2.getCreatedAt()) ? -1
            : message1.getCreatedAt().isBefore(message2.getCreatedAt()) ? 1 : 0;
      }
    });

    this.sessionUserInfo.clearCachedMessage();
    this.sessionUserInfo.addCachedMessagesAll(this.prepareWorkflowMessageList(readList));

    return readList;
  }

  @Override
  public GuiWorkflowMessage getCachedMessage(final Long id) {

    return this.sessionUserInfo.getCachedMessage(id);
  }

  private List<GuiWorkflowMessage> prepareWorkflowMessageList(final List<GuiWorkflowMessage> messageList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final List<GuiWorkflowMessage> resultList = new ArrayList<>();
    for (final GuiWorkflowMessage message : messageList) {
      resultList.add(this.prepareWorkflowMessage(message));
    }
    return resultList;
  }

  private GuiWorkflowMessage prepareWorkflowMessage(final GuiWorkflowMessage message)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    message.setWorkflow(this.workflowHandler.readWorkflow(message.getWorkflowId()));

    final GuiWorkflowType type = message.getWorkflow().getWorkflowType();

    for (final GuiWorkflowTypeStep step : type.getSteps()) {
      if (message.getStepId() == step.getId()) {
        message.setStep(step);
      }
    }

    return message;
  }

}
