package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;

public interface IWorkflowAccess {

  GuiWorkflow readWorkflow(final Long workflowId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<GuiWorkflow> createWorkflow(final GuiWorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  GuiWorkflow saveWorkflow(final GuiWorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<GuiWorkflowType> readWorkflowTypeList(final Long companyId, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  void validateWorkflow(GuiWorkflowSaveRequest request, String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
