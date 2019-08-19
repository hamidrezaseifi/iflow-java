package com.pth.iflow.backend.services;

import java.net.MalformedURLException;

import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.models.GuiUserAuthenticationResponse;

public interface IProfileAccess {

  GuiUserAuthenticationResponse authenticate(String username, String password, String companyIdentity)
      throws GuiCustomizedException, MalformedURLException;

  ProfileResponse readProfile(String username, String token) throws GuiCustomizedException, MalformedURLException;

  ProfileResponse isTokenValid(String token) throws GuiCustomizedException, MalformedURLException;
}
