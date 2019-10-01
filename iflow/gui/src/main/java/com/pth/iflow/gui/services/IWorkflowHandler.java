package com.pth.iflow.gui.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;

public interface IWorkflowHandler {

  GuiWorkflow readWorkflow(final Long workflowId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  GuiWorkflowFile readWorkflowFile(final Long workflowId, final Long fileId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<GuiWorkflow> createWorkflow(final GuiWorkflowSaveRequest createRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  GuiWorkflow saveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  GuiWorkflow doneWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  GuiWorkflow archiveWorkflow(final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  List<GuiWorkflowType> readWorkflowTypeList(final Long companyId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<GuiWorkflow> searchWorkflow(final GuiWorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
