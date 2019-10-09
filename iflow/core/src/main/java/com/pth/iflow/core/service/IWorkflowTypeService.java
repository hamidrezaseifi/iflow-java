package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeService {

  WorkflowType save(WorkflowType model);

  WorkflowType getById(Long id);

  Set<WorkflowType> getListByIdCompanyId(final Long id);

  Set<WorkflowTypeStep> getStepsById(final Long id);

  Set<WorkflowType> getListByIdList(final Set<Long> idList);

  Set<WorkflowType> getListByIdentityList(final Set<String> idList);
}
