package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@Repository
public class DepartmentDao extends EntityDaoBase<DepartmentEntity> implements IDepartmentDao {

  @Override
  protected Class<DepartmentEntity> entityClass() {

    return DepartmentEntity.class;
  }

  @Override
  public List<DepartmentEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    final EntityManager entityManager = createEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<DepartmentEntity> query = criteriaBuilder.createQuery(DepartmentEntity.class);
    final Root<DepartmentEntity> root = query.from(DepartmentEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<DepartmentEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<DepartmentEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;

  }

}
