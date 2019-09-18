package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiUser;

public interface IUserAccess {

  public GuiUser readUser(final Long userId) throws GuiCustomizedException, MalformedURLException;

  public GuiUser saveUser(final GuiUser user) throws GuiCustomizedException, MalformedURLException;

  public List<GuiUser> getCompanyUserList(final Long companyId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

}
