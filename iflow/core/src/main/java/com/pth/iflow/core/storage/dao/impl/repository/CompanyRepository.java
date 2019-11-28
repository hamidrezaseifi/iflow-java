package com.pth.iflow.core.storage.dao.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

  @Query("SELECT ug FROM CompanyEntity ug where ug.identity=:ident")
  CompanyEntity findByIdentity(@Param("ident") String identity);

  @Query("SELECT ug FROM CompanyEntity ug where ug.company.identity=:ident")
  List<CompanyEntity> findAllByCompanyIdentity(@Param("ident") String identity);
}