package com.pth.iflow.common.edo.models.helper;

import com.pth.iflow.common.enums.EWorkflowIdentity;

public abstract class IdentityModel {

  abstract public String getIdentity();

  abstract public void setIdentity(final String identity);

  public boolean isNew() {
    return this instanceof IdentityModel && isIdentityNew(getIdentity());
  }

  public boolean isIdentityNew(final String identity) {
    return EWorkflowIdentity.isNotSet(identity);
  }

}