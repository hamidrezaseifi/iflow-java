package com.pth.iflow.core.storage.dao;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.entity.WorkflowResultEntity;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;

public interface IWorkflowSearchDao {

  List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList);

}
