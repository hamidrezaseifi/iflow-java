package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;

public interface IWorkflowTypeService {

  WorkflowTypeEntity save(WorkflowTypeEntity model);

  WorkflowTypeEntity getByIdentity(String identity);

  List<WorkflowTypeEntity> getListByIdCompanyId(final String identity);

  List<WorkflowTypeStepEntity> getStepsByIdentity(final String identity);

  List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList);
}
