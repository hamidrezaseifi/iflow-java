package com.pth.iflow.gui.services;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.ProfileResponse;
import com.pth.iflow.gui.models.UserAuthenticationResponse;

public interface IProfileAccess {

  UserAuthenticationResponse authenticate(String username, String password, String companyIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse readProfile(String username, String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse isTokenValid(String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
