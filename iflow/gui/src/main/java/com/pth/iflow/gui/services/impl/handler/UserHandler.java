package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IUserHandler;

@Service
public class UserHandler implements IUserHandler {

  private final IUserAccess userAccess;

  public UserHandler(@Autowired final IUserAccess userAccess) {

    this.userAccess = userAccess;

  }

  @Override
  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.userAccess.saveUser(user);
  }

  @Override
  public List<User> getCompanyUserList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.userAccess.getCompanyUserList(companyIdentity);
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.userAccess.deleteUser(user);

  }

}
