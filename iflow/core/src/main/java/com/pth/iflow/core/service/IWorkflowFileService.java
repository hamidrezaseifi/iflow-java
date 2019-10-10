package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.WorkflowFile;

public interface IWorkflowFileService {

  public WorkflowFile save(WorkflowFile model);

  public WorkflowFile getByIdentity(String identity);

  public List<WorkflowFile> getListByIdWorkflowId(final String identity);

}
