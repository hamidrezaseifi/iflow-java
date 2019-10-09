package com.pth.iflow.core.service;

import java.util.Set;

import com.pth.iflow.core.model.UserGroup;

public interface IUserGroupService {

  UserGroup save(UserGroup model);

  UserGroup getById(final Long id);

  Set<UserGroup> getListByIdList(final Set<Long> idList);

  Set<UserGroup> getListByIdentityList(final Set<String> idList);

  Set<UserGroup> getListByIdCompanyId(final Long companyId);
}
