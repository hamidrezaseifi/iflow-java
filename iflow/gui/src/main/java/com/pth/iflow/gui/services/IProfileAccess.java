package com.pth.iflow.gui.services;

import java.net.MalformedURLException;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiProfileResponse;
import com.pth.iflow.gui.models.GuiUserAuthenticationResponse;

public interface IProfileAccess {

  GuiUserAuthenticationResponse authenticate(String username, String password, String companyIdentity)
      throws GuiCustomizedException, MalformedURLException;

  GuiProfileResponse readProfile(String username, String token) throws GuiCustomizedException, MalformedURLException;

  GuiProfileResponse isTokenValid(String token) throws GuiCustomizedException, MalformedURLException;
}
