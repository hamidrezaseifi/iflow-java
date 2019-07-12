package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.UserGroup;

public interface IUserGroupService {

  UserGroup getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<UserGroup> getListByComaonyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException;
}
