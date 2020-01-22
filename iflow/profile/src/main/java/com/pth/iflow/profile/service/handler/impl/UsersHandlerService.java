package com.pth.iflow.profile.service.handler.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.IUsersHandlerService;

@Service
public class UsersHandlerService implements IUsersHandlerService {

  private final IUsersAccessService usersService;

  public UsersHandlerService(@Autowired final IUsersAccessService usersService) {

    this.usersService = usersService;
  }

  @Override
  public User getUserByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserByIdentity(identity);
  }

  @Override
  public List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserListByCompanyIdentity(companyId);
  }

  @Override
  public ProfileResponse getUserProfileByIdentity(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserProfileByIdentity(email);
  }

  @Override
  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.saveUser(user);
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.usersService.deleteUser(user);

  }

}
