package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.workflow.WorkflowResult;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;

public interface IWorkflowSearchDao {

  List<WorkflowResult> search(final WorkflowSearchFilter workflowSearchFilter);

}
