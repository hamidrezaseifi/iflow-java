package com.pth.iflow.common.edo.models.base;

public abstract class DataModelBase {

  public DataModelBase() {

  }

  public boolean isNew() {
    return (this.getId() == null) || (this.getId() <= 0);
  }

  public abstract Integer getVersion();

  public abstract Long getId();

  public abstract void setVersion(final Integer version);

  public void increaseVersion() {
    this.setVersion(this.getVersion() == null ? 1 : this.getVersion() + 1);
  }

}
