package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.models.base.IWorkflow;

public interface IWorkflowPrepare<W extends IWorkflow> {

  W prepareWorkflow(final Authentication authentication, final W workflow)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  List<W> prepareWorkflowList(Authentication authentication, List<W> workflowList)
      throws MalformedURLException, IFlowMessageConversionFailureException;
}
