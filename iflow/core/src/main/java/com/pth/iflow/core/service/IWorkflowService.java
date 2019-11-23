package com.pth.iflow.core.service;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.workflow.IWorkflow;

public interface IWorkflowService<W extends IWorkflow> {

  public W save(W model);

  public W getByIdentity(String identity);

  public List<W> getListForUser(final String email, final int status);

  public List<W> getListByIdentityList(final Collection<String> idList);

}
