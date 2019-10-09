package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;

public interface IWorkflowService {

  public Workflow save(Workflow model);

  public Workflow getById(Long id);

  public Set<Workflow> getListByTypeId(final Long id);

  public Set<Workflow> getListForUser(final Long id, final int status);

  public Set<Workflow> getListByIdList(final Set<Long> idList);

  public Set<Workflow> getListByIdentityList(final Set<String> idList);

  public Set<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);
}
