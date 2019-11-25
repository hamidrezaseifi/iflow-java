package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserGroupEntity;

@Repository
public interface UserGroupDaoRepository extends JpaRepository<UserGroupEntity, Integer> {
  @Query("SELECT ug FROM UserGroupEntity ug where ug.identity=:ident")
  UserGroupEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM UserGroupEntity ug where ug.company.identity=:ident")
  List<UserGroupEntity> findAllByCompanyIdentity(@Param("ident") String identity);
}