package com.pth.iflow.core.storage.dao.impl.repository.workflow;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;

@Repository
public interface InvoiceWorkflowRepository extends JpaRepository<InvoiceWorkflowEntity, Long> {

  @Query("SELECT ug FROM InvoiceWorkflowEntity ug where ug.identity=:ident")
  InvoiceWorkflowEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM InvoiceWorkflowEntity ug where ug.identity in :identlist")
  List<InvoiceWorkflowEntity> findAllByIdentityList(@Param("identlist") Collection<String> identityList);
}