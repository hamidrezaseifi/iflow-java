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
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@Transactional
@Repository
public class UserDao extends EntityDaoBase<UserEntity> implements IUserDao {

  @Override
  public UserEntity create(final UserEntity model) throws IFlowStorageException {

    final UserEntity savedModel = super.create(model);

    return savedModel;
  }

  @Override
  public UserEntity update(final UserEntity model) throws IFlowStorageException {

    final UserEntity savedModel = super.update(model);
    return getById(savedModel.getId());
  }

  @Override
  public UserEntity getByEmail(final String email) {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(entityClass());
    final Root<UserEntity> root = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("email");
    final Predicate predicate = criteriaBuilder.equal(identityPath, email);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    final List<UserEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list.size() > 0 ? list.get(0) : null;
  }

  @Override
  public UserEntity getByIdentity(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(entityClass());
    final Root<UserEntity> root = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("identity");
    final Predicate predicate = criteriaBuilder.equal(identityPath, identity);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<UserEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list.size() > 0 ? list.get(0) : null;
  }

  @Override
  public List<UserEntity> getListByIdentityList(final Collection<String> identityList) {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(entityClass());
    final Root<UserEntity> root = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("identity");
    final Predicate predicate = identityPath.in(identityList);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<UserEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity> root = query.from(UserEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<UserEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentId(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity> userRoot = query.from(UserEntity.class);

    final Join<Object, Object> departmentJoin = userRoot.join("departments", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    final List<UserEntity> list = typedQuery.getResultList();

    entityManager.close();
    return list;
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentGroupId(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity> userRoot = query.from(UserEntity.class);

    final Join<Object, Object> departmentJoin = userRoot.join("departmentGroups", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(departmentJoin.get("identity"), identity));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);

    final String qr = DaoHelper.retreiveRawSql(typedQuery);

    final List<UserEntity> list = typedQuery.getResultList();

    entityManager.close();
    return list;
  }

  @Override
  protected Class<UserEntity> entityClass() {

    return UserEntity.class;
  }

  @Override
  public UserEntity getLastIdentity(final Long companyId) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);

    final Root<UserEntity> userRoot = query.from(UserEntity.class);
    final Path<String> companyIdPath = userRoot.get("companyId");
    final Predicate predicate = criteriaBuilder.equal(companyIdPath, companyId);
    query.where(predicate);

    query.orderBy(criteriaBuilder.desc(userRoot.get("identity")));

    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    typedQuery.setMaxResults(1);
    typedQuery.setFirstResult(0);

    final List<UserEntity> list = typedQuery.getResultList();

    return list.size() > 0 ? list.get(0) : null;
  }

}
