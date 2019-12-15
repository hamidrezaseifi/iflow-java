package com.pth.iflow.core.storage.dao.impl.base;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.base.IWorkflowContainerEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public abstract class WorkflowParentEntityDaoBase<T extends IWorkflowContainerEntity> {

  protected abstract Class<T> entityClass();

  protected abstract EntityManager getEntityManager();

  @Transactional
  public T create(final T model) throws IFlowStorageException {

    this.getEntityManager().getTransaction().begin();
    final WorkflowEntity workflow = this.getEntityManager().merge(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    final T savedModel = this.getEntityManager().merge(model);
    this.getEntityManager().getTransaction().commit();
    return savedModel;
  }

  @Transactional
  public T update(final T model) throws IFlowStorageException {
    if (this.getEntityManager().getTransaction().isActive() == false) {
      this.getEntityManager().getTransaction().begin();
    }

    final WorkflowEntity workflowModel = this.getEntityManager().find(WorkflowEntity.class, model.getWorkflowId());
    workflowModel.setFiles(new ArrayList<>());
    workflowModel.setActions(new ArrayList<>());
    this.getEntityManager().merge(workflowModel);

    this.getEntityManager().getTransaction().commit();

    if (this.getEntityManager().getTransaction().isActive() == false) {
      this.getEntityManager().getTransaction().begin();
    }

    final WorkflowEntity workflow = this.getEntityManager().merge(model.getWorkflow());
    model.setWorkflow(workflow);
    model.setWorkflowId(workflow.getId());
    final T savedModel = this.getEntityManager().merge(model);
    this.getEntityManager().getTransaction().commit();
    return getById(savedModel.getWorkflowId());
  }

  public T getById(final Long id) throws IFlowStorageException {
    final T dbModel = this.getEntityManager().find(entityClass(), id);

    return dbModel;
  }

  @Transactional
  public void deleteById(final Long id) throws IFlowStorageException {
    T entity = this.getById(id);

    if (entity != null) {
      entity = this.getEntityManager().contains(entity) ? entity : this.getEntityManager().merge(entity);

      this.getEntityManager().getTransaction().begin();
      this.getEntityManager().remove(entity);
      this.getEntityManager().getTransaction().commit();

    }
  }

}
