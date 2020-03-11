package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EApplication;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.UserDashboardMenu;
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

    final User savedUser = this.userAccess.saveUser(user);
    return savedUser;
  }

  @Override
  public List<User> getCompanyUserList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.userAccess.getCompanyUserList(companyIdentity);
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.userAccess.deleteUser(user);
    this.userAccess.deleteAuthenticate(user);

  }

  @Override
  public User saveUserPassword(final User user, final boolean resetPassword) throws GuiCustomizedException, MalformedURLException {

    if (resetPassword) {
      final String newPassword = this.getStringFirstUpper(user.getFirstName()) + this.getStringFirstUpper(user.getLastName()) + "12345!#";
      user.setPassword(newPassword);
    }

    this.userAccess.resetUserPassword(user);
    return user;
  }

  private String getStringFirstUpper(final String substring) {

    String res = substring.toLowerCase();
    res = res.length() > 3 ? res.substring(0, 3) : res;

    final String preparedText = res.substring(0, 1).toUpperCase() + res.substring(1, res.length());
    return preparedText;
  }

  @Override
  public List<UserDashboardMenu> saveUserDashboardMenus(final List<UserDashboardMenu> userDashboardMenuList, final String userIdentity)
      throws GuiCustomizedException, MalformedURLException {

    for (final UserDashboardMenu item : userDashboardMenuList) {
      item.setAppId(EApplication.IFLOW.getIdentity());
      item.setUserIdentity(userIdentity);

    }

    final List<
        UserDashboardMenu> resultList = this.userAccess.saveUserDashboardMenus(userDashboardMenuList, EApplication.IFLOW.getIdentity());

    return resultList;
  }

}
