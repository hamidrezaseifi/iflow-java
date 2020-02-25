package com.pth.iflow.core.storage.dao.helper;

import java.io.Serializable;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.pth.iflow.common.enums.EIdentity;

public abstract class EntityIdentityHelper extends EntityHelper implements ICoreEntityVersion, Serializable {

  private static final long serialVersionUID = -969556071780903419L;

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

}
