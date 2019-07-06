package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowFile;

public interface IWorkflowFileService {

  public WorkflowFile save(WorkflowFile model);

  public WorkflowFile getById(Long id);

  public List<WorkflowFile> getListByIdWorkflowId(final Long id);

}
