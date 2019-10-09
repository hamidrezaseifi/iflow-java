package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.WorkflowFile;

public interface IWorkflowFileService {

  public WorkflowFile save(WorkflowFile model);

  public WorkflowFile getById(Long id);

  public Set<WorkflowFile> getListByIdWorkflowId(final Long id);

}
