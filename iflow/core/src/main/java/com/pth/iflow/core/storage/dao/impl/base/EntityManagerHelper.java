package com.pth.iflow.core.storage.dao.impl.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.config.JpaUnitConfiguration;

public class EntityManagerHelper {

  @Autowired
  protected JpaUnitConfiguration dbConfiguration;

  @PostConstruct
  public void init() {

  }

}
