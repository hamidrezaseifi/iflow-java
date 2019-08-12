package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.Workflow;
import com.pth.iflow.backend.models.WorkflowType;

public interface IWorkflowAccess {

  Workflow readWorkflow(final Long workflowId, final String token) throws BackendCustomizedException, MalformedURLException;

  Workflow saveWorkflow(final Workflow workflow, final String token) throws BackendCustomizedException, MalformedURLException;

  List<Workflow> readWorkflowList(final Long companyId, final String token) throws BackendCustomizedException, MalformedURLException;

  List<WorkflowType> readWorkflowTypeList(final Long companyId, final String token)
      throws BackendCustomizedException, MalformedURLException;

}
