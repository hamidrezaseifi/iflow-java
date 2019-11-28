package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query("SELECT ug FROM UserEntity ug where ug.email=:ident")
  UserEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM UserEntity ug where ug.company.identity=:ident")
  List<UserEntity> findAllByCompanyIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM UserEntity ug where ug.email in :identlist")
  List<UserEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}