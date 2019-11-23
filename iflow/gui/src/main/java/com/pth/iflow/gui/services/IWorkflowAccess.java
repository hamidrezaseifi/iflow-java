package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;

public interface IWorkflowAccess<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>> {

  W readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<W> createWorkflow(final WS createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  W saveWorkflow(final WS request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  void validateWorkflow(WS request, String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
