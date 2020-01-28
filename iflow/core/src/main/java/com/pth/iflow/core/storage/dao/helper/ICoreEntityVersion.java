package com.pth.iflow.core.storage.dao.helper;

public interface ICoreEntityVersion {

  void setVersion(Integer version);

  Integer getVersion();

  void increaseVersion();

  Long getId();

  void setId(Long id);

}
