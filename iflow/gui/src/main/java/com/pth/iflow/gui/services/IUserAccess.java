package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserDashboardMenu;

public interface IUserAccess {

  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<User> getCompanyUserList(final String companyIdentity) throws MalformedURLException, IFlowMessageConversionFailureException;

  public void deleteUser(User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  public void resetUserPassword(User user) throws GuiCustomizedException, MalformedURLException;

  public void deleteAuthenticate(User user) throws GuiCustomizedException, MalformedURLException;

  public List<UserDashboardMenu> saveUserDashboardMenus(List<UserDashboardMenu> userDashboardMenuList, String appIdentity);

}
