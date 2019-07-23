package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.Workflow;

public interface IWorkflowService {

  public Workflow save(Workflow model);

  public Workflow getById(Long id);

  public List<Workflow> getListByTypeId(final Long id);

  public List<Workflow> getListForUser(final Long id, final int status);

  public List<Workflow> getListByIdList(final List<Long> idList);
}
