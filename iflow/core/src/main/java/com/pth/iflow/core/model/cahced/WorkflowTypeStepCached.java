package com.pth.iflow.core.model.cahced;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

public class WorkflowTypeStepCached extends WorkflowTypeStep implements ICachedModel {

  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public WorkflowTypeStepCached(@Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.workflowTypeStepDao = workflowStepDao;

  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(workflowTypeStepDao.getById(getId()));
    }

  }
}
