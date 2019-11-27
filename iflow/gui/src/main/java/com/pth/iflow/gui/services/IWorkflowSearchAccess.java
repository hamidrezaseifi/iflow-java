package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.workflow.WorkflowResult;

public interface IWorkflowSearchAccess {

  List<WorkflowResult> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<WorkflowResult> readByIdentityList(final Set<String> identityList)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
