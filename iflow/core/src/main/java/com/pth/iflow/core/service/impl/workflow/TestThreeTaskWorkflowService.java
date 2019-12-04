package com.pth.iflow.core.service.impl.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.workflow.ITestThreeTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ITestThreeTaskWorkflowDao;

@Service
public class TestThreeTaskWorkflowService extends CoreModelEdoMapperService<TestThreeTaskWorkflowEntity, TestThreeTaskWorkflowEdo>
    implements ITestThreeTaskWorkflowService {

  private final ITestThreeTaskWorkflowDao testThreeTaskWorkflowDao;

  private final IWorkflowService          workflowService;

  public TestThreeTaskWorkflowService(@Autowired final ITestThreeTaskWorkflowDao workflowDao,
      @Autowired final IWorkflowService workflowService) {
    this.testThreeTaskWorkflowDao = workflowDao;
    this.workflowService = workflowService;
  }

  @Override
  public TestThreeTaskWorkflowEntity save(final TestThreeTaskWorkflowEntity model) {

    if (model.isNew()) {

      return testThreeTaskWorkflowDao.create(model);
    }

    final TestThreeTaskWorkflowEntity exists = testThreeTaskWorkflowDao.getById(model.getWorkflowId());
    model.verifyVersion(exists);

    return testThreeTaskWorkflowDao.update(model);

  }

  @Override
  public TestThreeTaskWorkflowEntity getByIdentity(final String identity) {
    return this.testThreeTaskWorkflowDao.getByIdentity(identity);
  }

  @Override
  public List<TestThreeTaskWorkflowEntity> getListForUser(final String email, final int status) {

    return this.testThreeTaskWorkflowDao.getListForUserIdentity(email, status);
  }

  @Override
  public List<TestThreeTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return this.testThreeTaskWorkflowDao.getListByIdentityList(idList);
  }

  @Override
  public TestThreeTaskWorkflowEntity fromEdo(final TestThreeTaskWorkflowEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final TestThreeTaskWorkflowEntity model = new TestThreeTaskWorkflowEntity();

    model.setWorkflow(workflowService.fromEdo(edo.getWorkflow()));

    return model;
  }

  @Override
  public TestThreeTaskWorkflowEdo toEdo(final TestThreeTaskWorkflowEntity model) {
    final TestThreeTaskWorkflowEdo edo = new TestThreeTaskWorkflowEdo();
    edo.setWorkflow(workflowService.toEdo(model.getWorkflow()));

    return edo;
  }
}
