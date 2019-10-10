package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowSearchFilter;

public interface IWorkflowService {

  public Workflow save(Workflow model);

  public Workflow getByIdentity(String identity);

  public List<Workflow> getListByTypeId(final String identity);

  public List<Workflow> getListForUser(final String email, final int status);

  public List<Workflow> getListByIdentityList(final Set<String> idList);

  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter);
}
