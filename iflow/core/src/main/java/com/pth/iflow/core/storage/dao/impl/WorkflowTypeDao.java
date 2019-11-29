package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowTypeRepository;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Repository
public class WorkflowTypeDao implements IWorkflowTypeDao {

  @Autowired
  WorkflowTypeRepository repository;

  @Override
  public WorkflowTypeEntity create(final WorkflowTypeEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowTypeEntity update(final WorkflowTypeEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowTypeEntity getById(final Long id) throws IFlowStorageException {
    final Optional<WorkflowTypeEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public List<WorkflowTypeEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public WorkflowTypeEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<WorkflowTypeEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

}
