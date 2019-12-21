package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@Repository
public class UserDao extends EntityDaoBase<UserEntity> implements IUserDao {

  @Override
  public UserEntity getByIdentity(final String identity) throws IFlowStorageException {
    final EntityManager             entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(entityClass());
    final Root<UserEntity>          root            = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("email");
    final Predicate    predicate    = criteriaBuilder.equal(identityPath, identity);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final UserEntity             result     = typedQuery.getSingleResult();
    entityManager.close();
    return result;
  }

  @Override
  public List<UserEntity> getListByIdentityList(final Collection<String> identityList) {
    final EntityManager             entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(entityClass());
    final Root<UserEntity>          root            = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("email");
    final Predicate    predicate    = identityPath.in(identityList);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<UserEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {
    final EntityManager             entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity>          root            = query.from(UserEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate    predicate           = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<UserEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentId(final String identity) throws IFlowStorageException {
    final EntityManager             entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity>          userRoot        = query.from(UserEntity.class);

    final Join<Object, Object>      departmentJoin  = userRoot.join("departments", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    final List<UserEntity>       list       = typedQuery.getResultList();

    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentGroupId(final String identity) throws IFlowStorageException {
    final EntityManager             entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder           criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query           = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity>          userRoot        = query.from(UserEntity.class);

    final Join<Object, Object>      departmentJoin  = userRoot.join("departmentGroups", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    final String                 qr         = DaoHelper.retreiveRawSql(typedQuery);

    final List<UserEntity>       list       = typedQuery.getResultList();

    entityManager.close();
    return list;
  }

  @Override
  protected Class<UserEntity> entityClass() {
    return UserEntity.class;
  }

}
