package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.User;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public interface IUserAccess {

  User readUser(final String userId) throws BackendCustomizedException, MalformedURLException;

  User saveUser(final User user) throws BackendCustomizedException, MalformedURLException;

  List<User> readCompanyUserList(final String companyId) throws MalformedURLException, IFlowMessageConversionFailureException;

}
