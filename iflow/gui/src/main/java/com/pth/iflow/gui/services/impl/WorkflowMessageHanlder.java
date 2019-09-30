package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflowMessage;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowMessageAccess;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Service
public class WorkflowMessageHanlder implements IWorkflowMessageHanlder {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowMessageHanlder.class);

  private final IWorkflowMessageAccess workflowMessageAccess;

  private final GuiSessionUserInfo sessionUserInfo;

  private final Map<Long, GuiWorkflowMessage> cachedMessages = new HashMap<>();

  public WorkflowMessageHanlder(@Autowired final IWorkflowMessageAccess workflowMessageAccess,
                                @Autowired final GuiSessionUserInfo sessionUserInfo) {
    this.workflowMessageAccess = workflowMessageAccess;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    workflowMessageAccess.callUserMessageReset(sessionUserInfo.getCompany().getId(),
                                               sessionUserInfo.getUser().getId(),
                                               sessionUserInfo.getToken());
  }

  @Override
  public List<GuiWorkflowMessage> readUserMessages() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<GuiWorkflowMessage> readList = workflowMessageAccess.readUserMessages(sessionUserInfo.getCompany().getId(),
                                                                                     sessionUserInfo.getUser().getId(),
                                                                                     sessionUserInfo.getToken());

    readList.sort(new Comparator<GuiWorkflowMessage>() {

      @Override
      public int compare(final GuiWorkflowMessage message1, final GuiWorkflowMessage message2) {

        return message1.getCreatedAt()
                       .isAfter(message2.getCreatedAt()) ? -1 : message1.getCreatedAt().isBefore(message2.getCreatedAt()) ? 1 : 0;
      }
    });

    cachedMessages.clear();

    readList.forEach(m -> cachedMessages.put(m.getId(), m));
    return readList;
  }

  @Override
  public GuiWorkflowMessage getCachedMessage(final Long id) {

    return cachedMessages.get(id);
  }

}
