package com.pth.iflow.core.storage.dao.impl.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.InvoiceWorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@Repository
public class InvoiceWorkflowDao implements IInvoiceWorkflowDao {

  @Autowired
  private InvoiceWorkflowRepository repository;

  @Autowired
  private EntityManager             entityManager;

  @Override
  public InvoiceWorkflowEntity create(final InvoiceWorkflowEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public InvoiceWorkflowEntity update(final InvoiceWorkflowEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public InvoiceWorkflowEntity getById(final Long id) throws IFlowStorageException {
    final Optional<InvoiceWorkflowEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public InvoiceWorkflowEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public void deleteById(final Long workflowId) throws IFlowStorageException {
    repository.deleteById(workflowId);
  }

  @Override
  public List<InvoiceWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<InvoiceWorkflowEntity> query = criteriaBuilder.createQuery(InvoiceWorkflowEntity.class);
    final Root<InvoiceWorkflowEntity> root = query.from(InvoiceWorkflowEntity.class);
    root.join("actions", JoinType.INNER);

    Predicate predicate = criteriaBuilder.equal(root.get("actions").get("assignToUser").get("email"), userIdentity);
    if (status > -1) {
      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
    }

    query.select(root).where(predicate);
    final TypedQuery<InvoiceWorkflowEntity> typedQuery = entityManager.createQuery(query);
    return typedQuery.getResultList();

  }

  @Override
  public List<InvoiceWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

}
