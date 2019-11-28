package com.pth.iflow.core.storage.dao.impl.repository.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;

@Repository
public interface SingleTaskWorkflowRepository extends JpaRepository<SingleTaskWorkflowEntity, Long> {

  @Query("SELECT ug FROM SingleTaskWorkflowEntity ug where ug.identity=:ident")
  SingleTaskWorkflowEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM SingleTaskWorkflowEntity ug where ug.identity in :identlist")
  List<SingleTaskWorkflowEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}