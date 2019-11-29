package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;

public interface IWorkflowService {

  public WorkflowEntity save(WorkflowEntity model);

  public WorkflowEntity getByIdentity(String identity);

  public List<WorkflowEntity> getListForUser(final String email, final int status);

  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
