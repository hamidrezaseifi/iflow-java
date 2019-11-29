package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.UserGroupEntity;

public interface IUserGroupService {

  UserGroupEntity save(UserGroupEntity model);

  UserGroupEntity getByIdentity(final String identity);

  List<UserGroupEntity> getListByIdentityList(final Collection<String> idList);

  List<UserGroupEntity> getListByIdCompanyIdentity(final String companyIdentity);
}
