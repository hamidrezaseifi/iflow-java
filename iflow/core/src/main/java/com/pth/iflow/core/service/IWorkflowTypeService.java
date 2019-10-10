package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeService {

  WorkflowType save(WorkflowType model);

  WorkflowType getByIdentity(String identity);

  List<WorkflowType> getListByIdCompanyId(final String identity);

  List<WorkflowTypeStep> getStepsByIdentity(final String identity);

  List<WorkflowType> getListByIdentityList(final Set<String> idList);
}
