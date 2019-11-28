package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;

@Repository
public interface WorkflowTypeStepRepository extends JpaRepository<WorkflowTypeStepEntity, Long> {

  @Query("SELECT ug FROM WorkflowTypeStepEntity ug where ug.identity=:ident")
  WorkflowTypeStepEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM WorkflowTypeStepEntity ug inner join WorkflowTypeEntity wt on wt.id=ug.workflowTypeId where wt.identity=:ident")
  List<WorkflowTypeStepEntity> findAllByWorkflowTypeIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM WorkflowTypeStepEntity ug where ug.identity in :identlist")
  List<WorkflowTypeStepEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}