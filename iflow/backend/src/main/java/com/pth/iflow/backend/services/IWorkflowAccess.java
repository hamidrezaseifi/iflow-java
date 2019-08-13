package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendWorkflow;
import com.pth.iflow.backend.models.BackendWorkflowType;

public interface IWorkflowAccess {

  BackendWorkflow readWorkflow(final Long workflowId, final String token) throws BackendCustomizedException, MalformedURLException;

  BackendWorkflow saveWorkflow(final BackendWorkflow workflow, final String token) throws BackendCustomizedException, MalformedURLException;

  List<BackendWorkflow> readWorkflowList(final Long companyId, final String token) throws BackendCustomizedException, MalformedURLException;

  List<BackendWorkflowType> readWorkflowTypeList(final Long companyId, final String token)
      throws BackendCustomizedException, MalformedURLException;

}
