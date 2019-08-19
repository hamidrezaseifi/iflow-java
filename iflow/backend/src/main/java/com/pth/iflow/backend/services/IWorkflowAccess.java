package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendWorkflow;
import com.pth.iflow.backend.models.BackendWorkflowCreateRequest;
import com.pth.iflow.backend.models.BackendWorkflowType;

public interface IWorkflowAccess {

  BackendWorkflow readWorkflow(final Long workflowId) throws BackendCustomizedException, MalformedURLException;

  List<BackendWorkflow> createWorkflow(final BackendWorkflowCreateRequest createRequest)
      throws BackendCustomizedException, MalformedURLException;

  BackendWorkflow saveWorkflow(final BackendWorkflow workflow) throws BackendCustomizedException, MalformedURLException;

  List<BackendWorkflow> readWorkflowList(final Long companyId) throws BackendCustomizedException, MalformedURLException;

  List<BackendWorkflowType> readWorkflowTypeList(final Long companyId) throws BackendCustomizedException, MalformedURLException;

}
