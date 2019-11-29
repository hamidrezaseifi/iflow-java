package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.DepartmentGroupRepository;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Repository
public class DepartmentGroupDao implements IDepartmentGroupDao {
  @Autowired
  DepartmentGroupRepository repository;

  @Override
  public DepartmentGroupEntity create(final DepartmentGroupEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public DepartmentGroupEntity update(final DepartmentGroupEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public DepartmentGroupEntity getById(final Long id) throws IFlowStorageException {

    final Optional<DepartmentGroupEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public DepartmentGroupEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    return repository.findAllByIdentityList(idList);
  }

}
