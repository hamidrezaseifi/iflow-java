package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.models.base.IWorkflow;

public interface IWorkflowPrepare<W extends IWorkflow> {

  W prepareWorkflow(final String token, final W workflow) throws MalformedURLException, IFlowMessageConversionFailureException;

  List<W> prepareWorkflowList(final String token, final List<W> workflowList)
      throws MalformedURLException, IFlowMessageConversionFailureException;
}
