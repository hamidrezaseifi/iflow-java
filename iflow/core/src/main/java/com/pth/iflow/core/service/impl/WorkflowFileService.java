package com.pth.iflow.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.storage.dao.IWorkflowFileDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

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
  public WorkflowFile getById(final Long id) {
    return workflowFileDao.getById(id);
  }

  @Override
  public List<WorkflowFile> getListByIdWorkflowId(final Long id) {
    return workflowFileDao.getListByWorkflowId(id);
  }

}
