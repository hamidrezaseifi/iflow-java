package com.pth.ifow.profile.service;

import java.net.URISyntaxException;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.UserAuthenticationRequest;

public interface IAuthenticationService {

  UserAuthenticationRequest authenticate(final UserAuthenticationRequest user) throws ProfileCustomizedException, URISyntaxException;
}
