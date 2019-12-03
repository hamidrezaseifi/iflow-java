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

import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.workflow.TestThreeTaskWorkflowRepository;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ITestThreeTaskWorkflowDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@Transactional
@Repository
public class TestThreeTaskWorkflowDao implements ITestThreeTaskWorkflowDao {

  @Autowired
  private TestThreeTaskWorkflowRepository repository;

  @Autowired
  private IWorkflowDao                    workflowDao;

  @Autowired
  private EntityManager                   entityManager;

  @Override
  public TestThreeTaskWorkflowEntity create(final TestThreeTaskWorkflowEntity model) throws IFlowStorageException {
    final WorkflowEntity workflow = workflowDao.create(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    entityManager.persist(model);
    return getById(model.getWorkflowId());
  }

  @Override
  public TestThreeTaskWorkflowEntity update(final TestThreeTaskWorkflowEntity model) throws IFlowStorageException {
    final TestThreeTaskWorkflowEntity dbModel = entityManager.find(TestThreeTaskWorkflowEntity.class, model.getWorkflowId());
    dbModel.updateFromExists(model);

    entityManager.merge(dbModel);
    entityManager.flush();
    return getById(model.getWorkflowId());
  }

  @Override
  public TestThreeTaskWorkflowEntity getById(final Long id) throws IFlowStorageException {
    final Optional<TestThreeTaskWorkflowEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public TestThreeTaskWorkflowEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public void deleteById(final Long workflowId) throws IFlowStorageException {
    final TestThreeTaskWorkflowEntity entity = getById(workflowId);

    if (entity != null) {
      entityManager.remove(entity);
    }
  }

  @Override
  public List<TestThreeTaskWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status)
      throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<TestThreeTaskWorkflowEntity> query = criteriaBuilder.createQuery(TestThreeTaskWorkflowEntity.class);
    final Root<TestThreeTaskWorkflowEntity> root = query.from(TestThreeTaskWorkflowEntity.class);
    root.join("actions", JoinType.INNER);

    Predicate predicate = criteriaBuilder.equal(root.get("actions").get("assignToUser").get("email"), userIdentity);
    if (status > -1) {
      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
    }

    query.select(root).where(predicate);
    final TypedQuery<TestThreeTaskWorkflowEntity> typedQuery = entityManager.createQuery(query);
    return typedQuery.getResultList();

  }

  @Override
  public List<TestThreeTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

}
