package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;

public interface IUserGroupService {

  UserGroup save(UserGroup model);

  UserGroup getById(final Long id);

  List<UserGroup> getListByIdList(final List<Long> idList);

  List<UserGroup> getListByIdCompanyId(final Long companyId);

  List<User> listGroupUsers(final Long id);
}
