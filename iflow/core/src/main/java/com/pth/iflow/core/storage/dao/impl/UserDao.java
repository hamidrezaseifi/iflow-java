package com.pth.iflow.core.storage.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.UserRepository;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@Repository
public class UserDao extends EntityDaoBase<UserEntity> implements IUserDao {

  @Autowired
  UserRepository               repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public UserEntity getByIdentity(final String email) throws IFlowStorageException {

    return repository.findByIdentity(email);
  }

  @Override
  public List<UserEntity> getListByIdentityList(final Set<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public List<UserEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentId(final String identity) throws IFlowStorageException {
    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity>          userRoot        = query.from(UserEntity.class);

    final Join<Object, Object>      departmentJoin  = userRoot.join("departments", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("department").get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    final List<UserEntity>       list       = typedQuery.getResultList();

    return list;
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentGroupId(final String identity) throws IFlowStorageException {

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity>          userRoot        = query.from(UserEntity.class);

    final Join<Object, Object>      departmentJoin  = userRoot.join("departmentGroups", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("departmentGroup").get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    final String                 qr         = DaoHelper.retreiveRawSql(typedQuery);

    final List<UserEntity>       list       = typedQuery.getResultList();

    return list;
  }

  @Override
  protected Class<UserEntity> entityClass() {
    return UserEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }
}
