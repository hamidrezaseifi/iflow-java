package com.pth.iflow.core.service.impl.workflow;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.WorkflowResultEntity;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowSearchService;
import com.pth.iflow.core.storage.dao.IWorkflowSearchDao;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowSearchDaoRepository;

@Service
public class WorkflowSearchService implements IWorkflowSearchService {

  private final IWorkflowSearchDao    workflowSearchDao;

  @Autowired
  private WorkflowSearchDaoRepository workflowSearchDaoRepository;

  @Autowired
  private EntityManager               entityManager;

  public WorkflowSearchService(@Autowired final IWorkflowSearchDao workflowSearchDao) {
    this.workflowSearchDao = workflowSearchDao;
  }

  @Override
  public List<WorkflowResultEntity> search(final WorkflowSearchFilter workflowSearchFilter) {

    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowResultEntity> query = criteriaBuilder.createQuery(WorkflowResultEntity.class);
    final Root<WorkflowResultEntity> root = query.from(WorkflowResultEntity.class);
    query.select(root);

    Predicate finalPredicate = null;

    if (workflowSearchFilter.getStatusSet().isEmpty() == false) {
      final Path<Integer> statusPath = root.get("status");
      final Predicate predicate = statusPath.in(workflowSearchFilter.getStatusSet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
      // query.where(predicate);
    }

    if (workflowSearchFilter.getAssignedUserIdentitySet().isEmpty() == false) {
      // final Path<String> statusPath = root.get("status");
      // final Predicate predicate =
      // statusPath.in(workflowSearchFilter.getStatusSet());
      // Predicates.add(predicate);
      // query.where(predicate);
    }

    if (workflowSearchFilter.getWorkflowStepIdentitySet().isEmpty() == false) {
      final Path<String> statusPath = root.get("currentStepIdentity");
      final Predicate predicate = statusPath.in(workflowSearchFilter.getWorkflowStepIdentitySet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
    }

    if (workflowSearchFilter.getWorkflowTypeIdentitySet().isEmpty() == false) {
      final Path<String> statusPath = root.get("workflowTypeIdentity");
      final Predicate predicate = statusPath.in(workflowSearchFilter.getWorkflowTypeIdentitySet());
      finalPredicate = finalPredicate == null ? predicate : criteriaBuilder.and(finalPredicate, predicate);
      // query.where(predicate);
    }

    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<WorkflowResultEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();

    return typedQuery.getResultList();

    // return workflowSearchDao.search(workflowSearchFilter);
  }

  @Override
  public List<WorkflowResultEntity> readByIdentityList(final Set<String> identityList) {

    final List<WorkflowResultEntity> list = workflowSearchDaoRepository.findByIdentityList(identityList);
    return list;
  }

}
