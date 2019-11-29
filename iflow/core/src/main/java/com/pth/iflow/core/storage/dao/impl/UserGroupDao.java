package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.UserGroupRepository;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Repository
public class UserGroupDao implements IUserGroupDao {

  @Autowired
  UserGroupRepository repository;

  @Override
  public UserGroupEntity create(final UserGroupEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public UserGroupEntity update(final UserGroupEntity model) throws IFlowStorageException {
    return repository.saveAndFlush(model);
  }

  @Override
  public UserGroupEntity getById(final Long id) throws IFlowStorageException {
    final Optional<UserGroupEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public void deleteById(final Long id) throws IFlowStorageException {

    repository.deleteById(id);

  }

  @Override
  public List<UserGroupEntity> getListByIdList(final Collection<Long> idList) throws IFlowStorageException {

    return repository.findAllById(idList);
  }

  @Override
  public List<UserGroupEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public List<UserGroupEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  public UserGroupEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

}
