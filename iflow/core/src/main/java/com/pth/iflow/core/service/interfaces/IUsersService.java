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

  UserEntity getUserByIdentity(final String identity);

  UserEntity getUserByEmail(final String email);

  ProfileResponse getProfileResponseByEmail(final String email);

  ProfileResponse getProfileResponseByIdentity(final String identity);

  List<UserGroupEntity> getUserGroups(final String identity);

  List<DepartmentEntity> getUserDepartments(final String identity);

  List<UserEntity> getUserDeputies(final String identity);

  List<UserEntity> getCompanyUsers(final String companyIdentity);

  List<UserEntity> getAllUserIdentityListByDepartmentIdentity(final String identity) throws IFlowStorageException;

  List<UserEntity> getUserListByIdentityList(final Set<String> identityList) throws IFlowStorageException;

  ProfileResponseEdo toProfileResponseEdo(final ProfileResponse model);

  List<UserDashboardMenuEntity> getUserDashboardMenuListByUserIdentity(final String identity) throws IFlowStorageException;

  List<UserDashboardMenuEntity> saveUserDashboardMenuListByUserIdentity(String identity, List<UserDashboardMenuEntity> list)
      throws IFlowStorageException;

  List<UserDashboardMenuEdo> toUserDashboardMenuEdoList(final List<UserDashboardMenuEntity> modelList);

  List<UserDashboardMenuEntity> fromUserDashboardMenuEdoList(final List<UserDashboardMenuEdo> edoList)
      throws IFlowMessageConversionFailureException;

}
