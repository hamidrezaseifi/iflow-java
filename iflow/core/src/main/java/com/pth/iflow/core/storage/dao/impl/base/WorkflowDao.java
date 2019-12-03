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
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.WorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Transactional
@Repository
public class WorkflowDao implements IWorkflowDao {

  @Autowired
  private WorkflowRepository repository;

  @Autowired
  private EntityManager entityManager;

  @Override
  public WorkflowEntity create(final WorkflowEntity model) throws IFlowStorageException {

    entityManager.persist(model);
    entityManager.flush();
    return getById(model.getId());
  }

  @Override
  public WorkflowEntity update(final WorkflowEntity model) throws IFlowStorageException {
    // deleteAllSubItems(model);
    // model.increaseVersion();
    final WorkflowEntity dbModel = entityManager.find(WorkflowEntity.class, model.getId());

    dbModel.updateFromExists(model);

    // dbModel.setComments(model.getComments());
    // final WorkflowEntity merged = entityManager.merge(model);

    entityManager.persist(dbModel);
    entityManager.flush();
    return getById(model.getId());
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

    final WorkflowEntity entity = getById(workflowId);

    if (entity != null) {
      entityManager.remove(entity);
    }

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

  public void deleteAllSubItems(final WorkflowEntity model) throws IFlowStorageException {

    entityManager.remove(model.getActions().get(0));
    entityManager.remove(model.getFiles().get(0));

    /*
     * Query deleteQuery = entityManager. createQuery("delete FROM WorkflowActionEntity ug where ug.workflow.id=:wid");
     * deleteQuery.setParameter("wid", model.getId()); int deletedCount = deleteQuery.executeUpdate();
     *
     * deleteQuery = entityManager. createQuery("delete FROM WorkflowFileEntity ug where ug.workflow.id=:wid");
     * deleteQuery.setParameter("wid", model.getId()); deletedCount = deleteQuery.executeUpdate();
     */

    entityManager.flush();

    // delete FROM WorkflowFileEntity ug where ug.workflow.id=wid
    // int deletedCount = .executeUpdate();

    // repository.deleteAllWorkflowActions(workflowId);
    // repository.deleteAllWorkflowFiles(workflowId);

  }

}
