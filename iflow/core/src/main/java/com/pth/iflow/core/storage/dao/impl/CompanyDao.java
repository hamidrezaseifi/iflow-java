package com.pth.iflow.core.storage.dao.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.CompanyRepository;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Transactional
@Repository
public class CompanyDao implements ICompanyDao {

  @Autowired
  CompanyRepository repository;

  public CompanyDao() {

  }

  @Override
  public CompanyEntity getById(final Long id) throws IFlowStorageException {
    final Optional<CompanyEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public CompanyEntity getByIdentity(final String identity) {
    return repository.findByIdentity(identity);
  }

  @Override
  public CompanyEntity create(final CompanyEntity model) throws IFlowStorageException {

    final CompanyEntity newModel = repository.save(model);

    return newModel;
  }

  @Override
  public CompanyEntity update(final CompanyEntity model) throws IFlowStorageException {

    final CompanyEntity updatedModel = repository.save(model);

    return updatedModel;
  }

}
