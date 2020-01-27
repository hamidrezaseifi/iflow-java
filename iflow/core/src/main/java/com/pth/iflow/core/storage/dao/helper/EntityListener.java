package com.pth.iflow.core.storage.dao.helper;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

public class EntityListener implements PreInsertEventListener, PreUpdateEventListener, PreLoadEventListener {

  private static final long serialVersionUID = 1495712607294830810L;

  @Override
  public boolean onPreUpdate(final PreUpdateEvent event) {

    if (event.getEntity() instanceof EntityIdentityHelper) {
      final EntityIdentityHelper entity = (EntityIdentityHelper) event.getEntity();
      entity.increaseVersion();
    }

    return false;
  }

  @Override
  public boolean onPreInsert(final PreInsertEvent event) {

    if (event.getEntity() instanceof EntityIdentityHelper) {
      final EntityIdentityHelper entity = (EntityIdentityHelper) event.getEntity();
      if (entity.isIdentityNew()) {
        entity.setIdentity(entity.generateIdentity());
        if (entity.getVersion() <= 0) {
          entity.setVersion(1);
        }

      }
      else {
        entity.increaseVersion();
      }
    }

    return false;
  }

  @Override
  public void onPreLoad(final PreLoadEvent event) {

    // TODO Auto-generated method stub

  }

}
