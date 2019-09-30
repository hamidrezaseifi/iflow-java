package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflowMessage;

public interface IWorkflowMessageHanlder {

  public void callUserMessageReset() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<GuiWorkflowMessage> readUserMessages() throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
