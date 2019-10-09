package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.helper.CoreModelHelper;

public interface IWorkflowTypeStepService {

  CoreModelHelper save(WorkflowTypeStep model);

  WorkflowTypeStep getById(Long id);

  Set<WorkflowTypeStep> getListByWorkflowTypeId(final Long workflowId);

  Set<WorkflowTypeStep> getListByIdList(final Set<Long> idList);

  Set<WorkflowTypeStep> getListByIdentityList(final Set<String> idList);
}
