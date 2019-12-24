package com.pth.iflow.core.storage.dao.impl.workflow;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.storage.dao.impl.base.WorkflowParentEntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ISingleTaskWorkflowDao;

@Repository
public class SingleTaskWorkflowDao extends WorkflowParentEntityDaoBase<SingleTaskWorkflowEntity> implements ISingleTaskWorkflowDao {

  @Override
  protected Class<SingleTaskWorkflowEntity> entityClass() {
    return SingleTaskWorkflowEntity.class;
  }

}
