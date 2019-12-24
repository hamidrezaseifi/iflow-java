package com.pth.iflow.core.storage.dao.impl.workflow;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.storage.dao.impl.base.WorkflowParentEntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ITestThreeTaskWorkflowDao;

@Repository
public class TestThreeTaskWorkflowDao extends WorkflowParentEntityDaoBase<TestThreeTaskWorkflowEntity> implements ITestThreeTaskWorkflowDao {

  @Override
  protected Class<TestThreeTaskWorkflowEntity> entityClass() {
    return TestThreeTaskWorkflowEntity.class;
  }

}
