package com.pth.iflow.core.storage.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.CompanyRepository;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Repository
public class CompanyDao extends EntityDaoBase<CompanyEntity> implements ICompanyDao {

  @Autowired
  CompanyRepository            repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  public CompanyDao() {

  }

  @Override
  public CompanyEntity getByIdentity(final String identity) {
    return repository.findByIdentity(identity);
  }

  @Override
  protected Class<CompanyEntity> entityClass() {
    return CompanyEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }

}
