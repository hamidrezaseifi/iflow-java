package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.WorkflowResultEntity;

@Repository
public interface WorkflowSearchDaoRepository extends JpaRepository<WorkflowResultEntity, Integer> {
  @Query("SELECT w FROM WorkflowResultEntity w where w.identity=:ident")
  WorkflowResultEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT w FROM WorkflowResultEntity w where w.identity in :identList")
  List<WorkflowResultEntity> findByIdentityList(@Param("identList") Set<String> identityList);
}