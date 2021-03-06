package com.pth.iflow.core.storage.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;

@Transactional
@Repository
public class WorkflowMessageDao extends EntityDaoBase<WorkflowMessageEntity> implements IWorkflowMessageDao {

  // @Autowired
  // WorkflowMessageRepository repository;

  @Override
  public void updateStatusByWorkflowIdentity(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status)
      throws IFlowStorageException {

    final List<WorkflowMessageEntity> messages = findMessageListForWorkflowAndStep(workflowIdentity, stepIdentity);
    final Session session = this.createSession();

    session.getTransaction().begin();

    for (final WorkflowMessageEntity message : messages) {
      message.setStatusEnum(status);
      session.merge(message);
    }
    session.getTransaction().commit();

    session.close();
  }

  @Override
  public void updateStatusByWorkflowAndUser(final String workflowIdentity, final String stepIdentity, final String userIdentity,
      final EWorkflowMessageStatus status) throws IFlowStorageException {

    final Session session = this.createSession();

    session.getTransaction().begin();

    final WorkflowMessageEntity message = findMessageForWorkflowAndStepAnUser(workflowIdentity, stepIdentity, userIdentity);
    message.setStatusEnum(status);
    session.merge(message);

    session.getTransaction().commit();

    session.close();
  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByUserIdentity(final String userIdentity) throws IFlowStorageException {

    final Session session = this.createSession();

    final List<Integer> statusList = Arrays
        .asList(EWorkflowMessageStatus.ASSIGNED.getValue(),
            EWorkflowMessageStatus.OFFERING.getValue());

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity> root = query.from(WorkflowMessageEntity.class);

    final Predicate userPredicate = criteriaBuilder.equal(root.get("user").get("identity"), userIdentity);
    final Predicate statusPredicate = root.get("status").in(statusList);

    query.select(root).where(criteriaBuilder.and(userPredicate, statusPredicate));

    final TypedQuery<WorkflowMessageEntity> typedQuery = session.createQuery(query);

    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowMessageEntity> list = typedQuery.getResultList();
    session.close();
    return list;

  }

  @Override
  public List<WorkflowMessageEntity> getNotClosedNotExpiredListByWorkflowIdentity(final String workflowIdentity)
      throws IFlowStorageException {

    // "SELECT msg FROM WorkflowMessageEntity msg inner join WorkflowEntity w on msg.workflow.id=w.id where w.identity=:wident and
    // msg.status
    // in :statuslist and TIMESTAMPDIFF(DAY, msg.createdAt, now()) < msg.expireDays"
    final Session session = this.createSession();

    final List<Integer> statusList = Arrays
        .asList(EWorkflowMessageStatus.ASSIGNED.getValue(),
            EWorkflowMessageStatus.OFFERING.getValue());

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity> root = query.from(WorkflowMessageEntity.class);

    final Predicate identityPredicate = criteriaBuilder
        .equal(root.get("workflow").get("identity"),
            workflowIdentity);
    final Predicate statusPredicate = root.get("status").in(statusList);

    query.select(root).where(criteriaBuilder.and(identityPredicate, statusPredicate));

    final TypedQuery<WorkflowMessageEntity> typedQuery = session.createQuery(query);

    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<WorkflowMessageEntity> list = typedQuery.getResultList();
    session.close();
    return list;

  }

  @Override
  public List<WorkflowMessageEntity> findMessageListForWorkflowAndStep(final String workflowIdentity, final String stepIdentity) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity> userRoot = query.from(WorkflowMessageEntity.class);
    // userRoot.join("workflow", JoinType.INNER);
    // userRoot.join("step", JoinType.INNER);

    query
        .select(userRoot)
        .where(criteriaBuilder
            .and(criteriaBuilder.equal(userRoot.get("workflow").get("identity"), workflowIdentity),
                criteriaBuilder.equal(userRoot.get("step").get("identity"), stepIdentity)));
    final TypedQuery<WorkflowMessageEntity> typedQuery = session.createQuery(query);
    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("The query: " + qr);

    final List<WorkflowMessageEntity> list = typedQuery.getResultList();
    session.close();
    return list;

  }

  @Override
  public WorkflowMessageEntity findMessageForWorkflowAndStepAnUser(final String workflowIdentity, final String stepIdentity,
      final String userIdentity) {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<WorkflowMessageEntity> query = criteriaBuilder.createQuery(WorkflowMessageEntity.class);
    final Root<WorkflowMessageEntity> root = query.from(WorkflowMessageEntity.class);

    // final Join<WorkflowMessageEntity, WorkflowEntity> workflowJoin =
    root.join("workflow", JoinType.INNER);
    root.join("step", JoinType.INNER);
    root.join("user", JoinType.INNER);

    // userRoot.join Arrays.asList("workflow", "step", "workflow"), JoinType.INNER);

    // userRoot.join("workflow", JoinType.INNER);
    // userRoot.join("step", JoinType.INNER);

    query
        .select(root)
        .where(criteriaBuilder
            .and(criteriaBuilder.equal(root.get("workflow").get("identity"), workflowIdentity),
                criteriaBuilder.equal(root.get("step").get("identity"), stepIdentity),
                criteriaBuilder.equal(root.get("user").get("identity"), userIdentity)));
    final TypedQuery<WorkflowMessageEntity> typedQuery = session.createQuery(query);
    // final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("The query: " + qr);

    final List<WorkflowMessageEntity> list = typedQuery.getResultList();
    session.close();
    return list.size() > 0 ? list.get(0) : null;
  }

  @Override
  protected Class<WorkflowMessageEntity> entityClass() {

    return WorkflowMessageEntity.class;
  }

}
