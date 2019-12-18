package com.pth.iflow.core.service.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowEdo;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IWorkflowSearchService extends ICoreModelEdoMapperService<WorkflowEntity, WorkflowEdo> {

  public List<WorkflowEntity> search(final WorkflowSearchFilter workflowSearchFilter);

  public List<WorkflowEntity> readByIdentityList(final Set<String> identityList);

  public WorkflowSearchFilter fromWorkflowSearchFilterEdo(WorkflowSearchFilterEdo workflowSearchFilterEdo);
}
