package com.pth.iflow.core.storage.dao.impl;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.IflowRoleEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IIflowRoleDao;

@Repository
public class IflowRoleDao extends EntityDaoBase<IflowRoleEntity> implements IIflowRoleDao {

  @Override
  protected Class<IflowRoleEntity> entityClass() {
    return IflowRoleEntity.class;
  }

}
