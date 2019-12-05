package com.pth.iflow.core.storage.dao.impl.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowActionEntity;
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
  private IWorkflowDao workflowDao;

  @Autowired
  private EntityManager entityManager;

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
  public List<TestThreeTaskWorkflowEntity> getListForUserIdentity(final String userIdentity, final int status) throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<TestThreeTaskWorkflowEntity> query = criteriaBuilder.createQuery(TestThreeTaskWorkflowEntity.class);
    final Root<TestThreeTaskWorkflowEntity> root = query.from(TestThreeTaskWorkflowEntity.class);
    query.select(root);

    final Subquery<Long> assignSubQuery = query.subquery(Long.class);
    final Root<WorkflowActionEntity> assignRoot = assignSubQuery.from(WorkflowActionEntity.class);

    final Path<Long> assignPath = assignRoot.get("assignToUser").get("email");
    final Path<Long> workflowIdPath = assignRoot.get("workflowEntity").get("id");

    final Predicate assignInPredicate = assignPath.in(Arrays.asList(userIdentity));
    final Predicate workflowIdPredicate = criteriaBuilder.equal(workflowIdPath, root.get("workflow").get("id"));

    assignSubQuery.select(workflowIdPath).where(criteriaBuilder.and(assignInPredicate, workflowIdPredicate));

    final Path<Long> path = root.get("workflow").get("id");
    final Predicate predicate = path.in(assignSubQuery);

    Predicate finalPredicate = predicate;

    if (status > -1) {
      finalPredicate = criteriaBuilder.and(finalPredicate, criteriaBuilder.equal(root.get("workflow").get("status"), status));
    }
    if (finalPredicate != null) {
      query.where(finalPredicate);
    }

    final TypedQuery<TestThreeTaskWorkflowEntity> typedQuery = entityManager.createQuery(query);

    // final String qr =
    // typedQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
    // System.out.println("search workflow query: " + qr);
    return typedQuery.getResultList();

  }

  @Override
  public List<TestThreeTaskWorkflowEntity> getListByIdentityList(final Collection<String> idList) {

    return repository.findAllByIdentityList(idList);
  }

}
