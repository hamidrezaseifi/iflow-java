package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;

public interface IWorkflowService {

  public Workflow save(Workflow model);

  public Workflow getById(Long id);

  public List<Workflow> getListByTypeId(final Long id);

  public List<Workflow> getListForUser(final Long id, final int status);

  public List<Workflow> getListByIdList(final Set<Long> idList);

  public List<Workflow> getListByIdentityList(final Set<String> idList);

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);
}
