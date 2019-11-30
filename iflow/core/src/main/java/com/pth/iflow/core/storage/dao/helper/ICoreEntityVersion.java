package com.pth.iflow.core.storage.dao.helper;

public interface ICoreEntityVersion {

  public void setVersion(Integer version);

  public Integer getVersion();

  public void increaseVersion();

}
