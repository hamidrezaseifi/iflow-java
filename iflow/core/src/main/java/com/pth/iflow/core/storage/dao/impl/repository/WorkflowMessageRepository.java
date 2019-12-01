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

  @Query("SELECT msg FROM WorkflowMessageEntity msg where msg.workflow.identity=:wident and msg.step.identity=:sident")
  WorkflowMessageEntity findByWorkflowAndStep(@Param("wident") String workflowIdentity, @Param("sident") String stepIdentity);

  @Query("SELECT msg FROM WorkflowMessageEntity msg inner join UserEntity ut on msg.userId=ut.id where ut.email=:uident")
  List<WorkflowMessageEntity> findUserWorkflowMessages(@Param("uident") String userIdentity);

  @Query("SELECT msg FROM WorkflowMessageEntity msg inner join UserEntity ut on msg.userId=ut.id where ut.email=:uident and msg.status in :statuslist and TIMESTAMPDIFF(DAY, msg.createdAt, now()) < msg.expireDays")
  List<WorkflowMessageEntity> findNotExpiredUserWorkflowMessagesByStatus(@Param("uident") String userIdentity,
      @Param("statuslist") Collection<Integer> statusList);

  @Query("SELECT msg FROM WorkflowMessageEntity msg inner join WorkflowEntity w on msg.workflow.id=w.id where w.identity=:wident and msg.status in :statuslist and TIMESTAMPDIFF(DAY, msg.createdAt, now()) < msg.expireDays")
  List<WorkflowMessageEntity> findNotExpiredWorkflowWorkflowMessagesByStatus(@Param("wident") String userIdentity,
      @Param("statuslist") Collection<Integer> statusList);

}