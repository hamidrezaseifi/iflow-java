package com.pth.iflow.core.storage.dao.impl;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Repository
public class DepartmentGroupDao extends EntityDaoBase<DepartmentGroupEntity> implements IDepartmentGroupDao {

  @Override
  protected Class<DepartmentGroupEntity> entityClass() {
    return DepartmentGroupEntity.class;
  }

}
