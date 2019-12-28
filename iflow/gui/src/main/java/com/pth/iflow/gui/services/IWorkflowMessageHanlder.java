package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;

public interface IWorkflowMessageHanlder {

  public void callUserMessageReset(boolean fromController)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<WorkflowMessage> readUserMessages()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
