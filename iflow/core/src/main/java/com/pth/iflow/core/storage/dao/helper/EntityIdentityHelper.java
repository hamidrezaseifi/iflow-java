package com.pth.iflow.core.storage.dao.helper;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

public abstract class EntityIdentityHelper implements ICoreEntityVersion {

  public abstract String getIdentity();

  public abstract void setIdentity(String identity);

  public boolean isIdentityNew() {
    return EIdentity.isNotSet(getIdentity());
  }

  public abstract String getIdentityPreffix();

  public String generateIdentity() {

    final Random rand = new Random();
    return String.format(getIdentityPreffix() + "%d-%06d", System.currentTimeMillis(), rand.nextInt(1000000));
  }

  public boolean hasTheSameIdentity(final String identity) {

    return StringUtils.isEmpty(this.getIdentity()) == false && this.getIdentity().equals(identity);
  }

  public boolean isNew() {

    return getId() == null || getId() <= 0;
  }

  public void verifyVersion(final EntityIdentityHelper exists) {

    if (exists.getVersion() > getVersion()) {
      throw new IFlowOptimisticLockException(this.getClass().getTypeName() + " with id " + getId() + " is old!");
    }
  }

}
