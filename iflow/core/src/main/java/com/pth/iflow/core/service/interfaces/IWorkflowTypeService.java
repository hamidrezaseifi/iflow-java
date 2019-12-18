package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.WorkflowTypeEdo;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IWorkflowTypeService extends ICoreModelEdoMapperService<WorkflowTypeEntity, WorkflowTypeEdo> {

  WorkflowTypeEntity save(WorkflowTypeEntity model);

  WorkflowTypeEntity getByIdentity(String identity);

  List<WorkflowTypeEntity> getListByIdCompanyId(final String identity);

  List<WorkflowTypeStepEntity> getStepsByIdentity(final String identity);

  List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList);

}
