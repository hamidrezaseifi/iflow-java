package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pth.iflow.common.enums.EUserDepartmentMemberType;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Repository
public class DepartmentGroupDao extends EntityDaoBase<DepartmentGroupEntity> implements IDepartmentGroupDao {

  @Override
  protected Class<DepartmentGroupEntity> entityClass() {

    return DepartmentGroupEntity.class;
  }

  @Override
  public UserEntity getDepartmentGroupManager(final String identity) {

    final EntityManager entityManager = createEntityManager();
    final TypedQuery<UserEntity> query = entityManager.createNamedQuery("findDepartmentGroupMember", UserEntity.class);
    query.setParameter("identity", identity);
    query.setParameter("memtype", EUserDepartmentMemberType.MANAGER.getValue());

    final List<UserEntity> results = query.getResultList();

    entityManager.close();

    return results.size() > 0 ? results.get(0) : null;
  }

  @Override
  public UserEntity getDepartmentGroupDeputy(final String identity) {

    final EntityManager entityManager = createEntityManager();
    final TypedQuery<UserEntity> query = entityManager.createNamedQuery("findDepartmentGroupMember", UserEntity.class);
    query.setParameter("identity", identity);
    query.setParameter("memtype", EUserDepartmentMemberType.DEPUTY.getValue());

    final List<UserEntity> results = query.getResultList();

    entityManager.close();

    return results.size() > 0 ? results.get(0) : null;
  }

}
