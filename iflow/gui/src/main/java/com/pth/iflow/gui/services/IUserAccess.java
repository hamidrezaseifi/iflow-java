package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.User;

public interface IUserAccess {

  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException;

  public List<User> getCompanyUserList(final String companyIdentity) throws MalformedURLException, IFlowMessageConversionFailureException;

  public void deleteUser(User user) throws MalformedURLException, IFlowMessageConversionFailureException;

}
