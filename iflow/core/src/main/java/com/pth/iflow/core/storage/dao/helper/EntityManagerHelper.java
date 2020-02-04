package com.pth.iflow.core.storage.dao.helper;

import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerHelper {

  @PersistenceUnit
  private SessionFactory sessionFactory;

  public Session createSession() {

    final Session session = sessionFactory.openSession();

    return session;
  }

  @PostConstruct
  public void registerListeners() {

    final EventListenerRegistry eventListenerRegistry = ((SessionFactoryImplementor) sessionFactory)
        .getServiceRegistry()
        .getService(EventListenerRegistry.class);

    final Iterable<PreInsertEventListener> listeners = eventListenerRegistry.getEventListenerGroup(EventType.PRE_INSERT).listeners();

    if (StreamSupport.stream(listeners.spliterator(), false).anyMatch(l -> l.getClass() == EntityListener.class) == false) {
      eventListenerRegistry.prependListeners(EventType.PRE_INSERT, EntityListener.class);
      eventListenerRegistry.prependListeners(EventType.PRE_UPDATE, EntityListener.class);

    }

  }

}
