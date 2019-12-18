package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.WorkflowTypeStepEdo;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IWorkflowTypeStepService extends ICoreModelEdoMapperService<WorkflowTypeStepEntity, WorkflowTypeStepEdo> {

  WorkflowTypeStepEntity save(WorkflowTypeStepEntity model);

  WorkflowTypeStepEntity getByIdentity(String identity);

  List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowIdentity);

  List<WorkflowTypeStepEntity> getListByIdentityList(final Collection<String> idList);

}
