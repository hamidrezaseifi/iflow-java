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

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@Repository
public class WorkflowTypeStepDao extends EntityDaoBase<WorkflowTypeStepEntity> implements IWorkflowTypeStepDao {

  @Override
  public List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowTypeIdentity) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowTypeStepEntity> query = criteriaBuilder.createQuery(WorkflowTypeStepEntity.class);
    final Root<WorkflowTypeStepEntity> root = query.from(WorkflowTypeStepEntity.class);
    query.select(root);

    final Path<String> companyIdentityPath = root.get("workflowType").get("identity");
    final Predicate predicate = criteriaBuilder.equal(companyIdentityPath, workflowTypeIdentity);
    query.where(predicate);

    final TypedQuery<WorkflowTypeStepEntity> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowTypeStepEntity> list = typedQuery.getResultList();
    session.close();
    return list;
  }

  @Override
  protected Class<WorkflowTypeStepEntity> entityClass() {

    return WorkflowTypeStepEntity.class;
  }

}
