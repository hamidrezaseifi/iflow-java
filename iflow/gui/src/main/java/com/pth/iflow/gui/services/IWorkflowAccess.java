package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;

public interface IWorkflowAccess {

  Workflow readWorkflow(final String workflowIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<Workflow> createWorkflow(final WorkflowSaveRequest createRequest, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  Workflow saveWorkflow(final WorkflowSaveRequest request, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<WorkflowType> readWorkflowTypeList(final String companyIdentity, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<Workflow> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  void validateWorkflow(WorkflowSaveRequest request, String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
