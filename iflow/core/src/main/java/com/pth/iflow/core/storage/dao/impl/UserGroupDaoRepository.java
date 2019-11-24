package com.pth.iflow.core.storage.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.UserGroupEntity;

/*public interface UserGroupDaoRepository extends CrudRepository<UserGroupEntity, Long> {
  @Query("SELECT user_group.*,companies.identity as company_identity  FROM user_group inner join companies on user_group.company_id=companies.id where user_group.identity=:identity")
  UserGroupEntity findByIdentity(@Param(":identity") String identity);

  @Query("SELECT user_group.*,companies.identity as company_identity  FROM user_group inner join companies on user_group.company_id=companies.id where companies.identity=:identity")
  List<UserGroupEntity> findAllByCompanyIdentity(@Param(":identity") String identity);

}*/

@Repository
public interface UserGroupDaoRepository extends JpaRepository<UserGroupEntity, Integer> {

}