package com.pth.iflow.core.storage.dao.impl.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.helper.EntityManagerHelper;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;

@Transactional
public abstract class EntityDaoBase<T extends ICoreEntityVersion> extends EntityManagerHelper {

  protected abstract Class<T> entityClass();

  public T create(final T model) throws IFlowStorageException {

    final Session session = this.createSession();

    session.getTransaction().begin();

    final Object id = session.save(model);
    session.getTransaction().commit();
    session.close();

    return getById((Long) id);
  }

  public T update(final T model) throws IFlowStorageException {

    final Session session = this.createSession();
    session.getTransaction().begin();

    session.saveOrUpdate(model);
    session.getTransaction().commit();
    session.close();
    return getById(model.getId());
  }

  public T getById(final Long id) throws IFlowStorageException {

    final Session session = this.createSession();
    final T dbModel = session.find(entityClass(), id);
    session.close();

    return dbModel;
  }

  public void deleteById(final Long id) throws IFlowStorageException {

    final T entity = this.getById(id);

    final Session session = this.createSession();
    if (entity != null) {

      session.getTransaction().begin();
      session.remove(entity);
      session.getTransaction().commit();

    }
    session.close();
  }

  public List<T> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass());
    final Root<T> root = query.from(entityClass());
    query.select(root);

    final Subquery<Long> assignSubQuery = query.subquery(Long.class);
    final Root<WorkflowActionEntity> assignRoot = assignSubQuery.from(WorkflowActionEntity.class);

    final Path<String> assignPath = assignRoot.get("assignToUser").get("identity");
    final Path<Long> workflowIdPath = assignRoot.get("workflowEntity").get("id");

    final Predicate assignInPredicate = assignPath.in(Arrays.asList(userIdentity));
    final Predicate workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("id"));

    assignSubQuery.select(workflowIdPath).where(criteriaBuilder.and(assignInPredicate, workflowIdPredicate));

    final Path<Long> path = root.get("id");
    final Predicate predicate = path.in(assignSubQuery);

    Predicate finalPredicate = predicate;

    if (status > -1) {
      finalPredicate = criteriaBuilder.and(finalPredicate, criteriaBuilder.equal(root.get("status"), status));
    }
    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<T> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<T> list = typedQuery.getResultList();
    session.close();
    return list;

  }

  public T getByIdentity(final String identity) throws IFlowStorageException {

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass());
    final Root<T> root = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("identity");
    final Predicate predicate = criteriaBuilder.equal(identityPath, identity);
    query.where(predicate);

    final TypedQuery<T> typedQuery = session.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);

    final List<T> list = typedQuery.getResultList();
    session.close();
    return list.size() > 0 ? list.get(0) : null;
  }

  public List<T> getListByIdentityList(final Collection<String> identityList) {

    if (identityList.size() == 0) {
      return new ArrayList<>();
    }

    final Session session = this.createSession();

    final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    final CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass());
    final Root<T> root = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("identity");
    final Predicate predicate = identityPath.in(identityList);
    query.where(predicate);

    final TypedQuery<T> typedQuery = session.createQuery(query);

    final String qr = typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    System.out.println("search workflow query: " + qr);
    final List<T> list = typedQuery.getResultList();
    session.close();
    return list;
  }

}
