package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowFileDao;

@Service
public class WorkflowFileService implements IWorkflowFileService {

  private final IWorkflowFileDao workflowFileDao;

  public WorkflowFileService(@Autowired final IWorkflowFileDao workflowFileDao) {
    this.workflowFileDao = workflowFileDao;
  }

  @Override
  public WorkflowFile save(final WorkflowFile model) {
    if (model.isNew()) {
      model.increaseVersion();
      return workflowFileDao.create(model, true);
    }

    final WorkflowFile exists = workflowFileDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("WorkflowFile with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return workflowFileDao.update(model, true);
  }

  @Override
  public WorkflowFile getByIdentity(final String identity) {
    return workflowFileDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowFile> getListByIdWorkflowIdentity(final String identity) {
    return workflowFileDao.getListByWorkflowIdentity(identity);
  }

}
