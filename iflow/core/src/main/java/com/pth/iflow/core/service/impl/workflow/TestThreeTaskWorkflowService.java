package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.workflow.TestThreeTaskWorkflow;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Service
public class TestThreeTaskWorkflowService implements IWorkflowService<TestThreeTaskWorkflow> {

  private final IWorkflowDao<TestThreeTaskWorkflow> invoiceWorkflowDao;

  public TestThreeTaskWorkflowService(@Autowired final IWorkflowDao<TestThreeTaskWorkflow> invoiceWorkflowDao) {
    this.invoiceWorkflowDao = invoiceWorkflowDao;
  }

  @Override
  public TestThreeTaskWorkflow save(final TestThreeTaskWorkflow model) {
    TestThreeTaskWorkflow exists = null;
    if (model.isIdentityNotSet() == false) {
      exists = this.getByIdentity(model.getIdentity());
      model.setId(exists.getId());
    }

    if (model.isNew()) {
      model.increaseVersion();
      return this.invoiceWorkflowDao.create(model);
    }

    exists = exists != null ? exists : this.invoiceWorkflowDao.getById(model.getId());

    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("TestThreeTaskWorkflow with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.invoiceWorkflowDao.update(model);
  }

  @Override
  public TestThreeTaskWorkflow getByIdentity(final String identity) {
    return this.invoiceWorkflowDao.getByIdentity(identity);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListForUser(final String email, final int status) {

    return this.invoiceWorkflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListByIdentityList(final Collection<String> idList) {

    return this.invoiceWorkflowDao.getListByIdentityList(idList);
  }

}
