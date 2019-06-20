package com.pth.iflow.core.service;

import java.util.List;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;

public interface IUserGroupService {

  public UserGroup getById(final Long id);

  public List<UserGroup> getListByIdList(final List<Long> idList);

  public List<UserGroup> getListByIdCompanyId(final Long companyId);

  public List<User> listGroupUsers(final Long id);
}
