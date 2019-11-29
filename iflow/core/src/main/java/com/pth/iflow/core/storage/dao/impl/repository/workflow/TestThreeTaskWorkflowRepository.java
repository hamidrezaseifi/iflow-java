package com.pth.iflow.core.storage.dao.impl.repository.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;

@Repository
public interface TestThreeTaskWorkflowRepository extends JpaRepository<TestThreeTaskWorkflowEntity, Long> {

  @Query("SELECT ug FROM TestThreeTaskWorkflowEntity ug where ug.workflow.identity=:ident")
  TestThreeTaskWorkflowEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM TestThreeTaskWorkflowEntity ug where ug.workflow.identity in :identlist")
  List<TestThreeTaskWorkflowEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}