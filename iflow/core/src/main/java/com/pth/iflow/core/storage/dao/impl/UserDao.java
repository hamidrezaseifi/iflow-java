package com.pth.iflow.core.storage.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.impl.repository.UserRepository;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@Repository
public class UserDao implements IUserDao {

  @Autowired
  UserRepository        repository;

  @Autowired
  private EntityManager entityManager;

  @Override
  public UserEntity create(final UserEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public UserEntity update(final UserEntity model) throws IFlowStorageException {
    return repository.save(model);
  }

  @Override
  public UserEntity getById(final Long id) throws IFlowStorageException {
    final Optional<UserEntity> model = repository.findById(id);

    return model.isPresent() ? model.get() : null;
  }

  @Override
  public void deleteById(final Long id) throws IFlowStorageException {

    repository.deleteById(id);

  }

  @Override
  public UserEntity getByEmail(final String email) throws IFlowStorageException {

    return repository.findByIdentity(email);
  }

  @Override
  public List<UserEntity> getListByIdentityList(final Set<String> idList) throws IFlowStorageException {

    return repository.findAllByIdentityList(idList);
  }

  @Override
  public List<UserEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException {

    return repository.findAllByCompanyIdentity(identity);
  }

  @Override
  public Set<String> getAllUserIdentityListByDepartmentId(final Long id) throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity> userRoot = query.from(UserEntity.class);
    userRoot.join("departments", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(userRoot.get("departmentId"), id));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    final List<UserEntity> list = typedQuery.getResultList();

    return list.stream().map(u -> u.getIdentity()).collect(Collectors.toSet());
  }

  @Override
  public Set<String> getAllUserIdentityListByDepartmentGroupId(final Long id) throws IFlowStorageException {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
    final Root<UserEntity> userRoot = query.from(UserEntity.class);
    userRoot.join("departmentGroups", JoinType.INNER);

    query.select(userRoot).where(criteriaBuilder.equal(userRoot.get("departmentGroupId"), id));
    final TypedQuery<UserEntity> typedQuery = entityManager.createQuery(query);
    final List<UserEntity> list = typedQuery.getResultList();

    return list.stream().map(u -> u.getIdentity()).collect(Collectors.toSet());
  }

}
