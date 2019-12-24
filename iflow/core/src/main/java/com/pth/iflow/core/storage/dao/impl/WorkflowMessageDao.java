package com.pth.iflow.core.storage.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;

@Repository
public class WorkflowMessageDao extends EntityDaoBase<WorkflowMessageEntity> implements IWorkflowMessageDao {

  // @Autowired
  // WorkflowMessageRepository repository;

  @Transactional
  @Override
  public void updateStatusByWorkflowIdentity(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status)
      throws IFlowStorageException {
    final List<WorkflowMessageEntity> messages      = findMessageListForWorkflowAndStep(workflowIdentity, stepIdentity);
    final EntityManager               entityManager = dbConfiguration.getEntityManager();

    entityManager.getTransaction().begin();

    for (final WorkflowMessageEntity message : messages) {
      message.setStatusEnum(status);
      entityManager.merge(message);
    }
    entityManager.getTransaction().commit();

    entityManager.close();
  }

  @Transactional
  @Override
  public void updateStatusByWorkflowAndUser(final String workflowIdentity, final String stepIdentity, final String userIdentity,
      final EWorkflowMessageStatus status) throws IFlowStorageException {
    final EntityManager entityManager = dbConfiguration.getEntityManager();

    entityManager.getTransaction().begin();

    final WorkflowMessageEntity message = findMessageForWorkflowAndStepAnUser(workflowIdentity, stepIdentity, userIdentity);
    message.setStatusEnum(status);
    entityManager.merge(message);

    entityManager.getTransaction().commit();

    entityManager.close();
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserIdentity(final String userIdentity) throws IFlowStorageException {

    final EntityManager                        entityManager   = dbConfiguration.getEntityManager();

    final List<Integer>                        statusList      = Arrays.asList(EWorkflowMessageStatus.ASSIGNED.getValue(),
        EWorkflowMessageStatus.OFFERING.getValue());

    final CriteriaBuilder                      criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query           = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity>          root            = query.from(WorkflowMessageEntity.class);

    final Predicate                            userPredicate   = criteriaBuilder.equal(root.get("user").get("email"), userIdentity);
    final Predicate                            statusPredicate = root.get("status").in(statusList);

    query.select(root).where(criteriaBuilder.and(userPredicate, statusPredicate));

    final TypedQuery<WorkflowMessageEntity> typedQuery = entityManager.createQuery(query);

    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowMessageEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;

//"SELECT msg FROM WorkflowMessageEntity msg inner join UserEntity ut on msg.userId=ut.id where ut.email=:uident and msg.status in :statuslist and TIMESTAMPDIFF(DAY, msg.createdAt, now()) < msg.expireDays"

  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowIdentity(final String workflowIdentity) throws IFlowStorageException {

    // "SELECT msg FROM WorkflowMessageEntity msg inner join WorkflowEntity w on msg.workflow.id=w.id where w.identity=:wident and msg.status
    // in :statuslist and TIMESTAMPDIFF(DAY, msg.createdAt, now()) < msg.expireDays"
    final EntityManager                        entityManager     = dbConfiguration.getEntityManager();

    final List<Integer>                        statusList        = Arrays.asList(EWorkflowMessageStatus.ASSIGNED.getValue(),
        EWorkflowMessageStatus.OFFERING.getValue());

    final CriteriaBuilder                      criteriaBuilder   = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query             = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity>          root              = query.from(WorkflowMessageEntity.class);

    final Predicate                            identityPredicate = criteriaBuilder.equal(root.get("workflow").get("identity"),
        workflowIdentity);
    final Predicate                            statusPredicate   = root.get("status").in(statusList);

    query.select(root).where(criteriaBuilder.and(identityPredicate, statusPredicate));

    final TypedQuery<WorkflowMessageEntity> typedQuery = entityManager.createQuery(query);

    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowMessageEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;

  }

  @Override
  public List<WorkflowMessageEntity> findMessageListForWorkflowAndStep(final String workflowIdentity, final String stepIdentity) {
    final EntityManager                        entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder                      criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query           = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity>          userRoot        = query.from(WorkflowMessageEntity.class);
    // userRoot.join("workflow", JoinType.INNER);
    // userRoot.join("step", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.and(criteriaBuilder.equal(userRoot.get("workflow").get("identity"), workflowIdentity),
        criteriaBuilder.equal(userRoot.get("step").get("identity"), stepIdentity)));
    final TypedQuery<WorkflowMessageEntity> typedQuery = entityManager.createQuery(query);
    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("The query: " + qr);

    final List<WorkflowMessageEntity>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;

  }

  @Override
  public WorkflowMessageEntity findMessageForWorkflowAndStepAnUser(final String workflowIdentity, final String stepIdentity,
      final String userIdentity) {
    final EntityManager                        entityManager   = dbConfiguration.getEntityManager();

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
    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("The query: " + qr);

    final WorkflowMessageEntity             result     = typedQuery.getSingleResult();
    entityManager.close();
    return result;
  }

  @Override
  protected Class<WorkflowMessageEntity> entityClass() {
    return WorkflowMessageEntity.class;
  }

}
