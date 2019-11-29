package com.pth.iflow.core.storage.dao.helper;

import java.util.Random;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

public abstract class EntityHelper {

  public abstract String getIdentity();

  public abstract void setIdentity(String identity);

  public abstract void setVersion(Integer version);

  public abstract Integer getVersion();

  public abstract Long getId();

  public void increaseVersion() {
    setVersion(getVersion() + 1);
  }

  public boolean isIdentityNew() {
    return EIdentity.isNotSet(getIdentity());
  }

  public abstract String getIdentityPreffix();

  public String generateIdentity() {

    final Random rand = new Random();
    return String.format(getIdentityPreffix() + "%d-%06d", System.currentTimeMillis(), rand.nextInt(1000000));
  }

  public boolean isNew() {

    return getId() == null || getId() <= 0;
  }

  public void verifyVersion(final EntityHelper exists) {

    if (exists.getVersion() > getVersion()) {
      throw new IFlowOptimisticLockException(this.getClass().getTypeName() + " with id " + getId() + " is old!");
    }
  }

}
