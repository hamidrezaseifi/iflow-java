package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.models.Workflow;

public interface IWorkflowPrepare {

  Workflow prepareWorkflow(final String token, final Workflow workflow) throws MalformedURLException, IFlowMessageConversionFailureException;

  List<Workflow> prepareWorkflowList(final String token, final List<Workflow> workflowList) throws MalformedURLException, IFlowMessageConversionFailureException;
}
