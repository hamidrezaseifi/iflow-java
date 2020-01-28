package com.pth.iflow.core.storage.dao.helper;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

public class EntityListener implements PreInsertEventListener {

  private static final long serialVersionUID = 1495712607294830810L;

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

}
