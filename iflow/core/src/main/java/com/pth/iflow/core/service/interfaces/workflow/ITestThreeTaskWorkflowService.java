package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;

public interface ITestThreeTaskWorkflowService {

  public TestThreeTaskWorkflowEntity save(TestThreeTaskWorkflowEntity model);

  public TestThreeTaskWorkflowEntity getByIdentity(String identity);

  public List<TestThreeTaskWorkflowEntity> getListForUser(final String email, final int status);

  public List<TestThreeTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
