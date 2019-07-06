package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeStepService {

  WorkflowTypeStep save(WorkflowTypeStep model);

  WorkflowTypeStep getById(Long id);

  List<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId);

  List<WorkflowTypeStep> getListByIdList(final List<Long> idList);
}
