package com.pth.iflow.core.storage.dao.helper;

import java.util.Random;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.pth.iflow.common.enums.EIdentity;

public abstract class EntityHelper {

  public abstract String getIdentity();

  public abstract void setIdentity(String identity);

  public abstract void setVersion(Integer version);

  public abstract Integer getVersion();

  public void increaseVersion() {
    setVersion(getVersion() + 1);
  }

  public boolean isIdentityNew() {
    return EIdentity.isNotSet(getIdentity());
  }

  public abstract String getIdentityPreffix();

  protected String generateIdentity() {

    final Random rand = new Random();
    return String.format(getIdentityPreffix() + "%d-%06d", System.currentTimeMillis(), rand.nextInt(1000000));
  }

  @PrePersist
  public void prePersist() {
    if (isIdentityNew()) {
      setIdentity(generateIdentity());
    }
  }

  @PreUpdate
  public void preUpdate() {
    increaseVersion();
  }
}
