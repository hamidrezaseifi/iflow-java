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

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Repository
public class WorkflowTypeDao extends EntityDaoBase<WorkflowTypeEntity> implements IWorkflowTypeDao {

  @Override
  public List<WorkflowTypeEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {
    final EntityManager                     entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder                   criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowTypeEntity> query           = criteriaBuilder.createQuery(WorkflowTypeEntity.class);
    final Root<WorkflowTypeEntity>          root            = query.from(WorkflowTypeEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate    predicate           = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<WorkflowTypeEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowTypeEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  protected Class<WorkflowTypeEntity> entityClass() {
    return WorkflowTypeEntity.class;
  }

}
