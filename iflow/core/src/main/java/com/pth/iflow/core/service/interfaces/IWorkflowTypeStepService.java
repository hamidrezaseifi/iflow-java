package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;

public interface IWorkflowTypeStepService {

  WorkflowTypeStepEntity save(WorkflowTypeStepEntity model);

  WorkflowTypeStepEntity getByIdentity(String identity);

  List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowIdentity);

  List<WorkflowTypeStepEntity> getListByIdentityList(final Collection<String> idList);
}
