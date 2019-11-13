package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.workflow.sub.WorkflowType;
import com.pth.iflow.core.model.workflow.sub.WorkflowTypeStep;

public interface IWorkflowTypeService {

  WorkflowType save(WorkflowType model);

  WorkflowType getByIdentity(String identity);

  List<WorkflowType> getListByIdCompanyId(final String identity);

  List<WorkflowTypeStep> getStepsByIdentity(final String identity);

  List<WorkflowType> getListByIdentityList(final Collection<String> idList);
}
