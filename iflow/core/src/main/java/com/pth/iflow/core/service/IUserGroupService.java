package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.UserGroup;

public interface IUserGroupService {

  UserGroup save(UserGroup model);

  UserGroup getByIdentity(final String identity);

  List<UserGroup> getListByIdentityList(final Set<String> idList);

  List<UserGroup> getListByIdCompanyIdentity(final String companyIdentity);
}
