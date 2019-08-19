package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuidUser;

public interface IUserAccess {

  GuidUser readUser(final Long userId) throws GuiCustomizedException, MalformedURLException;

  GuidUser saveUser(final GuidUser user) throws GuiCustomizedException, MalformedURLException;

  List<GuidUser> readCompanyUserList(final Long companyId) throws GuiCustomizedException, MalformedURLException;

}
