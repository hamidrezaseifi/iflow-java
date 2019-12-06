package com.pth.iflow.core.storage.dao.impl.workflow;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.base.WorkflowParentEntityDaoBase;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.InvoiceWorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@Repository
public class InvoiceWorkflowDao extends WorkflowParentEntityDaoBase<InvoiceWorkflowEntity> implements IInvoiceWorkflowDao {

  @Autowired
  private InvoiceWorkflowRepository repository;

  private EntityManager             entityManager = null;

  @PersistenceUnit(unitName = "default")
  private EntityManagerFactory      entityManagerFactory;

  @PostConstruct
  public void init() {
    this.entityManager = this.entityManagerFactory.createEntityManager();
  }

  @Override
  public InvoiceWorkflowEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<InvoiceWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {
    final CriteriaBuilder                      criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<InvoiceWorkflowEntity> query           = criteriaBuilder.createQuery(InvoiceWorkflowEntity.class);
    final Root<InvoiceWorkflowEntity>          root            = query.from(InvoiceWorkflowEntity.class);
    query.select(root);

    final Subquery<Long>             assignSubQuery      = query.subquery(Long.class);
    final Root<WorkflowActionEntity> assignRoot          = assignSubQuery.from(WorkflowActionEntity.class);

    final Path<Long>                 assignPath          = assignRoot.get("assignToUser").get("email");
    final Path<Long>                 workflowIdPath      = assignRoot.get("workflowEntity").get("id");

    final Predicate                  assignInPredicate   = assignPath.in(Arrays.asList(userIdentity));
    final Predicate                  workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("workflow").get("id"));

    assignSubQuery.select(workflowIdPath).where(criteriaBuilder.and(assignInPredicate, workflowIdPredicate));

    final Path<Long> path           = root.get("workflow").get("id");
    final Predicate  predicate      = path.in(assignSubQuery);

    Predicate        finalPredicate = predicate;

    if (status > -1) {
      finalPredicate = criteriaBuilder.and(finalPredicate, criteriaBuilder.equal(root.get("workflow").get("status"), status));
    }
    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<InvoiceWorkflowEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    return typedQuery.getResultList();

  }

  @Override
  public List<InvoiceWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  protected Class<InvoiceWorkflowEntity> entityClass() {
    return InvoiceWorkflowEntity.class;
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }

}
