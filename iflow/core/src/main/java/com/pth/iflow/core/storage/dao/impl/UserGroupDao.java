package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Transactional
@Repository
public class UserGroupDao extends EntityDaoBase<UserGroupEntity> implements IUserGroupDao {

  @Override
  public List<UserGroupEntity> getListByIdList(final Collection<Long> idList) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<UserGroupEntity> query = criteriaBuilder.createQuery(entityClass());
    final Root<UserGroupEntity> root = query.from(entityClass());
    query.select(root);

    final Path<Long> identityPath = root.get("id");
    final Predicate predicate = identityPath.in(idList);
    query.where(predicate);

    final TypedQuery<UserGroupEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<UserGroupEntity> list = typedQuery.getResultList();
    session.close();
    return list;
  }

  @Override
  public List<UserGroupEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<UserGroupEntity> query = criteriaBuilder.createQuery(UserGroupEntity.class);
    final Root<UserGroupEntity> root = query.from(UserGroupEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<UserGroupEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<UserGroupEntity> list = typedQuery.getResultList();
    session.close();
    return list;

  }

  @Override
  protected Class<UserGroupEntity> entityClass() {

    return UserGroupEntity.class;
  }

}
