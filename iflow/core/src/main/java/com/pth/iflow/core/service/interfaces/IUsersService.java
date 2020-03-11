package com.pth.iflow.core.service.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserDashboardMenuEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserDashboardMenuEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUsersService extends ICoreModelEdoMapperService<UserEntity, UserEdo> {

  UserEntity save(UserEntity model);

  void delete(UserEntity model);

  UserEntity getUserByIdentity(String identity);

  UserEntity getUserByEmail(String email);

  ProfileResponse getProfileResponseByEmail(String email);

  ProfileResponse getProfileResponseByIdentity(String identity);

  List<UserGroupEntity> getUserGroups(String identity);

  List<DepartmentEntity> getUserDepartments(String identity);

  List<UserEntity> getUserDeputies(String identity);

  List<UserEntity> getCompanyUsers(String companyIdentity);

  List<UserEntity> getAllUserIdentityListByDepartmentIdentity(String identity) throws IFlowStorageException;

  List<UserEntity> getUserListByIdentityList(Set<String> identityList) throws IFlowStorageException;

  ProfileResponseEdo toProfileResponseEdo(ProfileResponse model);

  List<UserDashboardMenuEntity> getUserDashboardMenuListByUserIdentity(String appIdentity, String userIdentity)
      throws IFlowStorageException;

  List<UserDashboardMenuEntity> saveUserDashboardMenuListByUserIdentity(String appIdentity, String userIdentity,
      List<UserDashboardMenuEntity> list)
      throws IFlowStorageException;

  List<UserDashboardMenuEdo> toUserDashboardMenuEdoList(List<UserDashboardMenuEntity> modelList);

  List<UserDashboardMenuEntity> fromUserDashboardMenuEdoList(List<UserDashboardMenuEdo> edoList)
      throws IFlowMessageConversionFailureException;

}
