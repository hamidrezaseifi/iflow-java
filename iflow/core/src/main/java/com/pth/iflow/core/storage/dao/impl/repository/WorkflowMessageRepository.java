package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;

@Repository
public interface WorkflowMessageRepository extends JpaRepository<WorkflowMessageEntity, Long> {

  @Query("SELECT ug FROM WorkflowMessageEntity ug where ug.workflow.identity=:wident and ug.step.identity=:sident")
  WorkflowMessageEntity findByWorkflowAndStep(@Param("wident") String workflowIdentity, @Param("sident") String stepIdentity);

  @Query("SELECT ug FROM WorkflowMessageEntity ug inner join UserEntity ut on ug.userId=ut.id where ut.email=:uident")
  List<WorkflowMessageEntity> findUserWorkflowMessages(@Param("uident") String userIdentity);

  @Query("SELECT ug FROM WorkflowMessageEntity ug inner join UserEntity ut on ug.userId=ut.id where ut.email=:uident and ug.status in :statuslist and TIMESTAMPDIFF(DAY, created_at, now()) < expire_days")
  List<WorkflowMessageEntity> findNotExpiredUserWorkflowMessagesByStatus(@Param("uident") String userIdentity,
      @Param("statuslist") Collection<Integer> statusList);

  @Query("SELECT ug FROM WorkflowMessageEntity ug inner join WorkflowEntity w on ug.workflowId=w.id where w.identity=:wident and ug.status in :statuslist and TIMESTAMPDIFF(DAY, created_at, now()) < expire_days")
  List<WorkflowMessageEntity> findNotExpiredWorkflowWorkflowMessagesByStatus(@Param("wident") String userIdentity,
      @Param("statuslist") Collection<Integer> statusList);

}