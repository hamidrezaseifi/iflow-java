package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;

@Repository
public interface DepartmentGroupRepository extends JpaRepository<DepartmentGroupEntity, Long> {

  @Query("SELECT ug FROM DepartmentGroupEntity ug where ug.identity=:ident")
  DepartmentGroupEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM DepartmentGroupEntity ug where ug.identity in :identlist")
  List<DepartmentGroupEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}