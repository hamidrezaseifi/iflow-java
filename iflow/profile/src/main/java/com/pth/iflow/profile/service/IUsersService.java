package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;

public interface IUsersService {

  User getUserByIdentity(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse getUserProfileByIdentity(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
