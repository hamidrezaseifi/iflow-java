package com.pth.iflow.gui.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;

public interface IWorkflowHandler<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>> {

  W readWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  WorkflowFile readWorkflowFile(final String workflowIdentity, final String fileIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<W> createWorkflow(final WS createRequest, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  W saveWorkflow(final W workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  W doneWorkflow(final WS saveRequest, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  W archiveWorkflow(final W workflow, final HttpSession session) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

  List<WorkflowType> readWorkflowTypeList(final String companyIdentity) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<W> searchWorkflow(final WorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  W assignWorkflow(final String workflowIdentity) throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException;

}
