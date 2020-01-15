package com.pth.iflow.core.storage.dao.impl.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@Transactional
public class EntityManagerHelper {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  protected EntityManager createEntityManager() {

    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    return entityManager;
  }

}
