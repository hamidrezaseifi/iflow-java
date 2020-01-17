package com.pth.iflow.profile.service;

import com.pth.iflow.profile.model.UserAuthenticationRequest;

public interface IAuthenticationService {

  UserAuthenticationRequest authenticate(final UserAuthenticationRequest user);

  UserAuthenticationRequest setAuthentication(final UserAuthenticationRequest user);
}
