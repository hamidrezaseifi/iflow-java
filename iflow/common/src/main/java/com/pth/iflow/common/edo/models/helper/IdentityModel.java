package com.pth.iflow.common.edo.models.helper;

import org.apache.commons.lang3.StringUtils;

import com.pth.iflow.common.enums.EWorkflowIdentity;

public abstract class IdentityModel {

  abstract public String getIdentity();

  abstract public void setIdentity(final String identity);

  public boolean isNew() {
    return this instanceof IdentityModel && IdentityModel.isIdentityNew(this.getIdentity());
  }

  public void setIdentityToNew() {
    this.setIdentity("");
  }

  public static boolean isIdentityNew(final String identity) {
    return EWorkflowIdentity.isNotSet(identity);
  }

  public boolean hasSameIdentity(final String identity) {
    return (StringUtils.isEmpty(this.getIdentity()) && StringUtils.isEmpty(identity)) || this.getIdentity().equals(identity);
  }

}