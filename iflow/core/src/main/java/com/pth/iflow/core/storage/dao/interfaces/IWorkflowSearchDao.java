package com.pth.iflow.core.storage.dao.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;

public interface IWorkflowSearchDao {

  List<WorkflowEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowEntity> readByIdentityList(final Set<String> identityList);

}
