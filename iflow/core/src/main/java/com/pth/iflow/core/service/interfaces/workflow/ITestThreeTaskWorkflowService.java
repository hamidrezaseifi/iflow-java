package com.pth.iflow.core.service.interfaces.workflow;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.edo.models.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ITestThreeTaskWorkflowService
    extends ICoreModelEdoMapperService<TestThreeTaskWorkflowEntity, TestThreeTaskWorkflowEdo> {

  public TestThreeTaskWorkflowEntity save(TestThreeTaskWorkflowEntity model);

  public TestThreeTaskWorkflowEntity getByIdentity(String identity);

  public List<TestThreeTaskWorkflowEntity> getListForUser(final String email, final int status);

  public List<TestThreeTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList);

}
