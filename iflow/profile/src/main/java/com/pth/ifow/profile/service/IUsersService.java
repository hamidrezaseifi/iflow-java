package com.pth.ifow.profile.service;

import java.net.MalformedURLException;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.User;

public interface IUsersService {

  User getUserByEmail(final String email) throws ProfileCustomizedException, MalformedURLException;
}
