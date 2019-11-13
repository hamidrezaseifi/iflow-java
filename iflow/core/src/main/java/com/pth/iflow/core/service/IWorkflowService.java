package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;
import com.pth.iflow.core.model.workflow.IWorkflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;

public interface IWorkflowService<W extends IWorkflow> {

  public W save(W model);

  public W getByIdentity(String identity);

  public List<W> getListForUser(final String email, final int status);

  public List<W> getListByIdentityList(final Collection<String> idList);

  public List<W> search(final WorkflowSearchFilter workflowSearchFilter);
}
