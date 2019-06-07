package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationRequest;

public interface IUsersService {

  User getUserByEmail(final UserAuthenticationRequest user)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException;
}
