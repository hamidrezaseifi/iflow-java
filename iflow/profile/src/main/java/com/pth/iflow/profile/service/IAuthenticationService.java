package com.pth.iflow.profile.service;

import java.net.URISyntaxException;

import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.UserAuthenticationRequest;

public interface IAuthenticationService {

  UserAuthenticationRequest authenticate(final UserAuthenticationRequest user) throws ProfileCustomizedException, URISyntaxException;
}
