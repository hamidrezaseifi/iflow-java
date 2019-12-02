package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Service
public class WorkflowTypeService implements IWorkflowTypeService {

  private final IWorkflowTypeDao workflowTypeDao;

  public WorkflowTypeService(@Autowired final IWorkflowTypeDao workflowDao) {
    this.workflowTypeDao = workflowDao;
  }

  @Override
  public WorkflowTypeEntity getByIdentity(final String identity) {
    return this.workflowTypeDao.getByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStepEntity> getStepsByIdentity(final String identity) {
    final WorkflowTypeEntity workflow = getByIdentity(identity);
    return workflow.getSteps();
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdCompanyId(final String identity) {
    return this.workflowTypeDao.getListByCompanyIdentity(identity);
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList) {
    return this.workflowTypeDao.getListByIdentityList(idList);
  }

  @Override
  public WorkflowTypeEntity save(final WorkflowTypeEntity model) {
    if (model.isNew()) {
      return workflowTypeDao.create(model);
    }

    final WorkflowTypeEntity exists = workflowTypeDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);

    return workflowTypeDao.update(model);
  }

  protected WorkflowTypeEntity prepareSavingModel(final WorkflowTypeEntity model) {
    return model;
  }
}
