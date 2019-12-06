package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.DepartmentGroupRepository;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Repository
public class DepartmentGroupDao extends EntityDaoBase<DepartmentGroupEntity> implements IDepartmentGroupDao {

  @Autowired
  DepartmentGroupRepository    repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public DepartmentGroupEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    return repository.findAllByIdentityList(idList);
  }

  @Override
  protected Class<DepartmentGroupEntity> entityClass() {
    return DepartmentGroupEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
