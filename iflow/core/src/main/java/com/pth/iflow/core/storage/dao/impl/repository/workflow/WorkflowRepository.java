package com.pth.iflow.core.storage.dao.impl.repository.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;

@Repository
public interface WorkflowRepository extends JpaRepository<WorkflowEntity, Long> {

  @Query("SELECT ug FROM WorkflowEntity ug where ug.identity=:ident")
  WorkflowEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM WorkflowEntity ug where ug.identity in :identlist")
  List<WorkflowEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);

  @Query("delete FROM WorkflowFileEntity ug where ug.workflowId=wid")
  List<WorkflowEntity> deleteAllWorkflowFiles(@Param("wid") Long workflowId);

  @Query("delete FROM WorkflowActionEntity ug where ug.workflowId=wid")
  List<WorkflowEntity> deleteAllWorkflowActions(@Param("wid") Long workflowId);
}