package com.pth.iflow.core.storage.dao.helper;

import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerHelper {

  // @Qualifier("entityManagerFactoryWidthListener")
  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  protected EntityManager createEntityManager() {

    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    return entityManager;
  }

  @PostConstruct
  public void registerListeners() {

    final EventListenerRegistry eventListenerRegistry = ((SessionFactoryImplementor) entityManagerFactory)
        .getServiceRegistry()
        .getService(EventListenerRegistry.class);

    final Iterable<PreInsertEventListener> listeners = eventListenerRegistry.getEventListenerGroup(EventType.PRE_INSERT).listeners();

    if (StreamSupport.stream(listeners.spliterator(), false).anyMatch(l -> l.getClass() == EntityListener.class) == false) {
      eventListenerRegistry.prependListeners(EventType.PRE_INSERT, EntityListener.class);
      eventListenerRegistry.prependListeners(EventType.PRE_UPDATE, EntityListener.class);
    }

  }

}
