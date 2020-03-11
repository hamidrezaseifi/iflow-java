package com.pth.iflow.profile.service.handler;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserDashboardMenu;
import com.pth.iflow.profile.model.UserPasswordChangeRequest;

public interface IUsersHandlerService {

  User getUserByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  ProfileResponse getUserProfileByIdentity(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  void deleteUser(User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  void resetUserPassword(UserPasswordChangeRequest request);

  void deleteUserAuthentication(UserPasswordChangeRequest request);

  List<UserDashboardMenu> getUserDashboardMenuListByUserIdentity(String identity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  List<UserDashboardMenu> saveUserDashboardMenuListByUserIdentity(String identity, List<UserDashboardMenu> requestedModelList)
      throws MalformedURLException, IFlowMessageConversionFailureException;

}
