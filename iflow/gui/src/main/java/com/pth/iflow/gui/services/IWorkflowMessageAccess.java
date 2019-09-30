package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflowMessage;

public interface IWorkflowMessageAccess {

  public void callUserMessageReset(final Long companyId, final Long userId, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  public List<GuiWorkflowMessage> readUserMessages(final Long companyId, final Long userId, final String token) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
