package com.pth.iflow.core.storage.dao.impl.base;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;

public abstract class EntityDaoBase<T extends ICoreEntityVersion> {

  protected abstract Class<T> entityClass();

  protected abstract EntityManager getEntityManager();

  @Transactional
  public T create(final T model) throws IFlowStorageException {

    this.getEntityManager().getTransaction().begin();
    final T savedModel = this.getEntityManager().merge(model);
    this.getEntityManager().getTransaction().commit();
    return savedModel;
  }

  @Transactional
  public T update(final T model) throws IFlowStorageException {
    this.getEntityManager().getTransaction().begin();
    final T savedModel = this.getEntityManager().merge(model);
    this.getEntityManager().getTransaction().commit();
    return getById(savedModel.getId());
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
