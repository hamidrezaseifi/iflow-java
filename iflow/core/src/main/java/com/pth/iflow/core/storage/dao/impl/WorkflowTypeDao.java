package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowTypeRepository;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Repository
public class WorkflowTypeDao extends EntityDaoBase<WorkflowTypeEntity> implements IWorkflowTypeDao {

  @Autowired
  WorkflowTypeRepository       repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public WorkflowTypeEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  protected Class<WorkflowTypeEntity> entityClass() {
    return WorkflowTypeEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
