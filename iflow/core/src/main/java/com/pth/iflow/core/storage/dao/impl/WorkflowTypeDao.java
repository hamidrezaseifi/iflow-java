package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Repository
public class WorkflowTypeDao extends EntityDaoBase<WorkflowTypeEntity> implements IWorkflowTypeDao {

  @Override
  public List<WorkflowTypeEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowTypeEntity> query = criteriaBuilder.createQuery(WorkflowTypeEntity.class);
    // final Root<CompanyEntity> companyRoot = query.from(CompanyEntity.class);
    final Root<WorkflowTypeEntity> root = query.from(WorkflowTypeEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("company").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, identity);
    query.where(predicate);

    final TypedQuery<WorkflowTypeEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowTypeEntity> list = typedQuery.getResultList();
    session.close();
    return list;
  }

  @Override
  protected Class<WorkflowTypeEntity> entityClass() {

    return WorkflowTypeEntity.class;
  }

}
