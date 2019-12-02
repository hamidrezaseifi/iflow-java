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
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.SingleTaskWorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ISingleTaskWorkflowDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Transactional
@Repository
public class SingleTaskWorkflowDao implements ISingleTaskWorkflowDao {

  @Autowired
  private SingleTaskWorkflowRepository repository;

  @Autowired
  private IWorkflowDao                 workflowDao;

  @Autowired
  private EntityManager                entityManager;

  @Override
  public SingleTaskWorkflowEntity create(final SingleTaskWorkflowEntity model) throws IFlowStorageException {
    final WorkflowEntity workflow = workflowDao.create(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    entityManager.persist(model);
    entityManager.flush();
    return getById(workflow.getId());
  }

  @Override
  public SingleTaskWorkflowEntity update(final SingleTaskWorkflowEntity model) throws IFlowStorageException {

    final WorkflowEntity workflow = workflowDao.update(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    return entityManager.merge(model);

  }

  @Override
  public SingleTaskWorkflowEntity getById(final Long id) throws IFlowStorageException {
    final Optional<SingleTaskWorkflowEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public SingleTaskWorkflowEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public void deleteById(final Long workflowId) throws IFlowStorageException {
    repository.deleteById(workflowId);
  }

  @Override
  public List<SingleTaskWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status)
      throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<SingleTaskWorkflowEntity> query = criteriaBuilder.createQuery(SingleTaskWorkflowEntity.class);
    final Root<SingleTaskWorkflowEntity> root = query.from(SingleTaskWorkflowEntity.class);
    root.join("actions", JoinType.INNER);

    Predicate predicate = criteriaBuilder.equal(root.get("actions").get("assignToUser").get("email"), userIdentity);
    if (status > -1) {
      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
    }

    query.select(root).where(predicate);
    final TypedQuery<SingleTaskWorkflowEntity> typedQuery = entityManager.createQuery(query);
    return typedQuery.getResultList();

  }

  @Override
  public List<SingleTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

}
