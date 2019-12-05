package com.pth.iflow.core.storage.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.DepartmentRepository;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@Transactional
@Repository
public class DepartmentDao implements IDepartmentDao {

  @Autowired
  DepartmentRepository repository;

  @Override
  public DepartmentEntity create(final DepartmentEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public DepartmentEntity update(final DepartmentEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public DepartmentEntity getById(final Long id) throws IFlowStorageException {
    final Optional<DepartmentEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public DepartmentEntity getByIdentity(final String identity) throws IFlowStorageException {
    return repository.findByIdentity(identity);
  }

  @Override
  public List<DepartmentEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  public List<DepartmentEntity> getListByIdentityList(final Collection<String> idList) throws IFlowStorageException {
    return repository.findAllByIdentityList(idList);
  }

}
