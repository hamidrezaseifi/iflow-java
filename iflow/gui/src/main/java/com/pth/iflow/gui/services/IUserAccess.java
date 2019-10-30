package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.User;

public interface IUserAccess {

  public User readUser(final String userId) throws GuiCustomizedException, MalformedURLException;

  public User saveUser(final User user) throws GuiCustomizedException, MalformedURLException;

  public List<User> getCompanyUserList(final String companyIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
