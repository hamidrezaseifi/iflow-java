package com.pth.iflow.core.service;

import java.util.List;
import java.util.Set;
import com.pth.iflow.core.model.UserGroup;

public interface IUserGroupService {

  UserGroup save(UserGroup model);

  UserGroup getById(final Long id);

  List<UserGroup> getListByIdList(final Set<Long> idList);

  List<UserGroup> getListByIdentityList(final Set<String> idList);

  List<UserGroup> getListByIdCompanyId(final Long companyId);
}
