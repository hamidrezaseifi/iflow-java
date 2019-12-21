package com.pth.iflow.core.storage.dao.impl.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.base.IWorkflowContainerEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public abstract class WorkflowParentEntityDaoBase<T extends IWorkflowContainerEntity> extends EntityManagerHelper {

  protected abstract Class<T> entityClass();

  // private EntityManager entityManager = null;

  @Override
  @PostConstruct
  public void init() {
    // entityManager = dbConfiguration.getEntityManager();
  }

  @Transactional
  public T create(final T model) throws IFlowStorageException {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    entityManager.getTransaction().begin();
    final WorkflowEntity workflow = entityManager.merge(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    final T savedModel = entityManager.merge(model);
    entityManager.getTransaction().commit();
    entityManager.close();
    return savedModel;
  }

  @Transactional
  public T update(final T model) throws IFlowStorageException {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    if (entityManager.getTransaction().isActive() == false) {
      entityManager.getTransaction().begin();
    }

    final WorkflowEntity workflowModel = entityManager.find(WorkflowEntity.class, model.getWorkflowId());
    workflowModel.setFiles(new ArrayList<>());
    workflowModel.setActions(new ArrayList<>());
    entityManager.merge(workflowModel);

    entityManager.getTransaction().commit();

    if (entityManager.getTransaction().isActive() == false) {
      entityManager.getTransaction().begin();
    }

    final WorkflowEntity workflow = entityManager.merge(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    final T savedModel = entityManager.merge(model);
    entityManager.getTransaction().commit();
    entityManager.close();
    return getById(savedModel.getWorkflowId());
  }

  public T getById(final Long id) throws IFlowStorageException {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    final T             dbModel       = entityManager.find(entityClass(), id);
    entityManager.close();
    return dbModel;
  }

  @Transactional
  public void deleteById(final Long id) throws IFlowStorageException {

    final EntityManager entityManager = dbConfiguration.getEntityManager();

    T                   entity        = this.getById(id);

    if (entity != null) {
      entity = entityManager.contains(entity) ? entity : entityManager.merge(entity);

      entityManager.getTransaction().begin();
      entityManager.remove(entity);
      entityManager.getTransaction().commit();

    }
    entityManager.close();
  }

  public List<T> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {

    final EntityManager    entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<T> query           = criteriaBuilder.createQuery(entityClass());
    final Root<T>          root            = query.from(entityClass());
    query.select(root);

    final Subquery<Long>             assignSubQuery      = query.subquery(Long.class);
    final Root<WorkflowActionEntity> assignRoot          = assignSubQuery.from(WorkflowActionEntity.class);

    final Path<String>               assignPath          = assignRoot.get("assignToUser").get("email");
    final Path<Long>                 workflowIdPath      = assignRoot.get("workflowEntity").get("id");

    final Predicate                  assignInPredicate   = assignPath.in(Arrays.asList(userIdentity));
    final Predicate                  workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("workflowId"));

    assignSubQuery.select(workflowIdPath).where(criteriaBuilder.and(assignInPredicate, workflowIdPredicate));

    final Path<Long> path           = root.get("workflowId");
    final Predicate  predicate      = path.in(assignSubQuery);

    Predicate        finalPredicate = predicate;

    if (status > -1) {
      finalPredicate = criteriaBuilder.and(finalPredicate, criteriaBuilder.equal(root.get("status"), status));
    }
    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<T> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<T>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;

  }

  public T getByIdentity(final String identity) throws IFlowStorageException {

    final EntityManager    entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<T> query           = criteriaBuilder.createQuery(entityClass());
    final Root<T>          root            = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("workflow").get("identity");
    final Predicate    predicate    = criteriaBuilder.equal(identityPath, identity);
    query.where(predicate);

    final TypedQuery<T> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final T             result     = typedQuery.getSingleResult();
    entityManager.close();
    return result;
  }

  public List<T> getListByIdentityList(final Collection<String> identityList) {

    final EntityManager    entityManager   = dbConfiguration.getEntityManager();

    final CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<T> query           = criteriaBuilder.createQuery(entityClass());
    final Root<T>          root            = query.from(entityClass());
    query.select(root);

    final Path<String> identityPath = root.get("workflow").get("identity");
    final Predicate    predicate    = identityPath.in(identityList);
    query.where(predicate);

    final TypedQuery<T> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    final List<T>       list       = typedQuery.getResultList();
    entityManager.close();
    return list;
  }
}
