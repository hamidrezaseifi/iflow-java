package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

public interface IWorkflowTypeService {

  WorkflowType save(WorkflowType model);

  WorkflowType getById(Long id);

  List<WorkflowType> getListByIdCompanyId(final Long id);

  List<WorkflowTypeStep> getStepsById(final Long id);

  List<WorkflowType> getListByIdList(final Set<Long> idList);

  List<WorkflowType> getListByIdentityList(final Set<String> idList);
}
