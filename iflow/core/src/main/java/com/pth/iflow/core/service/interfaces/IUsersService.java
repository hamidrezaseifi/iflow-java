package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUsersService {

  UserEntity save(UserEntity model);

  UserEntity getUserByEmail(final String email);

  ProfileResponse getProfileResponseByEmail(final String email);

  List<UserGroupEntity> getUserGroups(final String identity);

  List<DepartmentEntity> getUserDepartments(final String identity);

  List<DepartmentGroupEntity> getUserDepartmentGroups(final String identity);

  List<UserEntity> getUserDeputies(final String identity);

  List<UserEntity> getCompanyUsers(final String companyIdentity);

  List<UserEntity> getAllUserIdentityListByDepartmentId(final String identity) throws IFlowStorageException;

  List<UserEntity> getAllUserIdentityListByDepartmentGroupId(final String identity) throws IFlowStorageException;

}
