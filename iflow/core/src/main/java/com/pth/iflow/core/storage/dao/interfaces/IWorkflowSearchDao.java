package com.pth.iflow.core.storage.dao.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;

public interface IWorkflowSearchDao {

  List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList);

}
