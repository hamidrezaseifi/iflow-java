package com.pth.iflow.core.service.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultEdo;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IWorkflowSearchService extends ICoreModelEdoMapperService<WorkflowResultEntity, WorkflowResultEdo> {

  public List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList);

  public WorkflowSearchFilter fromWorkflowSearchFilterEdo(WorkflowSearchFilterEdo workflowSearchFilterEdo);
}
