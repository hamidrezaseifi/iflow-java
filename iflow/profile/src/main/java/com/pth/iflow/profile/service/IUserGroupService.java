package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.UserGroup;

public interface IUserGroupService {

  UserGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<UserGroup> getListByCompanyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException;
}
