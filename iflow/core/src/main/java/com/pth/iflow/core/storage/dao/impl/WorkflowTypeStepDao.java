package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.WorkflowTypeStepRepository;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@Repository
public class WorkflowTypeStepDao implements IWorkflowTypeStepDao {

  @Autowired
  WorkflowTypeStepRepository repository;

  @Override
  public WorkflowTypeStepEntity create(final WorkflowTypeStepEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowTypeStepEntity update(final WorkflowTypeStepEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public WorkflowTypeStepEntity getById(final Long id) throws IFlowStorageException {
    final Optional<WorkflowTypeStepEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public WorkflowTypeStepEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public void deleteById(final Long id, final boolean withTransaction) throws IFlowStorageException {
    repository.deleteById(id);
  }

  @Override
  public List<WorkflowTypeStepEntity> getListByWorkflowTypeIdentity(final String workflowTypeIdentity) throws IFlowStorageException {

    return repository.findAllByWorkflowTypeIdentity(workflowTypeIdentity);
  }

}
