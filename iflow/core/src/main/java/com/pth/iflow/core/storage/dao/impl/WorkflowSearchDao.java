package com.pth.iflow.core.storage.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowSearchDao;

@Repository
public class WorkflowSearchDao implements IWorkflowSearchDao {

  @Autowired
  private EntityManager entityManager;

  public WorkflowSearchDao() {

  }

  @Override
  public List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter) {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowResultEntity> query = criteriaBuilder.createQuery(WorkflowResultEntity.class);
    final Root<WorkflowResultEntity> root = query.from(WorkflowResultEntity.class);
    query.select(root);

    Predicate finalPredicate = null;

    if (workflowSearchFilter.getStatusSet().isEmpty() == false) {
      final Path<Integer> path = root.get("status");
      final Predicate predicate = path.in(workflowSearchFilter.getStatusSet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
      // query.where(predicate);
    }

    if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {

      final Subquery<Long> assignSubQuery = query.subquery(Long.class);
      final Root<WorkflowActionEntity> assignRoot = assignSubQuery.from(WorkflowActionEntity.class);

      final Path<Long> assignPath = assignRoot.get("assignToUser").get("email");
      final Path<Long> workflowIdPath = assignRoot.get("workflow").get("id");

      final Predicate assignInPredicate = assignPath.in(workflowSearchFilter.getAssignedUserIdentitySet());
      final Predicate workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("id"));

      assignSubQuery.select(workflowIdPath).where(criteriaBuilder.and(assignInPredicate, workflowIdPredicate));

      final Path<Long> path = root.get("id");
      final Predicate predicate = path.in(assignSubQuery);

      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
    }

    if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
      final Path<String> path = root.get("currentStepIdentity");
      final Predicate predicate = path.in(workflowSearchFilter.getWorkflowStepIdentitySet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
    }

    if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
      final Path<String> path = root.get("workflowTypeIdentity");
      final Predicate predicate = path.in(workflowSearchFilter.getWorkflowTypeIdentitySet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
      // query.where(predicate);
    }

    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<WorkflowResultEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    return typedQuery.getResultList();
  }

  @Override
  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList) {

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowResultEntity> query = criteriaBuilder.createQuery(WorkflowResultEntity.class);
    final Root<WorkflowResultEntity> root = query.from(WorkflowResultEntity.class);

    final Predicate predicate = root.get("identity").in(identityList);
    query.select(root).where(predicate);

    final TypedQuery<WorkflowResultEntity> typedQuery = entityManager.createQuery(query);

    return typedQuery.getResultList();
  }

}