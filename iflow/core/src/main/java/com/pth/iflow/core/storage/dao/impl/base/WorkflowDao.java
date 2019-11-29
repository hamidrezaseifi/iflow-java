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

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.WorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Repository
public class WorkflowDao implements IWorkflowDao {

  @Autowired
  private WorkflowRepository repository;

  @Autowired
  private EntityManager      entityManager;

  @Override
  public WorkflowEntity create(final WorkflowEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowEntity update(final WorkflowEntity model) throws IFlowStorageException {
    deleteAllSubItemsById(model.getId());
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowEntity getById(final Long id) throws IFlowStorageException {
    final Optional<WorkflowEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public WorkflowEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public void deleteById(final Long workflowId) throws IFlowStorageException {
    repository.deleteById(workflowId);
  }

  @Override
  public List<WorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<WorkflowEntity> query = criteriaBuilder.createQuery(WorkflowEntity.class);
    final Root<WorkflowEntity> root = query.from(WorkflowEntity.class);
    root.join("actions", JoinType.INNER);

    Predicate predicate = criteriaBuilder.equal(root.get("actions").get("assignToUser").get("email"), userIdentity);
    if (status > -1) {
      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
    }

    query.select(root).where(predicate);
    final TypedQuery<WorkflowEntity> typedQuery = entityManager.createQuery(query);
    return typedQuery.getResultList();

  }

  @Override
  public List<WorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public void deleteAllSubItemsById(final Long workflowId) throws IFlowStorageException {
    repository.deleteAllWorkflowActions(workflowId);
    repository.deleteAllWorkflowFiles(workflowId);

  }

}
