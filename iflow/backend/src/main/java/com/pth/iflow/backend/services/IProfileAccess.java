package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.models.UserAuthenticationResponse;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public interface IProfileAccess {

  UserAuthenticationResponse authenticate(String username, String password, String companyIdentity) throws BackendCustomizedException, MalformedURLException;

  ProfileResponse readProfile(String username, String token) throws BackendCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse isTokenValid(String token) throws BackendCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
