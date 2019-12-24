package com.pth.iflow.core.storage.dao.impl.workflow;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Repository
public class WorkflowDao extends EntityDaoBase<WorkflowEntity> implements IWorkflowDao {

  @Override
  protected Class<WorkflowEntity> entityClass() {
    return WorkflowEntity.class;
  }

}
