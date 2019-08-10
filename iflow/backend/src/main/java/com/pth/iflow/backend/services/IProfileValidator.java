package com.pth.iflow.backend.services;

import java.net.MalformedURLException;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.models.UserAuthenticationResponse;

public interface IProfileValidator {

  UserAuthenticationResponse authenticate(String username, String password, String companyIdentity)
      throws BackendCustomizedException, MalformedURLException;

  ProfileResponse isTokenValid(String token) throws BackendCustomizedException, MalformedURLException;
}
