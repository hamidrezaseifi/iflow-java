package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.workflow.WorkflowResult;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;

public interface IWorkflowSearchService {

  public List<WorkflowResult> search(final WorkflowSearchFilter workflowSearchFilter);
}
