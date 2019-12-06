package com.pth.iflow.core.storage.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.IflowRoleEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.DepartmentRepository;
import com.pth.iflow.core.storage.dao.interfaces.IIflowRoleDao;

@Repository
public class IflowRoleDao extends EntityDaoBase<IflowRoleEntity> implements IIflowRoleDao {

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
  protected Class<IflowRoleEntity> entityClass() {
    return IflowRoleEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
