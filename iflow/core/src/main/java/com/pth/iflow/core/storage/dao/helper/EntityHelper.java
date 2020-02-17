package com.pth.iflow.core.storage.dao.helper;

import java.io.Serializable;

import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

public abstract class EntityHelper implements ICoreEntityVersion, Serializable {

  private static final long serialVersionUID = -969556071780903419L;

  public boolean isNew() {

    return getId() == null || getId() <= 0;
  }

  public void verifyVersion(final EntityHelper exists) {

    if (exists.getVersion() > getVersion()) {
      throw new IFlowOptimisticLockException(this.getClass().getTypeName() + " with id " + getId() + " is old!");
    }
  }

}
