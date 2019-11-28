package com.pth.iflow.core.storage.dao.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;

@Repository
public interface WorkflowMessageRepository extends JpaRepository<WorkflowMessageEntity, Long> {

  @Query("SELECT ug FROM WorkflowMessageEntity ug where ug.identity=:ident")
  WorkflowMessageEntity findByWorkflowAndStep(@Param("wident") String workflowIdentity, @Param("sident") String stepIdentity);

}