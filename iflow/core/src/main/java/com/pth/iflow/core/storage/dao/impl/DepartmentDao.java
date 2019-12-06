package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.DepartmentRepository;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@Repository
public class DepartmentDao extends EntityDaoBase<DepartmentEntity> implements IDepartmentDao {

  @Autowired
  DepartmentRepository         repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public DepartmentEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<DepartmentEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  public List<DepartmentEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    return repository.findAllByIdentityList(idList);
  }

  @Override
  protected Class<DepartmentEntity> entityClass() {
    return DepartmentEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
