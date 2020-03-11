package com.pth.iflow.profile.service.access;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserDashboardMenu;

public interface IUsersAccessService {

  User getUserByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse getUserProfileByEmail(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse getUserProfileByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  void deleteUser(User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  List<UserDashboardMenu> getUserDashboardMenuListByUserIdentity(final String appIdentity, final String userIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  List<UserDashboardMenu> saveUserDashboardMenuListByUserIdentity(final String appIdentity, final String userIdentity,
      List<UserDashboardMenu> requestedModelList)
      throws MalformedURLException, IFlowMessageConversionFailureException;

}
