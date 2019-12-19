package com.pth.iflow.core.storage.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowMessageRepository;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;

@Repository
public class WorkflowMessageDao extends EntityDaoBase<WorkflowMessageEntity> implements IWorkflowMessageDao {

  @Autowired
  WorkflowMessageRepository    repository;

  private EntityManager        entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Transactional
  @Override
  public void updateStatusByWorkflowIdentity(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status)
      throws IFlowStorageException {
    final List<WorkflowMessageEntity> messages = findMessageListForWorkflowAndStep(workflowIdentity, stepIdentity);

    entityManager.getTransaction().begin();

    for (final WorkflowMessageEntity message : messages) {
      message.setStatusEnum(status);
      entityManager.merge(message);
    }
    entityManager.getTransaction().commit();
  }

  @Transactional
  @Override
  public void updateStatusByWorkflowAndUser(final String workflowIdentity, final String stepIdentity, final String userIdentity,
      final EWorkflowMessageStatus status) throws IFlowStorageException {

    entityManager.getTransaction().begin();

    final WorkflowMessageEntity message = findMessageForWorkflowAndStepAnUser(workflowIdentity, stepIdentity, userIdentity);
    message.setStatusEnum(status);
    entityManager.merge(message);

    entityManager.getTransaction().commit();
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserIdentity(final String userIdentity) throws IFlowStorageException {

    final List<Integer> statusList = Arrays.asList(EWorkflowMessageStatus.ASSIGNED.getValue(), EWorkflowMessageStatus.OFFERING.getValue());

    return repository.findNotExpiredUserWorkflowMessagesByStatus(userIdentity, statusList);
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowIdentity(final String workflowIdentity) throws IFlowStorageException {
    final List<Integer> statusList = Arrays.asList(EWorkflowMessageStatus.ASSIGNED.getValue(), EWorkflowMessageStatus.OFFERING.getValue());

    return repository.findNotExpiredWorkflowWorkflowMessagesByStatus(workflowIdentity, statusList);
  }

  @Override
  public List<WorkflowMessageEntity> findMessageListForWorkflowAndStep(final String workflowIdentity, final String stepIdentity) {
    final CriteriaBuilder                      criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query           = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity>          userRoot        = query.from(WorkflowMessageEntity.class);
    // userRoot.join("workflow", JoinType.INNER);
    // userRoot.join("step", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.and(criteriaBuilder.equal(userRoot.get("workflow").get("identity"), workflowIdentity),
        criteriaBuilder.equal(userRoot.get("step").get("identity"), stepIdentity)));
    final TypedQuery<WorkflowMessageEntity> typedQuery = entityManager.createQuery(query);
    final String                            qr         = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    System.out.println("The query: " + qr);
    return typedQuery.getResultList();

  }

  @Override
  public WorkflowMessageEntity findMessageForWorkflowAndStepAnUser(final String workflowIdentity, final String stepIdentity,
      final String userIdentity) {
    final CriteriaBuilder                      criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query           = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity>          userRoot        = query.from(WorkflowMessageEntity.class);
    // userRoot.join Arrays.asList("workflow", "step", "workflow"), JoinType.INNER);

    // userRoot.join("workflow", JoinType.INNER);
    // userRoot.join("step", JoinType.INNER);

    query.select(userRoot)
        .where(criteriaBuilder.and(criteriaBuilder.equal(userRoot.get("workflow").get("identity"), workflowIdentity),
            criteriaBuilder.equal(userRoot.get("step").get("identity"), stepIdentity),
            criteriaBuilder.equal(userRoot.get("user").get("email"), userIdentity)));
    final TypedQuery<WorkflowMessageEntity> typedQuery = entityManager.createQuery(query);
    final String                            qr         = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    System.out.println("The query: " + qr);
    return typedQuery.getSingleResult();
  }

  @Override
  protected Class<WorkflowMessageEntity> entityClass() {
    return WorkflowMessageEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }

}
