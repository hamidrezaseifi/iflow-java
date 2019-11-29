package com.pth.iflow.core.storage.dao.helper;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EntityListener {

  @PrePersist
  public void prePersist(final EntityHelper entity) {
    if (entity.isIdentityNew()) {
      entity.setIdentity(entity.generateIdentity());
      if (entity.getVersion() <= 0) {
        entity.setVersion(1);
      }

    }
  }

  @PreUpdate
  public void preUpdate(final EntityHelper entity) {
    entity.increaseVersion();

  }

}
