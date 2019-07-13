package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.User;

public interface IUsersService {

  User getUserByEmail(final String email) throws ProfileCustomizedException, MalformedURLException;

  User getUserById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<User> getUserListByComaonyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException;
}
