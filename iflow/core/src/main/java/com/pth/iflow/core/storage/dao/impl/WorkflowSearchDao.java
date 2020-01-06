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

import org.springframework.stereotype.Repository;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityManagerHelper;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowSearchDao;

@Repository
public class WorkflowSearchDao extends EntityManagerHelper implements IWorkflowSearchDao {

  public WorkflowSearchDao() {

  }

  @Override
  public List<WorkflowEntity> search(final WorkflowSearchFilter workflowSearchFilter) {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowEntity> query = criteriaBuilder.createQuery(WorkflowEntity.class);
    final Root<WorkflowEntity> root = query.from(WorkflowEntity.class);
    query.select(root);

    Predicate finalPredicate = criteriaBuilder.equal(root.get("company").get("identity"), workflowSearchFilter.getCompanyIdentity());

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
      final Path<Long> workflowIdPath = assignRoot.get("workflowEntity").get("id");
      final Path<Integer> actionStatusPath = assignRoot.get("status");

      final Predicate assignInPredicate = assignPath.in(workflowSearchFilter.getAssignedUserIdentitySet());
      final Predicate workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("id"));
      final Predicate actionIsActivePredicate = actionStatusPath
          .in(EWorkflowActionStatus.OPEN.getValue(),
              EWorkflowActionStatus.INITIALIZE.getValue());

      assignSubQuery
          .select(workflowIdPath)
          .where(criteriaBuilder.and(assignInPredicate, criteriaBuilder.and(actionIsActivePredicate, workflowIdPredicate)));

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
      final Path<String> path = root.get("workflowType").get("identity");
      final Predicate predicate = path.in(workflowSearchFilter.getWorkflowTypeIdentitySet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
      // query.where(predicate);
    }

    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<WorkflowEntity> typedQuery = entityManager.createQuery(query);

    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<WorkflowEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

  @Override
  public List<WorkflowEntity> readByIdentityList(final Set<String> identityList) {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowEntity> query = criteriaBuilder.createQuery(WorkflowEntity.class);
    final Root<WorkflowEntity> root = query.from(WorkflowEntity.class);

    final Predicate predicate = root.get("identity").in(identityList);
    query.select(root).where(predicate);

    final TypedQuery<WorkflowEntity> typedQuery = entityManager.createQuery(query);

    final List<WorkflowEntity> list = typedQuery.getResultList();
    entityManager.close();
    return list;
  }

}
