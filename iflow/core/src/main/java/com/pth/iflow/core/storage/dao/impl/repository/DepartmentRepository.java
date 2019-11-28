package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

  @Query("SELECT ug FROM DepartmentEntity ug where ug.identity=:ident")
  DepartmentEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM DepartmentEntity ug where ug.company.identity=:ident")
  List<DepartmentEntity> findAllByCompanyIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM DepartmentEntity ug where ug.identity in :identlist")
  List<DepartmentEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}