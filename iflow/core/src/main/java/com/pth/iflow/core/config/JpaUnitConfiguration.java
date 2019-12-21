package com.pth.iflow.core.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

@Component
public class JpaUnitConfiguration {

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  public EntityManager getEntityManager() {
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    return entityManager;
  }

}
