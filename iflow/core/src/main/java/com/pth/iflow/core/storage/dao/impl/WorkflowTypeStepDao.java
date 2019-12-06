package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowTypeStepRepository;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@Repository
public class WorkflowTypeStepDao extends EntityDaoBase<WorkflowTypeStepEntity> implements IWorkflowTypeStepDao {

  @Autowired
  WorkflowTypeStepRepository   repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public WorkflowTypeStepEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowTypeIdentity) throws IFlowStorageException {

    return repository.findAllByWorkflowTypeIdentity(workflowTypeIdentity);
  }

  @Override
  protected Class<WorkflowTypeStepEntity> entityClass() {
    return WorkflowTypeStepEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }

}
