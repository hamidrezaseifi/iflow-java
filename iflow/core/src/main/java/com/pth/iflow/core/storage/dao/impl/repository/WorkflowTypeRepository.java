package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;

@Repository
public interface WorkflowTypeRepository extends JpaRepository<WorkflowTypeEntity, Long> {

  @Query("SELECT ug FROM WorkflowTypeEntity ug where ug.identity=:ident")
  WorkflowTypeEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM WorkflowTypeEntity ug where ug.company.identity=:ident")
  List<WorkflowTypeEntity> findAllByCompanyIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM WorkflowTypeEntity ug where ug.identity in :identlist")
  List<WorkflowTypeEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}