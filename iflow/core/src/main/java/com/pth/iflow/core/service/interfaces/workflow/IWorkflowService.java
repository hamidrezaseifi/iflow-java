package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.workflow.WorkflowEdo;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IWorkflowService extends ICoreModelEdoMapperService<WorkflowEntity, WorkflowEdo> {

  public WorkflowEntity save(WorkflowEntity model);

  public WorkflowEntity getByIdentity(String identity);

  public List<WorkflowEntity> getListForUser(final String email, final int status);

  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList);

  @Override
  public WorkflowEdo toEdo(final WorkflowEntity model);

  @Override
  public WorkflowEntity fromEdo(final WorkflowEdo edo) throws IFlowMessageConversionFailureException;

}
