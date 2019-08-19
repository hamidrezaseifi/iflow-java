package com.pth.iflow.backend.services;

import java.net.MalformedURLException;

import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuiProfileResponse;
import com.pth.iflow.backend.models.GuiUserAuthenticationResponse;

public interface IProfileAccess {

  GuiUserAuthenticationResponse authenticate(String username, String password, String companyIdentity)
      throws GuiCustomizedException, MalformedURLException;

  GuiProfileResponse readProfile(String username, String token) throws GuiCustomizedException, MalformedURLException;

  GuiProfileResponse isTokenValid(String token) throws GuiCustomizedException, MalformedURLException;
}
