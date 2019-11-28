package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;

public interface IWorkflowSearchService {

  public List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList);
}
