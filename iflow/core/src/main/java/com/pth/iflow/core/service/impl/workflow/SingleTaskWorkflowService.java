package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.ISingleTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ISingleTaskWorkflowDao;

@Service
public class SingleTaskWorkflowService implements ISingleTaskWorkflowService {

  private final ISingleTaskWorkflowDao singleTaskWorkflowDao;

  private final IWorkflowService       workflowService;

  public SingleTaskWorkflowService(@Autowired final ISingleTaskWorkflowDao singleTaskorkflowDao,
      @Autowired final IWorkflowService workflowService) {
    this.singleTaskWorkflowDao = singleTaskorkflowDao;
    this.workflowService = workflowService;
  }

  @Override
  public SingleTaskWorkflowEntity save(final SingleTaskWorkflowEntity model) {

    prepareSavingModel(model);
    if (model.isNew()) {

      return singleTaskWorkflowDao.create(model);
    }

    final SingleTaskWorkflowEntity exists = singleTaskWorkflowDao.getById(model.getWorkflowId());
    model.verifyVersion(exists);

    return singleTaskWorkflowDao.update(model);

  }

  @Override
  public SingleTaskWorkflowEntity getByIdentity(final String identity) {
    return this.singleTaskWorkflowDao.getByIdentity(identity);
  }

  @Override
  public List<SingleTaskWorkflowEntity> getListForUser(final String email, final int status) {

    return this.singleTaskWorkflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<SingleTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.singleTaskWorkflowDao.getListByIdentityList(idList);
  }

  protected SingleTaskWorkflowEntity prepareSavingModel(final SingleTaskWorkflowEntity model) {
    workflowService.prepareSavingModel(model.getWorkflow());
    return model;
  }
}
